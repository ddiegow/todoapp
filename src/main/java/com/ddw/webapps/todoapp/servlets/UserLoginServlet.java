package com.ddw.webapps.todoapp.servlets;

import com.ddw.webapps.todoapp.dao.UserDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (!UserDAO.findUser(request.getParameter("user"), request.getParameter("password"))) {
                request.setAttribute("LOGIN_NOTIFICATION", "User not found");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
            else {
                request.setAttribute("user", request.getParameter("user"));
                RequestDispatcher rd =request.getRequestDispatcher("list");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
