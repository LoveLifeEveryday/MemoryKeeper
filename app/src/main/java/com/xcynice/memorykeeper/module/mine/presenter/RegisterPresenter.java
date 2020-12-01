package com.xcynice.memorykeeper.module.mine.presenter;

import com.google.gson.Gson;
import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.User;
import com.xcynice.memorykeeper.module.mine.view.IRegisterView;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author : xucanyou666
 * @date : 2020/12/1 10:41
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description : 注册 presenter
 */
public class RegisterPresenter extends BasePresenter<IRegisterView> {

    private Gson gson = new Gson();

    public RegisterPresenter(IRegisterView baseView) {
        super(baseView);
    }


    /**
     * 注册
     *
     * @param user       用户信息
     * @param repassword 密码
     */
    public void register(User user, String repassword) {
        String json = gson.toJson(user);
        //noinspection deprecation
        RequestBody responseBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        addDisposable(apiServer.register(responseBody, repassword, "1231"), new BaseObserver<BaseBean<String>>(baseView, true) {




            @Override
            public void onSuccess(BaseBean<String> o) {
          baseView.registerSuccess(o.msg);
            }

            @Override
            public void onError(String msg) {
                baseView.registerFail(msg);
            }
        });
    }
}
