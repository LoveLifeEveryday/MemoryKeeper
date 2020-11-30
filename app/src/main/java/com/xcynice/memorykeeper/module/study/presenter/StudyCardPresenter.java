package com.xcynice.memorykeeper.module.study.presenter;

import android.util.Log;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.bean.CardList;
import com.xcynice.memorykeeper.module.study.view.IStudyCardView;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 22:59
 */
public class StudyCardPresenter  extends BasePresenter<IStudyCardView> {
    public StudyCardPresenter(IStudyCardView baseView) {
        super(baseView);
    }
    /**
     *  第一次获取卡片
     */
    public void getCardFirst(String cardBagId) {
        addDisposable(apiServer.getCardList(cardBagId,5 + "", 1 + ""), new BaseObserver<BaseBean<CardList>>(baseView) {



            /**
             * 完成
             *
             * @param o 对象
             */
            @Override
            public void onSuccess(BaseBean<CardList> o) {
                baseView.getCardFirstSuccess(o.data);
                Log.d("StudyCardPresenter", String.valueOf(o.code));
            }

            @Override
            public void onError(String msg) {
                baseView.getCardFail(msg);
            }
        });
    }

    /**
     * 加载更多
     * @param page
     */
    public void getCardMore(String cardBagId,int page) {
        addDisposable(apiServer.getCardList(cardBagId,5 + "", page + ""), new BaseObserver<BaseBean<CardList>>(baseView) {

            /**
             * 完成
             *
             * @param o 对象
             */
            @Override
            public void onSuccess(BaseBean<CardList> o) {
                baseView.getCardMoreSuccess(o.data);
            }

            @Override
            public void onError(String msg) {
                baseView.getCardFail(msg);
            }
        });
    }

}
