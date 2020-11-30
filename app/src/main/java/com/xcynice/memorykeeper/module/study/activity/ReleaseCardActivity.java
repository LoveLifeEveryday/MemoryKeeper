package com.xcynice.memorykeeper.module.study.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.bean.Card;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.module.study.presenter.ReleaseCardPresenter;
import com.xcynice.memorykeeper.module.study.view.IReleaseCardView;
import com.xcynice.memorykeeper.util.ToastUtil;

public class ReleaseCardActivity extends BaseActivity<ReleaseCardPresenter> implements IReleaseCardView {
    private ConstraintLayout mConstraintLayout;
    private TextView mRefreshIv;
    private TextView mTextView5;
    private TextView mTextView6;
    private EditText mEditTextTextMultiLine;
    private TextView mTextView7;
    private EditText mEditTextTextMultiLine2;
    private TextView mTextView8;
    private EditText mEditTextTextMultiLine3;
    private ImageView mPostIv;

    private CardBag cardBag;


    /**
     * 创建 presenter
     *
     * @return presenter
     */
    @Override
    protected ReleaseCardPresenter createPresenter() {
        return new ReleaseCardPresenter(this);
    }

    /**
     * 得到布局文件 id
     *
     * @return layout id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_release_card;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mRefreshIv = findViewById(R.id.refresh_iv);
        mTextView5 = findViewById(R.id.textView5);
        mTextView6 = findViewById(R.id.textView6);
        mEditTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        mTextView7 = findViewById(R.id.textView7);
        mEditTextTextMultiLine2 = findViewById(R.id.editTextTextMultiLine2);
        mTextView8 = findViewById(R.id.textView8);
        mEditTextTextMultiLine3 = findViewById(R.id.editTextTextMultiLine3);
        mPostIv = findViewById(R.id.post_iv);
        ImmersionBar.with(this).titleBar(mConstraintLayout).init();
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            cardBag = (CardBag) bundle.getSerializable("cardBag");
        }
        mPostIv.setOnClickListener(new View.OnClickListener(){

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Card card = new Card();
                card.setCardBagId(cardBag.getCardBagId());
                card.setQuestion(mEditTextTextMultiLine.getText().toString());
                card.setAnswer(mEditTextTextMultiLine2.getText().toString());
                card.setMore(mEditTextTextMultiLine3.getText().toString());
                presenter.releaseCard(card);
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
    public void success(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void failure(String msg) {
        ToastUtil.showToast(msg);
    }
}