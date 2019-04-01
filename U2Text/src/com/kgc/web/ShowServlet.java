package com.kgc.web;

import com.kgc.pojo.Invitation;
import com.kgc.service.ITestService;
import com.kgc.service.impl.TestServiceImpl;
import com.kgc.utils.JDBCUtils;
import com.kgc.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ShowServlet extends HttpServlet {

    ITestService service = new TestServiceImpl();
    PageBean page = new PageBean();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String,String[]> map = request.getParameterMap();
        page = JDBCUtils.toBean(PageBean.class, map);
        //System.out.println(page.toString());
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currPage = request.getParameter("currPage");
        //System.out.println(currPage+"currPage");
        if (currPage!=null){
            page.setCurrPage(Integer.parseInt(currPage));
        }

        List<Invitation> list = service.selectPage(page);
        //System.out.println(list);
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("page",page);

        request.getRequestDispatcher("/jsp/show.jsp").forward(request,response);
    }
}
