package org.yty;

import org.yty.pojo.Uesr;
import org.yty.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: UesrBiz
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/27 23:29
 * @Version: V1.0
 */
public class UesrBiz extends BaseDao {
    /**
     * 登录
     *
     * @param uesrs
     * @return
     */
    public int find(Uesr uesrs) {

        //sql语句
        String sql = "SELECT count(1) from uesr where phone=? and  `password`=?";
        //设置值
        Object[] obj = new Object[]{uesrs.getPhone(), uesrs.getPassword()};

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


    public int add(Uesr uesrs) {
        //sql语句
        String sql = "INSERT INTO uesr(`name`,`password`,phone) VALUES(?,?,?)";
        //设置值
        Object[] obj = new Object[]{uesrs.getName(),uesrs.getPassword(),uesrs.getPhone()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
