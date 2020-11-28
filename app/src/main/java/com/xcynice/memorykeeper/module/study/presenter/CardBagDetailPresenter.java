package com.xcynice.memorykeeper.module.study.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.UpdateCardBag;
import com.xcynice.memorykeeper.module.study.view.ICardBagDetailView;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/28 16:37
 */
public class CardBagDetailPresenter extends BasePresenter<ICardBagDetailView> {

    public CardBagDetailPresenter(ICardBagDetailView baseView) {
        super(baseView);
    }


    /**
     * 通过卡片id删除卡包
     * @param id
     */
    public void deleteCardBag(String id) {
        addDisposable(apiServer.deleteCardBag(id),new BaseObserver<BaseBean<String>>(baseView){

            /**
             * 完成
             *
             * @param o 对象
             */
            @Override
            public void onSuccess(BaseBean<String> o) {
                baseView.success(o.msg);
            }

            /**
             * 失败
             *
             * @param msg 失败信息
             */
            @Override
            public void onError(String msg) {
                baseView.failure(msg);
            }
        });
    }

    /**
     * 更新卡包
     * @param id
     * @param updateCardBag
     */
    public void updateCardBag(String id, UpdateCardBag updateCardBag){
        addDisposable(apiServer.updateCardBag(id,updateCardBag), new BaseObserver<BaseBean<String>>(baseView) {
            /**
             * 完成
             *
             * @param o 对象
             */
            @Override
            public void onSuccess(BaseBean<String> o) {
                baseView.success(o.msg);
            }

            /**
             * 失败
             *
             * @param msg 失败信息
             */
            @Override
            public void onError(String msg) {
                baseView.failure(msg);
            }
        });
    }


}
