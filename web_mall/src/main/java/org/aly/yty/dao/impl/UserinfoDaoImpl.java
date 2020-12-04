package org.aly.yty.dao.impl;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.aly.yty.dao.UserinfoDao;
import org.aly.yty.entity.UserInfo;
import org.aly.yty.until.BaseDao;

import java.util.List;

/**
 * @ClassName: UserinfoDaoImpl
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/3 14:49
 * @Version: V1.0
 */
public class UserinfoDaoImpl extends BaseDao implements UserinfoDao {
    //登录
    @Override
    public UserInfo isLogin(UserInfo userInfo) throws Exception {
//sql语句
        String sql = "SELECT * from userinfo WHERE userName=? and `passWord`=?";
        //参数
        Object[] obj = {userInfo.getUserName(), userInfo.getPassWord()};
        //调用方法
        return this.excuteOneQuery(sql, UserInfo.class, obj);
    }
//添加用户
    @Override
    public int add(UserInfo userInfo) throws Exception {
//sql语句
        String sql="Insert into userinfo VALUES(?,?,?,?,?,?,?,?);";
        //参数
        Object[] obj={userInfo.getUserId(),userInfo.getUserName(),userInfo.getPassWord(),userInfo.getSex(),userInfo.getBornDate(),userInfo.getUserTel(),userInfo.getUserAddress(),userInfo.getTypeID()};
        //调用方法
        return this.excuteUpdate(sql,UserInfo.class,obj);
    }
//删除
    @Override
    public int del(String id) throws Exception {
        //sql语句
        String sql="DELETE * from userinfo where userid=?";
        //参数
        Object[] obj ={id};
        //调用方法
        return this.excuteUpdate(sql,UserInfo.class,obj);
    }
//修改
    @Override
    public int update(UserInfo userInfo) throws Exception {
      //sql语句
        String sql="update userinfo set UserName=?,Sex=?,BornDate=?,UserTel=?,UserAddress=?,TypeID=? where UserId=?;";
       //参数
        Object[] obj={userInfo.getUserId()};
        //调用方法
        return this.excuteUpdate(sql,UserInfo.class,obj);
    }
//根据id查询
    @Override
    public UserInfo findById(String id) throws Exception {
        //sql语句
        String sql="select * from userinfo where userid=?";
        //参数
        Object[] obj={id};
        //调用方法
        return this.excuteOneQuery(sql,UserInfo.class,id);
    }
//查询所有  2 种方式(无参数和模糊查询)
    @Override
    public List<UserInfo> all(Object... param) throws Exception {
        //sql语句
        String sql="";
         List<UserInfo> list =null;
         if(param.length==0){
             //sql语句
             sql="select * from userinfo where";
             list = this.excuteMoreQuery(sql, UserInfo.class);
         }else{
             sql="select *  from  userinfo where username like ?";
             //参数
             Object[] obj={"%"+param[0]+"%"};
             //调用方法
             list=this.excuteMoreQuery(sql,UserInfo.class,obj);
         }
return list;
}}