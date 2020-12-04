package org.aly.yty.entity;

/**
 * @ClassName: Supplier
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/2 16:44
 * @Version: V1.0
 */
public class Supplier {
    private String supplierId;
    private String supplierName;

    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String linkMan, String linkTel, String linkAddress, String fax, String describe) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.linkMan = linkMan;
        this.linkTel = linkTel;
        this.linkAddress = linkAddress;
        this.fax = fax;
        this.describe = describe;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", linkTel='" + linkTel + '\'' +
                ", linkAddress='" + linkAddress + '\'' +
                ", fax='" + fax + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    private String linkMan;
    private String linkTel;
    private String linkAddress;
    private String fax;
    private String describe;




}