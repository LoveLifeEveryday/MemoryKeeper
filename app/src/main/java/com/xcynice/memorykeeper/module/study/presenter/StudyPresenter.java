package com.xcynice.memorykeeper.module.study.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.module.study.view.IStudyView;

/**
 * @Description: 学习页面的Presenter
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 16:14
 */
public class StudyPresenter extends BasePresenter<IStudyView> {

    public StudyPresenter(IStudyView baseView) {
        super(baseView);
    }

    /**
     * 第一次获取卡包数据
     */
    public void getCardBagFirst(){
        getCardBagRefresh(true);
    }

    /**
     * 刷新获取卡包数据
     */
    public void getCardBagByRefresh(){
        getCardBagRefresh(false);
    }


    /**
     *  获取卡包列表
     * @param ifFirst 判断是第一次获取还是刷新获取
     */
    public void getCardBagRefresh(boolean ifFirst){
        //第一次获取
        if (ifFirst){
            addDisposable(apiServer.getCardBagList("5", "1"), new BaseObserver<BaseBean<CardBagList>>(baseView,true) {

                /**
                 * 完成
                 *
                 * @param o 对象
                 */
                @Override
                public void onSuccess(BaseBean<CardBagList> o) {
                    baseView.setCardBagListFirst(o);
                }

                @Override
                public void onError(String msg) {
                    baseView.setCardBagError(msg);
                }
            });
        }else {
            addDisposable(apiServer.getCardBagList("5", "1"), new BaseObserver<BaseBean<CardBagList>>(baseView) {


                /**
                 * 完成
                 *
                 * @param o 对象
                 */
                @Override
                public void onSuccess(BaseBean<CardBagList> o) {
                    baseView.setCardBagRefresh(o);
                }

                @Override
                public void onError(String msg) {
                    baseView.setCardBagError(msg);
                }
            });
        }
    }

}
