package org.yty.pojo;

/**
 * @ClassName: Uesr
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/27 23:29
 * @Version: V1.0
 */
public class Uesr {
    private  int id;
    private  String name;
    private  String password;
    private  String phone;

    public Uesr() {
    }

    public Uesr(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public Uesr(int id, String name, String password, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public Uesr(String phone,String password) {
        this.password = password;
        this.phone = phone;
    }

    public Uesr(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Uesr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                '}';
    }
}