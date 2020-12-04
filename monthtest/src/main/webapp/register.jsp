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
    //1.中文处理
    request.setCharacterEncoding("utf-8");
    //2.获取参数值
    String userName =request.getParameter("userName");
    String passWord=request.getParameter("passWord");
    String rePassWord=request.getParameter("rePassWord");
    String email=request.getParameter("email");
    //判断

    if(passWord.equals(rePassWord)){
    //3.封装
    User user = new User(userName,passWord,email);
    //4.业务
    UserBiz userBiz=new UserBiz();
    //5.调用方法
    int count= userBiz.add(user);

    if(count>0){
        response.sendRedirect("success.html");
    }else{
        response.sendRedirect("register.html");
    }}
else{
    response.sendRedirect("register.html");
    }%>
</body>
</html>
