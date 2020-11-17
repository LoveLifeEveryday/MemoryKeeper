package com.xcynice.memorykeeper.module.CreateBag.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.module.CreateBag.view.ICreateBagView;

/**
 * @Description: 新建卡包的presenter
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 9:07
 */
public class CreateBagPresenter extends BasePresenter<ICreateBagView> {

    public CreateBagPresenter(ICreateBagView baseView) {
        super(baseView);
    }

    /**
     *  新建卡包
     * @param cardBag
     */
    public void createNewCardBag(CardBag cardBag){
        addDisposable(apiServer.createNewCardBag(cardBag), new BaseObserver<BaseBean<CardBag>>(baseView) {

            /**
             * 完成
             *
             * @param o 对象
             */
            @Override
            public void onSuccess(BaseBean<CardBag> o) {


            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
