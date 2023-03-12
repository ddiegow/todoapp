package com.ddw.webapps.todoapp.servlets;

import com.ddw.webapps.todoapp.model.Item;

import com.ddw.webapps.todoapp.utils.JDBCConnect;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ListItemsController", value = "/list")
public class ItemListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the item list from DB
        String user = request.getParameter("user");
        // add it to the request
        request.setAttribute("items", getItems(user));
        // forward to the list page
        RequestDispatcher rd = request.getRequestDispatcher("/todo-list.jsp");
        rd.forward(request, response);
    }

    private ArrayList<Item> getItems(String user) {
        ArrayList<Item> items = new ArrayList<>();
        String queryGetItems = "SELECT * FROM items WHERE user = ?";
        Connection connection;
        try {
            connection = JDBCConnect.getConnection();
            PreparedStatement ps = connection.prepareStatement(queryGetItems);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5));
                items.add(item);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
