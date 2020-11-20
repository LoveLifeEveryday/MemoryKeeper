package com.xcynice.memorykeeper.module.study.view;

import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.CardBagList;

/**
 * @Description: 学习页面的接口
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 16:15
 */
public interface IStudyView extends BaseView {



    void getCardBagFirstSuccess(CardBagList cardBagList);

    void getCardBagMoreSuccess(CardBagList cardBagList);

    void getCardBagFail(String msg);

}
