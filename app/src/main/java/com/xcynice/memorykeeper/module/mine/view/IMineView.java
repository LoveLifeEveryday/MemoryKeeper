package com.xcynice.memorykeeper.module.mine.view;

import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.Test;
import com.xcynice.memorykeeper.bean.UserInfo;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 10:57
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public interface IMineView extends BaseView {
    void getUserInfoSuccess(UserInfo userInfo);

    void getUserInfoFail(String msg);


    void testSuccess(Test test);
}
