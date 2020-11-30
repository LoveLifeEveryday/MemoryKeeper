package com.xcynice.memorykeeper.bean;

import java.util.List;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 23:02
 */
public class CardList {

    /**
     * pageNum : 1
     * pageSize : 5
     * totalPage : 1
     * total : 2
     * list : [{"cardId":1,"cardBagId":1,"question":"测试问题","answer":"测试答案","more":"测试解释"},{"cardId":2,"cardBagId":1,"question":"测试问题","answer":"测试答案","more":"测试解释"}]
     */

    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    private List<ResponseCard> list;

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

    public List<ResponseCard> getList() {
        return list;
    }

    public void setList(List<ResponseCard> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * cardId : 1
         * cardBagId : 1
         * question : 测试问题
         * answer : 测试答案
         * more : 测试解释
         */

        private int cardId;
        private int cardBagId;
        private String question;
        private String answer;
        private String more;

        public int getCardId() {
            return cardId;
        }

        public void setCardId(int cardId) {
            this.cardId = cardId;
        }

        public int getCardBagId() {
            return cardBagId;
        }

        public void setCardBagId(int cardBagId) {
            this.cardBagId = cardBagId;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }
    }
}
