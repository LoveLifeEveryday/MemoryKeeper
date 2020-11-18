package com.xcynice.memorykeeper.module.mine.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CollectList;
import com.xcynice.memorykeeper.module.mine.view.IMineCollectView;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 17:30
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class CollectListPresenter extends BasePresenter<IMineCollectView> {

    public CollectListPresenter(IMineCollectView baseView) {
        super(baseView);
    }


    public void getMineCollectList() {
        addDisposable(apiServer.getMineCollect(100 + "", 1 + ""), new BaseObserver<BaseBean<CollectList>>(baseView, true) {


            @Override
            public void onSuccess(BaseBean<CollectList> o) {
                baseView.getMineCollectSuccess(o.data);
            }

            @Override
            public void onError(String msg) {
                baseView.getMineCollectFail(msg);
            }
        });
    }
}
