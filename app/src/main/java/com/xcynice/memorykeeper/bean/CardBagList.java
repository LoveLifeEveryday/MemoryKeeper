package com.xcynice.memorykeeper.bean;

import java.util.List;

/**
 * @Description: 分页获取自己的所有卡包信息
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 15:33
 */
public class CardBagList {

    /**
     * pageNum : 1
     * pageSize : 5
     * totalPage : 1
     * total : 2
     * list : [{"cardBagId":1,"userId":31,"name":"更新卡包测试","info":"更新卡包测试信息","ifPrivate":true,"pic":""},{"cardBagId":3,"userId":31,"name":"卡包测试","info":"卡包测试描述","ifPrivate":false,"pic":"http://39.99.167.141:9090/build/20200818/tomatoes-1280859_640.jpg"}]
     */

    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    private List<CardBag> list;

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

    public List<CardBag> getList() {
        return list;
    }

    public void setList(List<CardBag> list) {
        this.list = list;
    }
}
