package org.yty.Biz;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.yty.entity.UserInfo;
import org.yty.until.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserInfoBiz
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/30 15:52
 * @Version: V1.0
 */
public class UserInfoBiz extends BaseDao {
//登录
    public  int login(UserInfo userInfo){
//sql语句
        String sql = "SELECT COUNT(1) FROM userinfo where username=? and password=?";
    //设置值
        Object[] obj= new Object[]{userInfo.getUsername(),userInfo.getPassword()};

        ResultSet rs=null;
        //调用方法
        try {
            rs=this.queryQuery(sql,obj);
            //获得值
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭
            this.closeAll(rs,this.ps,this.con);
        }
return 0;

    }
    //新增前判断这个用户名是否存在，因为用户名是主键，在数据中不能重复增加
    public int judgeUsername(UserInfo userInfo) {

        //sql语句
        String sql = "SELECT count(1) FROM userinfo where username=?";
        //设置值
        Object[] obj = new Object[]{userInfo.getUsername()};

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
//注册
    public int register(UserInfo userInfo){
        //sql 语句
        String sql="INSERT INTO userinfo(username,password)values(?,?)";
        //设置值
        Object[] obj=new Object[] {userInfo.getUsername(),userInfo.getPassword()};
        //调用方法
        try {
            return this.queryUpdate(sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
//修改
    public int update(UserInfo userInfo){
        //sql 语句
        String sql="UPDATE userinfo set username=?,password=? where id=? ";
   //设置值
        Object[] obj=new Object[]{userInfo.getUsername(),userInfo.getPassword(),userInfo.getId()};

        //调用方法
        try {
            return this.queryUpdate(sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //删除
    public int del(int id){
//sql语句
        String sql= "delete  from userinfo where id=?";
        //设置值
        Object[] obj =new Object[]{id};
        //调用方法
        try {
            return this.queryUpdate(sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }  return 0;
    }

    //查询所有数据
    public List<UserInfo> all(){
        //存储数据
        List<UserInfo> list =new ArrayList<>();
        //sql 语句
        String sql ="select * from userinfo ";
        ResultSet re =null;
        try {
            rs=this.queryQuery(sql);
            while(rs.next()){
                UserInfo userInfo =new UserInfo(rs.getInt(1),rs.getString(2),rs.getString(3));
          //保存在集合中
                list.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(rs,this.ps,this.con);
        }return list;
    }


}