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
     *  第一次获取卡包
     */
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

    /**
     * 加载更多
     * @param page
     */
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
