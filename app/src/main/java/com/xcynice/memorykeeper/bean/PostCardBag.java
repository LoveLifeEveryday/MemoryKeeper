package com.xcynice.memorykeeper.bean;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 22:41
 */
public class PostCardBag {

    private String name;
    private String info;
    private boolean ifPrivate;
    private String pic;

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
