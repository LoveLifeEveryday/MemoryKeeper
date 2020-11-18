package com.xcynice.memorykeeper.module.mine.view;

import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardBagList;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 16:28
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public interface IMineCardBagView extends BaseView {
    void getCardBagFirstSuccess(CardBagList cardBagList);

    void getCardBagMoreSuccess(CardBagList cardBagList);

    void getCardBagFail(String msg);
}
