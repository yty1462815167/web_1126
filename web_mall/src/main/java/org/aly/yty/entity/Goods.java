package org.aly.yty.entity;

/**
 * @ClassName: Goods
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/2 16:43
 * @Version: V1.0
 */
public class Goods {
    private String goodId;
    private String goodsName;
    private String unit;
    private String supplierId;
    private int stock;
    private double goodsPrice;

    @Override
    public String toString() {
        return "Goods{" +
                "goodId='" + goodId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", unit='" + unit + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", stock=" + stock +
                ", goodsPrice=" + goodsPrice +
                '}';
    }

    public Goods() {
    }


    public Goods(String goodId, String goodsName, String unit, String supplierId, int stock, double goodsPrice) {
        this.goodId = goodId;
        this.goodsName = goodsName;
        this.unit = unit;
        this.supplierId = supplierId;
        this.stock = stock;
        this.goodsPrice = goodsPrice;
    }


    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }




}