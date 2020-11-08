package com.xcynice.memorykeeper.base;

import java.io.Serializable;


/**
 * @Author 许朋友爱玩
 * @Date   2020/6/12
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 *
 * @Description BaseBean
 */

public class BaseBean<T> implements Serializable {


    /**
     * data :
     * code : 0
     * msg :
     */

    public int code;
    public String msg;
    public T data;

    public BaseBean(int code, T data) {
        this.code = code;
        this.data = data;
    }

}
