package com.ddw.webapps.todoapp.controllers;

import com.ddw.webapps.todoapp.dao.UserDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (!UserDAO.findUser(request.getParameter("user"), request.getParameter("password"))) {
                request.setAttribute("LOGIN_NOTIFICATION", "User not found");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else {
                RequestDispatcher rd =request.getRequestDispatcher("todo.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
