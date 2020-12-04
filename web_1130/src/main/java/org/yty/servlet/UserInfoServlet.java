package org.yty.servlet;

import org.yty.Biz.UserInfoBiz;
import org.yty.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "UserInfoServlet",urlPatterns = "*.do")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
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


    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //请求数据
        String name = request.getParameter("textfield");
        String pwd = request.getParameter("textfield2");

        //封装数据
        UserInfo user = new UserInfo(name, pwd);

        //业务对象
        UserInfoBiz biz = new UserInfoBiz();

        //调用业务方法
        int count = biz.register(user);

        //判断
        if (count > 0) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("addUser.html");
        }

        //关闭
        out.flush();
        out.close();

    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //中文处理使用过滤器

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();



        //请求数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPass");

        //封装数据
        UserInfo user = new UserInfo(name, pwd);

        //业务对象
        UserInfoBiz biz = new UserInfoBiz();

        //调用业务方法
        int count = biz.login(user);

        //判断
        if (count > 0) {
            response.sendRedirect("welcome.html");
        } else {
            response.sendRedirect("index.html");
        }

        //关闭
        out.flush();
        out.close();

    }

    /**
     * 显示所有数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //中文处理使用过滤器
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();




        //业务对象
        UserInfoBiz biz = new UserInfoBiz();

        //调用业务方法
        List<UserInfo> list = biz.all();

        //保存数据(request ,使用转发)
        request.setAttribute("lists", list);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);

        //关闭
        out.flush();
        out.close();

    }

    /**
     * 更新
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //中文处理使用过滤器

        //请求数据
        String strId = request.getParameter("userID");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");

        //注意是2个提交按钮，获取参数值
        String sub = request.getParameter("Submit");


        //变量
        int count = 0;
        UserInfoBiz biz = null;

        //判断
        if ("修改".equals(sub)) {
            //封装数据
            UserInfo user = new UserInfo(Integer.parseInt(strId), name, pwd);
            //业务对象
            biz = new UserInfoBiz();
            //调用业务方法
            count = biz.update(user);
        } else {  //删除
            //业务对象
            biz = new UserInfoBiz();
            //调用业务方法
            count = biz.del(Integer.parseInt(strId));
        }

        //判断
        if (count > 0) {
            response.sendRedirect("all.do");
        } else {
            response.sendRedirect("userInfo.jsp");
        }

        //关闭
        out.flush();
        out.close();

    }
}
