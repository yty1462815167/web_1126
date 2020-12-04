package biz;

import entity.UserInfo;
import util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserInfoBiz
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/11/30 10:22
 * @Version: V1.0
 */
public class UserInfoBiz extends BaseDao {
    public List<UserInfo> all(){
        String sql="select * from userinfo";
        List<UserInfo> allList = new ArrayList<>();
        try {
            ResultSet rs=this.queryQuery(sql);
            while(rs.next()){
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt(1));
                userInfo.setUsername(rs.getString(2));
                userInfo.setPassword(rs.getString(3));
//                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
                allList.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(rs,this.ps,this.con);
        }
        return allList;
    }



    public int isLogin(UserInfo info){
        String sql="select count(1) from userinfo where username=? and password=?";
//        封装
        Object[] objects=new Object[]{info.getUsername(),info.getPassword()};
        try {
            ResultSet rs=this.queryQuery(sql,objects);
//            获得值
            rs.next();
            return rs.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(rs,this.ps,this.con);
        }
        return 0;
    }

    public int add(UserInfo info){
        String sql="insert into userinfo (username,password) values(?,?)";
        Object[] objects=new Object[]{info.getUsername(),info.getPassword()};
        try {
            return this.queryUpdate(sql,objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(this.rs,this.ps,this.con);
        }
        return 0;
    }

    public int update(UserInfo info){
        String sql="update from userinfo set username=?,password=? where id=?";
        Object[] objects=new Object[]{info.getUsername(),info.getPassword(),info.getId()};
        try {
            return this.queryUpdate(sql,objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll(this.rs,this.ps,this.con);
        }
        return 0;
    }

}
