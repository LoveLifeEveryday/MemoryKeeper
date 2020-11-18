package com.xcynice.memorykeeper.module.mine.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.module.mine.view.ILoginView;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 10:33
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    public LoginPresenter(ILoginView baseView) {
        super(baseView);
    }

    public void login(String password, String phone) {
        addDisposable(apiServer.login(password, phone, "1231"), new BaseObserver<BaseBean<String>>(baseView, true) {


            @Override
            public void onSuccess(BaseBean<String> o) {
                baseView.loginSuccess("登陆成功");
            }

            @Override
            public void onError(String msg) {
                baseView.loginFail("登陆失败");

            }
        });
    }
}
