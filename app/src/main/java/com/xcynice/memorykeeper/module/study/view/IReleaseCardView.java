package com.xcynice.memorykeeper.module.study.view;

import com.xcynice.memorykeeper.base.BaseView;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 22:21
 */
public interface IReleaseCardView extends BaseView {


    void success(String msg);
    void failure(String msg);
}
