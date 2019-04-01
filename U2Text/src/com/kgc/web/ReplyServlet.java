package com.kgc.web;

import com.kgc.pojo.Reply;
import com.kgc.service.ITestService;
import com.kgc.service.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/reply")
public class ReplyServlet extends HttpServlet {
    ITestService service = new TestServiceImpl();
    Reply reply = new Reply();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收新增评论的参数
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String content = request.getParameter("content");
        String author = request.getParameter("author");
        String invid = request.getParameter("invid");
        if (content.trim().equals("")||content==null){
            response.getWriter().write("<script language='javascript'>alert('回复内容不能为空！');</script>");
            request.getRequestDispatcher("/jsp/add.jsp").include(request,response);
        }else if (author==null||author.equals("")){
            reply.setAuthor("匿名用户");
        }else {
            reply.setAuthor(author);
        }
        reply.setInvid(Integer.parseInt(invid));
        reply.setContent(content);
        int i = service.add(reply);
        request.getSession().setAttribute("msg",i==1?"新增成功":"新增失败");

        doGet(request,response);//不能直接去页面，数据已经发生变化，需要重新查询
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String invid = request.getParameter("invid");

        List<Reply> reps = service.selectReply(invid);
        request.getSession().setAttribute("reps",reps);
        System.out.println(reps.toString());
        request.getRequestDispatcher("/jsp/reply.jsp").forward(request,response);
    }
}
