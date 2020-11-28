package com.xcynice.memorykeeper.module.study.view;

import com.xcynice.memorykeeper.base.BaseView;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/28 16:38
 */
public interface ICardBagDetailView extends BaseView {

    void deleteSuccess(String msg);
    void deleteFailure(String msg);

}
