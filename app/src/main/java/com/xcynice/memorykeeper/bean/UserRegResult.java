package com.xcynice.memorykeeper.bean;

/**
 * @author : xucanyou666
 * @date : 2020/12/1 10:36
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description : 用户注册返回的结果
 */
public class UserRegResult {

    /**
     * userId : 4
     * userName : farmer_001
     * password : null
     * phone : 13729102701
     * avatar : /img/202004221507077c3a1e58366b4b23a15dc92c98a559f1.jpg
     * registTime : 2020-04-10 11:44:08
     */

    private int userId;
    private String userName;
    private Object password;
    private String phone;
    private String avatar;
    private String registTime;

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

    public void setPassword(Object password) {
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
}
