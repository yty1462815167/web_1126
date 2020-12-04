package org.aly.yty.entity;

import java.util.Date;

/**
 * @ClassName: UserInfo
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/2 16:44
 * @Version: V1.0
 */
public class UserInfo {
    private String userId;
    private String userName;
    private String passWord;
    private int sex;
    private Date bornDate;
    private String userTel;
    private String userAddress;
    private String typeID;

    public UserInfo() {
    }

    public String getUserId() {
        return userId;
    }
//登录
        public UserInfo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }//注册
    public UserInfo(String userId, String userName, String passWord, int sex, Date bornDate, String userTel, String userAddress, String typeID) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
        this.bornDate = bornDate;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.typeID = typeID;
    }
    public UserInfo(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", bornDate='" + bornDate + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", typeID=" + typeID +
                '}';
    }
}
