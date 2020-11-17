package com.xcynice.memorykeeper.module.CreateBag.view;

import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.CardBag;

/**
 * @Description: 卡包界面接口
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 9:08
 */
public interface ICreateBagView extends BaseView {


    /**
     *  新建卡包
     * @param cardBag 卡包实例
     */
    void createNewCardBag(CardBag cardBag);

    /**
     *  获取卡包对象
     */
    CardBag getCardBag();

    /**
     * 获取图片
     */
    void getImage();

    /**
     * 新建卡包成功
     */
    void onSuccess();
    /**
     * 获取卡包失败
     */
    void onFailure(String errorMsg);
}
