package com.xcynice.memorykeeper.module.CreateBag.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.gyf.immersionbar.ImmersionBar;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.module.CreateBag.presenter.CreateBagPresenter;
import com.xcynice.memorykeeper.module.CreateBag.view.ICreateBagView;
import com.xcynice.memorykeeper.util.LogUtil;
import com.xcynice.memorykeeper.util.ToastUtil;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

import butterknife.BindView;

/**
 * @author Yuki-r
 * @date on 2020/11/17
 * @describle 新建卡包的Activity
 */
public class CreateCardActivity extends BaseActivity<CreateBagPresenter> implements ICreateBagView, View.OnClickListener {


    private ImageView mCancelBackBtn;
    private ImageView mCreateCardPortraitImage;
    private String mPortraitUri;
    private EditText mCreateCardNameEdit;
    private EditText mCreateCardBriefIntroductionEdit;
    private TextView mCreateCardToCreateTv;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch mCreateCardIfPublicSwitch;
    private TextView mRemainedWordsTv;
    private Boolean ifPublic = false;
    private final int REQUEST_CODE_CHOOSE = 115;
    private List<Uri> mSelected;
    private RxPermissions rxPermissions;
    @BindView(R.id.constraintLayout)
    ConstraintLayout mClTitle;

    /**
     * 创建 presenter
     *
     * @return presenter
     */
    @Override
    protected CreateBagPresenter createPresenter() {
        return new CreateBagPresenter(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_card;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(mClTitle).init();
        rxPermissions = new RxPermissions(this);
        mCancelBackBtn = findViewById(R.id.refresh_iv);
        mCreateCardPortraitImage = findViewById(R.id.create_card_portrait_image);
        mCreateCardNameEdit = findViewById(R.id.create_card_name_tv);
        mCreateCardBriefIntroductionEdit = findViewById(R.id.create_card_brief_introduction_edit);
        mCreateCardToCreateTv = findViewById(R.id.create_card_to_create_tv);
        mCreateCardIfPublicSwitch = findViewById(R.id.create_card_if_public_switch);
        mRemainedWordsTv = findViewById(R.id.remained_words_tv);
        calculateEditCost();
        // 监听Switch
        mCreateCardIfPublicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ifPublic = true;
                } else {
                    ifPublic = false;
                }
            }
        });
        mCreateCardPortraitImage.setOnClickListener(this);
        mCreateCardToCreateTv.setOnClickListener(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 计算字数
     */
    private void calculateEditCost() {
        //记录字数上限
        int wordLimitNum = 100;
        mCreateCardBriefIntroductionEdit.addTextChangedListener(new TextWatcher() {
            //记录输入的字数
            private CharSequence enterWords;
            private int selectionStart;
            private int selectionEnd;
            private int enteredWords;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //实时记录输入的字数
                enterWords = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                //已输入字数
                enteredWords = wordLimitNum - s.length();
                //TextView显示剩余字数
                mRemainedWordsTv.setText(100 - enteredWords + "/100字");
                selectionStart = mCreateCardBriefIntroductionEdit.getSelectionStart();
                selectionEnd = mCreateCardBriefIntroductionEdit.getSelectionEnd();
                if (enterWords.length() > wordLimitNum) {
                    //删除多余输入的字（不会显示出来）
                    s.delete(selectionStart - 1, selectionEnd);
                    int tempSelection = selectionEnd;
                    mCreateCardBriefIntroductionEdit.setText(s);
                    //设置光标在最后
                    mCreateCardBriefIntroductionEdit.setSelection(tempSelection);
                }
            }
        });
    }


    /**
     * 新建卡包
     *
     * @param cardBag 卡包实例
     */
    @Override
    public void createNewCardBag(CardBag cardBag) {

    }

    /**
     * 获取卡包对象
     */
    @Override
    public CardBag getCardBag() {

        String cardName = mCreateCardNameEdit.getText().toString();
        String cardInfo = mCreateCardBriefIntroductionEdit.getText().toString();
        CardBag cardBag = new CardBag();
        cardBag.setPic(mPortraitUri);
        cardBag.setName(cardName);
        cardBag.setInfo(cardInfo);
        cardBag.setIfPrivate(ifPublic);
        return cardBag;


    }

    /**
     * 获取图片
     */
    @SuppressLint("CheckResult")
    @Override
    public void getImage() {
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        Matisse.from(CreateCardActivity.this)
                                .choose(MimeType.ofImage())
                                .countable(false)
                                .maxSelectable(1)
                                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                                .thumbnailScale(0.85f)
                                .imageEngine(new GlideEngine())
                                .forResult(REQUEST_CODE_CHOOSE);
                    } else {
                        //拒绝权限申请
                        Toast.makeText(CreateCardActivity.this, "未授权权限，部分功能不能使用", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * 新建卡包成功
     */
    @Override
    public void onSuccess() {
        ToastUtil.showCenterToast("新建成功");

    }

    /**
     * 获取卡包失败
     */
    @Override
    public void onFailure(String errorMsg) {
        ToastUtil.showCenterToast(errorMsg);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data); //获取宣主任图片的路径
            Glide.with(this).load(mSelected.get(0)).into(mCreateCardPortraitImage); //加载图片
            mPortraitUri = mSelected.get(0).toString();
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_card_portrait_image:
                getImage();
                break;
            case R.id.create_card_to_create_tv:
                LogUtil.d("点击了按钮");
                if (mPortraitUri == null) {
                    ToastUtil.showCenterToast("头像不能为空");
                    return;
                }
                if (mCreateCardNameEdit.getText().toString().equals("")) {
                    ToastUtil.showCenterToast("卡包名称不能为空");
                    return;
                }
                if (mCreateCardBriefIntroductionEdit.getText().toString().equals("")) {
                    ToastUtil.showCenterToast("卡包描述不能为空");
                    return;
                }
                CardBag cardBag = getCardBag();
                presenter.createNewCardBag(cardBag);
                break;
        }
    }
}