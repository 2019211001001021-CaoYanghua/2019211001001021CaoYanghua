package com.CaoYanghua.controller;

import com.CaoYanghua.dao.OrderDao;
import com.CaoYanghua.dao.UserDao;
import com.CaoYanghua.model.Order;
import com.CaoYanghua.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
            User user= (User) session.getAttribute("user");
            int userId=user.getId();
            request.setAttribute("user",user);
            OrderDao OrderDao=new OrderDao();
            List<Order> orderList=OrderDao.findByUserId(con,userId);
            request.setAttribute("orderList",orderList);
            String path="/WEB-INF/views/accountDetails.jsp";
            request.getRequestDispatcher(path).forward(request,response);

        }else{
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
