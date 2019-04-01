package com.kgc.utils;


public class PageBean {

       //分页查询的四大参数
    private int currPage = 1;//当前页数   默认第一页
    private int size = 4;    //每页显示的长度  默认为4条
    private int totalPage;//总的页数
    private int count;     //总记录数  条数  select count(*) from emp


    //条件查询的条件参数
    private String title;

    @Override
    public String toString() {
        return "PageBean{" +
                "currPage=" + currPage +
                ", size=" + size +
                ", totalPage=" + totalPage +
                ", count=" + count +
                ", title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCurrPage() {
        return currPage;
    }
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
