package com.kgc.web;

import com.kgc.pojo.Invitation;
import com.kgc.service.ITestService;
import com.kgc.service.impl.TestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    ITestService service = new TestServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String author = request.getParameter("author");
        String createdate = request.getParameter("createdate");
        Invitation invi = new Invitation();
        invi.setTitle(title);
        invi.setSummary(summary);
        invi.setAuthor(author);

        int i = service.more(invi);
        request.getSession().setAttribute("msg",i==1?"新增帖子成功":"新增帖子失败");
        response.sendRedirect("/text/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = service.delete(id);

        request.getSession().setAttribute("msg",i==1?"删除成功":"删除失败");
        response.sendRedirect("/text/index.jsp");
    }
}
