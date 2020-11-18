package com.xcynice.memorykeeper.module.mine.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.Test;
import com.xcynice.memorykeeper.bean.UserInfo;
import com.xcynice.memorykeeper.module.mine.view.IMineView;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 10:59
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class MinePresenter extends BasePresenter<IMineView> {
    public MinePresenter(IMineView baseView) {
        super(baseView);
    }


    public void getUserInfo() {
        addDisposable(apiServer.getUserInfo(), new BaseObserver<BaseBean<UserInfo>>(baseView) {

            @Override
            public void onSuccess(BaseBean<UserInfo> o) {
                baseView.getUserInfoSuccess(o.data);
            }

            @Override
            public void onError(String msg) {
                baseView.getUserInfoFail(msg);
            }
        });
    }


    public void test(){
        addDisposable(apiServer.test(), new BaseObserver<BaseBean<Test>>(baseView) {


            @Override
            public void onSuccess(BaseBean<Test> o) {
                baseView.testSuccess(o.data);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
