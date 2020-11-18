package com.xcynice.memorykeeper.module.mine.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.module.mine.presenter.LoginPresenter;
import com.xcynice.memorykeeper.module.mine.view.ILoginView;
import com.xcynice.memorykeeper.util.ActivityUtil;
import com.xcynice.memorykeeper.util.SpUtil;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.xcynice.memorykeeper.util.SpUtil.IS_LOGIN;

/**
 * @author xucanyou666
 * @date 2020/11/18
 * @github https://github.com/LoveLifeEveryday
 * @juejin https://juejin.im/user/325111175192590/posts
 * @description : LoginActivity
 */


public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.tv_forget_password)
    TextView mTvForgetPasword;
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //沉浸式标题栏
        ImmersionBar.with(this).titleBar(mLlTitle).init();

    }

    @Override
    protected void initData() {

    }


    @Override
    public void loginSuccess(String msg) {
        SpUtil.setBoolean(IS_LOGIN, true);
        finish();
    }

    @Override
    public void loginFail(String msg) {
        ToastUtil.showToast(msg);
    }

    @OnClick({R.id.title_bar_return})
    public void back() {
        finish();
    }

    @OnClick({R.id.btn_login})
    public void loginBtn() {
        presenter.login(mEtPassword.getText().toString(), mEtPhone.getText().toString());
    }

    @OnClick({R.id.tv_register})
    public void goRegister() {
        ActivityUtil.startActivity(ResgisterActivity.class);
    }


    @OnClick(R.id.tv_forget_password)
    public void goForget(){
        ActivityUtil.startActivity(ForgetPasswordActivity.class);
    }
}