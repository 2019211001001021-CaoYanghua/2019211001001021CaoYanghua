package com.CaoYanghua.controller;

import com.CaoYanghua.dao.ProductDao;
import com.CaoYanghua.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/admin/productList")
public class ProductListServlet extends HttpServlet {
    Connection con=null;
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ProductDao productDao=new ProductDao();
        try {

            List<Product> productList= productDao.findAll(con);
            System.out.println(productList.toString());
            request.setAttribute("productList",productList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="/WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
