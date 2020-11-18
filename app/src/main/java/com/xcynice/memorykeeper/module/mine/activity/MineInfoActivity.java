package com.xcynice.memorykeeper.module.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.bean.UserInfo;
import com.xcynice.memorykeeper.module.mine.presenter.MinePresenter;
import com.xcynice.memorykeeper.module.mine.view.IMineView;
import com.xcynice.memorykeeper.util.SpUtil;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MineInfoActivity extends BaseActivity<MinePresenter> implements IMineView {
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;
    @BindView(R.id.title_bar_text)
    TextView mTvTitle;

    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.btn_logout)
    Button mBtnLogout;

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_info;
    }

    @Override
    protected void initView() {

        mTvTitle.setText("个人设置");
        ImmersionBar.with(this).titleBar(mLlTitle).init();
    }

    @Override
    protected void initData() {
        presenter.getUserInfo();
    }


    @Override
    public void getUserInfoFail(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void getUserInfoSuccess(UserInfo test) {
        mTvName.setText(test.getUserName());
        mTvPhone.setText(test.getPhone());
    }


    @OnClick(R.id.btn_logout)
    public void onViewClick() {
        SpUtil.setBoolean(SpUtil.IS_LOGIN, false);
        finish();
    }
    @OnClick(R.id.title_bar_return)
    public void back(){
        finish();
    }
}