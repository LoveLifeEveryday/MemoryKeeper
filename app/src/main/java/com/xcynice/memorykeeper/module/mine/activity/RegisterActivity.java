package com.xcynice.memorykeeper.module.mine.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.bean.User;
import com.xcynice.memorykeeper.module.mine.presenter.RegisterPresenter;
import com.xcynice.memorykeeper.module.mine.view.IRegisterView;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xucanyou666
 * @date 2020/11/18
 * @github https://github.com/LoveLifeEveryday
 * @juejin https://juejin.im/user/325111175192590/posts
 * @description : RegisterActivity
 */


public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegisterView {
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.et_repassword)
    EditText mEtRePassword;
    @BindView(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
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

    @OnClick({R.id.btn_register})
    public void registerBtn() {
        User user = new User();
        user.setAvatar("https://img95.699pic.com/photo/40100/6015.jpg_wh300.jpg");
        user.setPassword(mEtPassword.getText().toString());
        user.setPhone(mEtPhone.getText().toString());
        user.setUserName(mEtPhone.getText().toString());
        presenter.register(user, mEtRePassword.getText().toString());
    }

    @OnClick({R.id.title_bar_return})
    public void back() {
        finish();
    }


    @Override
    public void registerSuccess(String msg) {
        ToastUtil.showCenterToast("注册成功");
        finish();
    }

    @Override
    public void registerFail(String msg) {
        ToastUtil.showCenterToast("注册失败");
    }
}