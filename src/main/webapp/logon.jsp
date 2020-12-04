<%@ page import="org.yty.UesrBiz" %>
<%@ page import="org.yty.pojo.Uesr" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/27
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.中文处理
    request.setCharacterEncoding("utf-8");

    //2.获取参数值
    String name=request.getParameter("name2");
    String password=request.getParameter("password2");
    String phone=request.getParameter("phone2");


    //3.封装
    Uesr uesrs =new Uesr(name,password,phone);

    //4.业务
    UesrBiz uesrBiz =new UesrBiz();

    //5.调用方法
    int count =uesrBiz.add(uesrs);

    //判断
    if(count>0){
        response.sendRedirect("login.html");
    }else{
        response.sendRedirect("logon.html");
    }

%>
</body>
</html>
