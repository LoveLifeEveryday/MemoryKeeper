package com.xcynice.memorykeeper.bean;

/**
 * @author : xucanyou666
 * @date : 2020/12/1 10:44
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description : 注册的时候传的参数
 */
public class User {

    /**
     * avatar :
     * password :
     * phone :
     * userName :
     */

    private String avatar;
    private String password;
    private String phone;
    private String userName;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
