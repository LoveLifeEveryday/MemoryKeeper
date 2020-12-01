package com.xcynice.memorykeeper.module.mine.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.module.mine.view.IForgetPasswordView;

/**
 * @author : xucanyou666
 * @date : 2020/12/1 11:08
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class ForgetPasswordPresenter extends BasePresenter<IForgetPasswordView> {
    public ForgetPasswordPresenter(IForgetPasswordView baseView) {
        super(baseView);
    }

    public void changePassword(String password, String repassword, String phone) {
        addDisposable(apiServer.changePassword(password, repassword, phone, "1231"), new BaseObserver<BaseBean<String>>(baseView, true) {
            
            @Override
            public void onSuccess(BaseBean<String> o) {
                baseView.changePasswordSuccess(o.msg);
            }

            @Override
            public void onError(String msg) {
                baseView.changePasswordFail(msg);
            }
        });
    }
}
