package com.xcynice.memorykeeper.module.study.view;

import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.bean.CardList;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 23:00
 */
public interface IStudyCardView extends BaseView {
    void getCardFirstSuccess(CardList cardBagList);

    void getCardMoreSuccess(CardList cardBagList);

    void getCardFail(String msg);

    void deleteSuccess(String msg);
    void deleteFailure(String msg);
}
