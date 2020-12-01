package com.xcynice.memorykeeper.module.mine.view;

import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.UserRegResult;

/**
 * @author : xucanyou666
 * @date : 2020/12/1 10:42
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public interface IRegisterView extends BaseView {
    /**
     * 注册成功
     *
     * @param userRegResult 注册成功的数据
     */
    void registerSuccess(UserRegResult userRegResult);

    /**
     * 注册失败
     *
     * @param msg 失败信息
     */
    void registerFail(String msg);
}
