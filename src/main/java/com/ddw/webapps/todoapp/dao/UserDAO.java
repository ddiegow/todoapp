package com.ddw.webapps.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ddw.webapps.todoapp.model.User;
import com.ddw.webapps.todoapp.utils.JDBCConnect;

public class UserDAO {
    public static int registerUser(User user) throws Exception {
        System.out.println("Registering user");
        String queryFind = "SELECT * FROM users WHERE user=?";
        String queryInsert = "INSERT INTO users (first_name, last_name, user, password) VALUES (?, ?, ?, ?)";
        int result = 0;
        try (Connection connection = JDBCConnect.getConnection()){
            PreparedStatement psFind = connection.prepareStatement(queryFind);
            psFind.setString(1, user.getUser());
            ResultSet rs = psFind.executeQuery();
            if (rs.next()) {
                return -1;
            }
            PreparedStatement psInsert = connection.prepareStatement(queryInsert);
            psInsert.setString(1, user.getFirstName());
            psInsert.setString(2,  user.getLastName());
            psInsert.setString(3, user.getUser());
            psInsert.setString(4,  user.getPassword());
            result = psInsert.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();;
        }
        return result;
    }

    public static boolean findUser(String user, String password) throws Exception {
        String queryFind = "SELECT * FROM users WHERE user = ? AND password = ?";
        try (Connection connection = JDBCConnect.getConnection()) {
            PreparedStatement psFind = connection.prepareStatement(queryFind);
            psFind.setString(1, user);
            psFind.setString(2, password);
            ResultSet rs = psFind.executeQuery();
            return rs.next();
        }
        catch (SQLException e) {
            e.printStackTrace();;
        }
        return false;
    }
}
