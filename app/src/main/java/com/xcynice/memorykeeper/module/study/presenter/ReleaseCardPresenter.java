package com.xcynice.memorykeeper.module.study.presenter;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseObserver;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.Card;
import com.xcynice.memorykeeper.bean.ResponseCard;
import com.xcynice.memorykeeper.module.study.view.IReleaseCardView;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 22:21
 */
public class ReleaseCardPresenter extends BasePresenter<IReleaseCardView> {

    public ReleaseCardPresenter(IReleaseCardView baseView) {
        super(baseView);
    }

    public void releaseCard(Card card){
        addDisposable(apiServer.releaseCardBag(card),new BaseObserver<BaseBean<ResponseCard>>(baseView){

            /**
             * 完成
             *
             * @param o 对象
             */
            @Override
            public void onSuccess(BaseBean<ResponseCard> o) {
                baseView.success("新建成功");
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
