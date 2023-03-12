package com.ddw.webapps.todoapp.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnect {

    public static Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            // get db connection info from context file and use it to create a connection
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/todo");
            connection = ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
