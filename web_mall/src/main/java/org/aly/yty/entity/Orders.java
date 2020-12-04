package org.aly.yty.entity;

/**
 * @ClassName: Orders
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/2 16:44
 * @Version: V1.0
 */
public class Orders {
private String ordersId;
private String  goodId;
private int count;
private double total;
private int pay;
private String createTIME;

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId='" + ordersId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", count=" + count +
                ", total=" + total +
                ", pay=" + pay +
                ", createTIME='" + createTIME + '\'' +
                '}';
    }

    public Orders(String ordersId, String goodId, int count, double total, int pay, String createTIME) {
        this.ordersId = ordersId;
        this.goodId = goodId;
        this.count = count;
        this.total = total;
        this.pay = pay;
        this.createTIME = createTIME;
    }

    public Orders() {
    }

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getCreateTIME() {
        return createTIME;
    }

    public void setCreateTIME(String createTIME) {
        this.createTIME = createTIME;
    }
}