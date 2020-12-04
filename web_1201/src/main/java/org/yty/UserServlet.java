package org.yty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
//获取参数值
        String name= request.getParameter("name");
        //模拟多个用户
        List<String> list= Arrays.asList("mike","tom","林坤","楼挺豪");
        int flag=0;
        //循环判断
        for(String str:list){
            //判断
            if(name.equals(str)){
                flag=1;
                break;
            }
        }
        System.out.println(flag);
        //响应结果
        out.print(flag);
        out.flush();
        out.close();
    }
}
