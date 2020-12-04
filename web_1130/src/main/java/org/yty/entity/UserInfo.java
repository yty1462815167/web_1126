package org.yty.entity;

/**
 * @ClassName: UserInfo
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/30 15:54
 * @Version: V1.0
 */
public class UserInfo {
    private int id;
    private String username;
    private String password;
    //用来登录，新增的构造方法
    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }


    //用来查找的构造方法
    public UserInfo(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



//用来修改的构造方法
    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }



    public UserInfo() {
    }



}