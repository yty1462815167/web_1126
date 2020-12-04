package test;

import org.aly.yty.biz.UserinfoBiz;
import org.aly.yty.biz.impl.UserinfoBizImpl;
import org.aly.yty.entity.UserInfo;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserinfoTest
 * @Description: TODO
 * @Author: YTY
 * @date: 2020/12/3 16:34
 * @Version: V1.0
 */
public class UserinfoTest {
    @Test
    public void login() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //封装对象
//        UserInfo user = new UserInfo("孙主管", "aaa");
        UserInfo user = new UserInfo("刘丽", "pass123");
        try {
            //调用方法
            UserInfo userInfo = biz.isLogin(user);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void all() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //参数
        Object[] obj={"经"};
        try {
            //调用方法
//            List<UserInfo> userInfos = biz.all();
            List<UserInfo> userInfos = biz.all(obj);
            //循环遍历
            for(UserInfo userInfo:userInfos) {
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void add(){
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //.String转换成Date类型
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String time = "2019-09-19";
        try {
            Date date = ft.parse(time);
            //UserInfo 实例化
            UserInfo userInfo = new UserInfo("22222", "钉钉2222", "15616", 1, date, "15555555", "", "1");
            biz.add(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void del(){
        UserinfoBiz biz=new UserinfoBizImpl();
//        封装
        int num= 0;
        try {
            num = biz.del("G0002");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
    @Test
    public void update(){
        String da="2020-12-03";
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
        Date date=null;
        try {
            date = sdf.parse(da);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       UserinfoBiz biz=new UserinfoBizImpl();
//        封装
        UserInfo info=new UserInfo("G0002","灵昆","232323",1,date,"23212312","东阳","1");
        int num= 0;
        try {
            num = biz.update(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }


    @Test
    public void findById(){
        UserinfoBiz biz=new UserinfoBizImpl();
        UserInfo user= null;
        try {
            user = biz.findById("G0001");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

}