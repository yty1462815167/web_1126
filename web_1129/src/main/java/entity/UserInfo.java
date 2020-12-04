package entity;

/**
 * @ClassName: UserInfo
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/30 10:19
 * @Version: V1.0
 */
public class UserInfo {
    private int id;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String username;
    private  String password;
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


    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public UserInfo(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public UserInfo() {
    }


}