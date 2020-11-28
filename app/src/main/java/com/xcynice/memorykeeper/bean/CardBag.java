package com.xcynice.memorykeeper.bean;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/14 22:21
 */
public class CardBag {
    /**
     * cardBagId : 3
     * userId : 31
     * name : 卡包测试
     * info : 卡包测试描述
     * ifPrivate : false
     * pic : http://39.99.167.141:9090/build/20200818/tomatoes-1280859_640.jpg
     */

    private String cardBagId;
    private int userId;
    private String name;
    private String info;
    private boolean ifPrivate;
    private String pic;

    public String getCardBagId() {
        return cardBagId;
    }

    public void setCardBagId(String cardBagId) {
        this.cardBagId = cardBagId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isIfPrivate() {
        return ifPrivate;
    }

    public void setIfPrivate(boolean ifPrivate) {
        this.ifPrivate = ifPrivate;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
