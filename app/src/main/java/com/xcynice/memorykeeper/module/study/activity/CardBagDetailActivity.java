package com.xcynice.memorykeeper.module.study.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.UpdateCardBag;
import com.xcynice.memorykeeper.module.study.presenter.CardBagDetailPresenter;
import com.xcynice.memorykeeper.module.study.view.ICardBagDetailView;
import com.xcynice.memorykeeper.util.LogUtil;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;

public class CardBagDetailActivity extends BaseActivity<CardBagDetailPresenter> implements ICardBagDetailView {


    @BindView(R.id.back_iv)
    ImageView mBackIv;

    @BindView(R.id.btn_delete_card)
    Button mBtnDeleteCard;
    @BindView(R.id.constraintLayout)
    ConstraintLayout mConstraintLayout;


    private ConstraintLayout mConstraintLayout2;
    private ImageView mCreateCardPortraitImage;
    private TextView mTextView2;
    private TextView mTextView3;
    private EditText mCreateCardNameTv;
    private TextView mTextView4;
    private EditText mCreateCardBriefIntroductionEdit;
    private TextView mRemainedWordsTv;



    private TextView mUpdateTv;





    private  CardBag cardBag;



    private final String TAG = "CardBagDetailActivity";


    /**
     * 创建 presenter
     *
     * @return presenter
     */
    @Override
    protected CardBagDetailPresenter createPresenter() {
        return new CardBagDetailPresenter(this);
    }

    /**
     * 得到布局文件 id
     *
     * @return layout id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_card_bag_detail;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {



        mCreateCardPortraitImage = findViewById(R.id.create_card_portrait_image);
        mUpdateTv = findViewById(R.id.update_tv);

        mCreateCardNameTv = findViewById(R.id.create_card_name_tv);
        mCreateCardBriefIntroductionEdit = findViewById(R.id.create_card_brief_introduction_edit);
        mRemainedWordsTv = findViewById(R.id.remained_words_tv);
        mCreateCardPortraitImage = findViewById(R.id.create_card_portrait_image);
        mCreateCardNameTv = findViewById(R.id.create_card_name_tv);


        ImmersionBar.with(this).titleBar(mConstraintLayout).init();
        //获取id
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
             cardBag =(CardBag) bundle.getSerializable("cardBag");
        }










        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        mBtnDeleteCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.deleteCardBag(cardBag.getCardBagId());
            }
        });
        mUpdateTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = cardBag.getCardBagId();
                UpdateCardBag updateCardBag = new UpdateCardBag();
                updateCardBag.setName(mCreateCardNameTv.getText().toString());
                updateCardBag.setInfo(mCreateCardBriefIntroductionEdit.getText().toString());
                updateCardBag.setPic(cardBag.getPic());
                presenter.updateCardBag(id,updateCardBag);
            }
        });


    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        mCreateCardNameTv.setText(cardBag.getName());
        mCreateCardBriefIntroductionEdit.setText(cardBag.getInfo());
        Glide.with(this).load(cardBag.getPic()).into(mCreateCardPortraitImage);
    }



    @Override
    public void success(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void failure(String msg) {
        ToastUtil.showToast(msg);
    }





}