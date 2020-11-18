package com.xcynice.memorykeeper.module.mine.view;

import com.xcynice.memorykeeper.base.BaseView;
import com.xcynice.memorykeeper.bean.CollectList;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 17:26
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public interface IMineCollectView extends BaseView {

    void  getMineCollectSuccess(CollectList collectList);

    void getMineCollectFail(String msg);

}
