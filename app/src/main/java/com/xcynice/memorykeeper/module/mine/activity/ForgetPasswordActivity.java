package com.xcynice.memorykeeper.module.mine.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.module.mine.presenter.ForgetPasswordPresenter;
import com.xcynice.memorykeeper.module.mine.view.IForgetPasswordView;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xucanyou666
 * @date 2020/12/1
 * @github https://github.com/LoveLifeEveryday
 * @juejin https://juejin.im/user/325111175192590/posts
 * @description : ForgetPasswordActivity
 */


public class ForgetPasswordActivity extends BaseActivity<ForgetPasswordPresenter> implements IForgetPasswordView {
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.et_repassword)
    EditText mEtRepassword;
    @BindView(R.id.btn_change)
    Button mBtnChange;

    @Override
    protected ForgetPasswordPresenter createPresenter() {
        return new ForgetPasswordPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).titleBar(mLlTitle).init();
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.btn_change})
    public void registerBtn() {

        presenter.changePassword(mEtPassword.getText().toString()
                , mEtRepassword.getText().toString()
                , mEtPhone.getText().toString());
    }


    @Override
    public void changePasswordSuccess(String msg) {
        ToastUtil.showCenterToast(msg);
        finish();
    }
    @OnClick({R.id.title_bar_return})
    public void back() {
        finish();
    }


    @Override
    public void changePasswordFail(String msg) {
        ToastUtil.showCenterToast(msg);
    }
}