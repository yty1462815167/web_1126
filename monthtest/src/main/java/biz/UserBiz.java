package biz;

import entity.User;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: UserBiz
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/28 9:30
 * @Version: V1.0
 */
public class UserBiz extends BaseDao {
    public int find(User user) {
/**
 * 登录
 *
 */
        //sql语句
        String sql = "SELECT count(1) from userinfo where username=? and  password=?";
        //设置值
        Object[] obj = new Object[]{user.getUsername(),user.getPassword()};

        ResultSet rs = null;
        //调用方法
        try {
            rs = this.queryQuery(sql, obj);

            //获得值
            rs.next();

            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            this.closeAll(rs, this.ps, this.con);
        }
        return 0;
    }


    public int add(User users) {
        //sql语句
        String sql = "INSERT INTO userinfo(username,password,email) VALUES(?,?,?)";
        //设置值
        Object[] obj = new Object[]{users.getUsername(),users.getPassword(),users.getEmail()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}



