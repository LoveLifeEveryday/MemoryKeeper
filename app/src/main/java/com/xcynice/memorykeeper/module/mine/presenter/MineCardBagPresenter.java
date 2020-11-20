package com.xcynice.memorykeeper.module.mine.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.module.mine.view.IMineCardBagView;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 16:30
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class MineCardBagPresenter extends BasePresenter<IMineCardBagView> {
    public MineCardBagPresenter(IMineCardBagView baseView) {
        super(baseView);
    }


    public void getCardBagFirst() {
        addDisposable(apiServer.getCardBagList(10 + "", 1 + ""), new BaseObserver<BaseBean<CardBagList>>(baseView) {


            @Override
            public void onSuccess(BaseBean<CardBagList> o) {
                baseView.getCardBagFirstSuccess(o.data);
            }

            @Override
            public void onError(String msg) {
                baseView.getCardBagFail(msg);
            }
        });
    }

    public void getCardBagMore(int page) {
        addDisposable(apiServer.getCardBagList(10 + "", page + ""), new BaseObserver<BaseBean<CardBagList>>(baseView) {
            @Override
            public void onSuccess(BaseBean<CardBagList> o) {
                baseView.getCardBagMoreSuccess(o.data);
            }

            @Override
            public void onError(String msg) {
                baseView.getCardBagFail(msg);
            }
        });
    }
}
