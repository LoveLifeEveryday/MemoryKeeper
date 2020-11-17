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

    /**
     *  第一次设置卡包数据
     * @param cardBagList 卡包集合
     */
    void setCardBagListFirst(BaseBean<CardBagList> cardBagList);


    /**
     *  用刷新的方法设置卡包数据
     * @param list 卡包集合
     */
    void setCardBagRefresh(BaseBean<CardBagList> list);

    /**
     * 设置卡包数据失败
     * @param errorMsg 错误信息
     */
    void setCardBagError(String errorMsg);


    /**
     * 用加载更多的方式设置卡包数据
     * @param list 卡包数据
     */
    void setCardBagByMore(BaseBean<CardBagList> list);

    /**
     *  加载更多失败
     * @param errorMsg 失败信息
     */
    void showCardBagErrorMore(String errorMsg);
}
