package servlet;

import biz.UserinfoBiz;
import entity.Userinfo;
import org.aly.yty.until.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UserinfoServlet",urlPatterns = "*.do")
@MultipartConfig //请求文件上传
public class UserinfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            //pathName 方法名；后面2个是参数
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

    //注册
    protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.获得part单个实例
        Part part = request.getPart("img");
        //2.获取文件头信息
        String header = part.getHeader("Content-Disposition");
        System.out.println("header");
        //3.获取图片扩展名   .jpg  .bmp..
        String suffix = header.substring(header.lastIndexOf("."), header.length() - 1);
        System.out.println("suffix");
        //4.生成32位文件名
        String fileName = UUID.randomUUID() + suffix;
        System.out.println(fileName);
        //5.服务器路径
        String str = request.getServletContext().getRealPath("/upload");
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        //6.完整路径
        String path = str + "/" + fileName;
        System.out.println("path");
        //7.文件输入流
        InputStream is = part.getInputStream();
        //输出流》服务器路径
        OutputStream os = new FileOutputStream(path);
        byte[] bys = new byte[1024];
        int length = 0;
        //读取数据
        while ((length = is.read(bys)) != -1) {
            //写入
            os.write(bys, 0, length);
        }
        //关闭
        os.close();
        is.close();
        //中文处理使用过滤器
        //请求数据
        String name = request.getParameter("textfiled");
        String pwd = request.getParameter("textfiled2");
        //封装数据
        Userinfo user = new Userinfo(name, pwd);
        //存入图片数据
        user.setPicture(fileName);
        //业务对象
        UserinfoBiz biz = new UserinfoBiz();
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

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        //中文处理使用过滤器

        //请求数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPass");

        //封装数据
        Userinfo user = new Userinfo(name, pwd);

        //业务对象
        UserinfoBiz biz = new UserinfoBiz();

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

    protected void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//业务对象
        UserinfoBiz biz = new UserinfoBiz();

        String str = request.getParameter("pageIndex");
//当前页
        //判断当前页
        int pageIndex = (str == null) ? (1) : (Integer.parseInt(str));
//每页显示个数
        int pageSize = 5;
        //总个数
        int count = biz.all().size();
        //实例化分页对象
        PageInfo pageInfo = new PageInfo(count, pageSize, pageIndex);
        //调用业务方法
        List<Userinfo> list = biz.getPageInfo(pageInfo);
        //保存数据（request,使用转发）
        request.setAttribute("lists", list);
        request.setAttribute("pageInfo", pageInfo);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
        //关闭
        out.flush();
        out.close();


    }

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
        UserinfoBiz biz = null;

        //判断
        if ("修改".equals(sub)) {
            //封装数据
            Userinfo user = new Userinfo(Integer.parseInt(strId), name, pwd);
            //业务对象
            biz = new UserinfoBiz();
            //调用业务方法
            count = biz.update(user);
        } else {  //删除
            //业务对象
            biz = new UserinfoBiz();
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