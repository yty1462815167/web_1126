package org.yty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/emaillogin")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //获得参数值
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        //判断
        if("mike".equals(name)&&"123".equals(password)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        out.flush();
        out.close();
    }
}
