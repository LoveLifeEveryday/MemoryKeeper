package com.xcynice.memorykeeper.bean;

import java.util.List;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 17:27
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class CollectList {

    /**
     * pageNum : 1
     * pageSize : 10
     * totalPage : 1
     * total : 1
     * list : [{"collectId":106,"userId":31,"cardBagId":1,"collectionTime":"2020-11-18T09:07:50.000+00:00"}]
     */


    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    /**
     * collectId : 106
     * userId : 31
     * cardBagId : 1
     * collectionTime : 2020-11-18T09:07:50.000+00:00
     */

    private List<ListBean> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private int collectId;
        private int userId;
        private int cardBagId;
        private String collectionTime;

        public int getCollectId() {
            return collectId;
        }

        public void setCollectId(int collectId) {
            this.collectId = collectId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getCardBagId() {
            return cardBagId;
        }

        public void setCardBagId(int cardBagId) {
            this.cardBagId = cardBagId;
        }

        public String getCollectionTime() {
            return collectionTime;
        }

        public void setCollectionTime(String collectionTime) {
            this.collectionTime = collectionTime;
        }
    }

}
