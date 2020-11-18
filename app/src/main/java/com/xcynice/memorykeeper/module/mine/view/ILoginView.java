package com.xcynice.memorykeeper.module.mine.view;

import com.xcynice.memorykeeper.base.BaseView;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 10:03
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public interface ILoginView extends BaseView {

    void loginSuccess(String msg);

    void loginFail(String msg);
}
