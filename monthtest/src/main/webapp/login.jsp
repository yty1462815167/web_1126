<%@ page import="entity.User" %>
<%@ page import="biz.UserBiz" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/11/28
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1. 中文处理
    request.setCharacterEncoding("utf-8");
    //2.获取参数值
String userName = request.getParameter("userName");
String passWord= request.getParameter("passWord");

//3.封装

    User user=new User(userName,passWord);
    //4.业务
    UserBiz userBiz= new UserBiz();
    //5.调用方法
    System.out.println("464644");
    int count =userBiz.find(user);
    System.out.println("count="+count);
    //判断
    if(count>0){
        response.sendRedirect("book.html");
    }else{
        response.sendRedirect("login.html");
    }

%>
</body>
</html>
