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

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;
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
        ImmersionBar.with(this).titleBar(mConstraintLayout).init();
        //获取id
        Bundle bundle = CardBagDetailActivity.this.getIntent().getExtras();
        String id = bundle.getString("id");
        Log.d(TAG, id);

        presenter.deleteCardBag(id);

        mBackIv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "点击了返回");
            }
        });
        mBtnDeleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "点击了删除");
            }
        });


    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_bag_detail);
    }

    @Override
    public void deleteSuccess(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void deleteFailure(String msg) {
        ToastUtil.showToast(msg);
    }





}