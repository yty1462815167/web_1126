package org.aly.yty.until;

import entity.Userinfo;

import java.util.List;

/**
 * @ClassName: PageInfo
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/2 14:56
 * @Version: V1.0
 */
public class PageInfo {
    private  int count;//总条数
    private int totalPage;//总页数

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        //计算
        this.totalPage=(int)(Math.ceil(count/(double)rows));
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Userinfo> getList() {
        return list;
    }

    public void setList(List<Userinfo> list) {
        this.list = list;
    }

    private int rows=5;//每页显示行数
    private int currentPage=1;//当前页数
    private List<Userinfo> list;//内容
    //默认构造方法
    public PageInfo() {
    }

    public PageInfo(int count, int rows, int currentPage, List<Userinfo> list) {
       //计算总页数
        setCount(count);
        this.rows = rows;
        this.currentPage = currentPage;
        this.list = list;
    }

    public PageInfo(int count, int rows, int currentPage) {
        setCount(count);
        this.rows = rows;
        this.currentPage = currentPage;
    }
}