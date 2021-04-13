package com.CaoYanghua.week6.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String[] webSite = request.getParameterValues("search");
        if(txt.equals("")){
            response.sendRedirect("index.jsp");
        }else {
            if(webSite[0].equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }
            else if(webSite[0].equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }
            else if(webSite[0].equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
