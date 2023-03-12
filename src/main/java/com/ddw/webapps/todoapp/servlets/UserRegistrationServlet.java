package com.ddw.webapps.todoapp.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.ddw.webapps.todoapp.dao.UserDAO;
import com.ddw.webapps.todoapp.model.User;

@WebServlet(name = "UserRegistrationServlet", value = "/register")
public class UserRegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Inside post");
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(request.getParameter("firstName"), request.getParameter("lastName"),
                request.getParameter("user"), request.getParameter("password"));
        try {
            int result = UserDAO.registerUser(user);
            if (result == -1) {
                request.setAttribute("REGISTRATION_NOTIFICATION", "User already exists");
                RequestDispatcher ds = request.getRequestDispatcher("register.jsp");
                ds.forward(request, response);
            }
            if (result == 1) {
                RequestDispatcher ds = request.getRequestDispatcher("/list");
                ds.forward(request, response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
