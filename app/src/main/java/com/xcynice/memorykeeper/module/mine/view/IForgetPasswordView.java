package com.xcynice.memorykeeper.module.mine.view;

import com.xcynice.memorykeeper.base.BaseView;

/**
 * @author : xucanyou666
 * @date : 2020/12/1 11:07
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public interface IForgetPasswordView extends BaseView {
    void changePasswordSuccess(String msg);

    void changePasswordFail(String msg);
}
