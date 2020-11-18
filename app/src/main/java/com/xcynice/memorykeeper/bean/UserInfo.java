package com.xcynice.memorykeeper.bean;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 10:55
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class UserInfo {

    /**
     * userId : 31
     * userName : testtest
     * password : null
     * phone : 15916517261
     * avatar : www.test.com
     * registTime : 2020-11-11T03:11:05.000+00:00
     * userInfo : null
     * avatarUrl : null
     */


    private int userId;
    private String userName;
    private String password;
    private String phone;
    private String avatar;
    private String registTime;
    private String userInfo;
    private String avatarUrl;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getPassword() {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Object getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}

