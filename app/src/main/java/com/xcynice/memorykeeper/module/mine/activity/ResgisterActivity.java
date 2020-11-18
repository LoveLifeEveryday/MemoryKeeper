package com.xcynice.memorykeeper.module.mine.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;

import butterknife.BindView;

/**
 * @author xucanyou666
 * @date 2020/11/18
 * @github https://github.com/LoveLifeEveryday
 * @juejin https://juejin.im/user/325111175192590/posts
 * @description : ResgisterActivity
 */


public class ResgisterActivity extends BaseActivity {
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resgister;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(mLlTitle).init();
    }

    @Override
    protected void initData() {

    }


}