package org.aly.yty.servlet;

import org.aly.yty.biz.UserinfoBiz;
import org.aly.yty.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "UserInfoServlet", urlPatterns = "*.user")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求路径   /add.do
        String path = request.getServletPath();

        //截取 add
        String pathName = path.substring(1, path.lastIndexOf("."));

        //利用反射机制
        try {
            //pathName方法名; 后面2个是参数
            Method method = getClass().getDeclaredMethod(pathName, HttpServletRequest.class, HttpServletResponse.class);

            //调用
            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭
        out.flush();
        out.close();
    }
    //登录
//    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//        //请求数据
//        //2.获取参数值
//        String userName = request.getParameter("username");
//        String passWord = request.getParameter("password");
//        //3.封装
//        UserInfo uf = new UserInfo(userName, passWord);
//
//        //4.业务
//        UserinfoBiz ub = new UserinfoBiz();
//
//        //5.调用方法
//        int count = ub.islogin(uf);
//
//        System.out.println("count=" + count);
//
//        //判断
//        if (count > 0) {
//            //会话对象
//            HttpSession session = request.getSession();
//            //保存
//            session.setAttribute("uname", userName);
//            //跳转
//            response.sendRedirect("welcome.jsp");
//        } else {
//            response.sendRedirect("login.html");
//        }
//        //关闭
//        out.flush();
//        out.close();
//    }
    //修改密码
//    protected void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//        //请求数据
//        //2.获取参数值
//        String oldPassword = request.getParameter("oldPassword");
//        String newPassword = request.getParameter("newPassword");
//        //获取当前的用户名
//        //会话对象
//        HttpSession session = request.getSession();
//        String name = (String) session.getAttribute("uname");
//        //3.封装
//        UserInfo uf = new UserInfo(name);
//        //4.业务
//        UserinfoBiz ub = new UserinfoBiz();
//
//        //5.调用方法，通过用户名获取密码
//        String pass = ub.getPass(uf);
//        System.out.println("oldPassword=" + oldPassword);
//        System.out.println("newPassword=" + newPassword);
//        System.out.println("密码pass=" + pass);
//        if (pass.equals(oldPassword)) {
//            UserInfo uf1 = new UserInfo(name,newPassword);
//            ub.updatePassword(uf1);//根据用户名，更新密码
//            //响应结果
//            out.print(1);
//        } else {
//            //响应结果
//            out.print(0);
//        }
//
//        //关闭
//        out.flush();
//        out.close();
//    }
//    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//        //业务对象
//        UserinfoBiz1 biz = new UserinfoBiz1();
//        //调用业务方法
//        List<UserInfo> list = biz.all();
//        //保存数据(request ,只能转发)
//        request.setAttribute("lists", list);
//        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
//        //关闭
//        out.flush();
//        out.close();
//    }
}
