<%--
  Created by IntelliJ IDEA.
  User: thesu
  Date: 3/12/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.ddw.webapps.todoapp.model.Item" %>
<html>
<head>
    <title>TODO</title>
</head>
<body>
<h1>Welcome ${user}</h1>
<h2>TODO List</h2>
<%!
%><% ArrayList<Item> list = (ArrayList<Item>) request.getAttribute("items");
    if (list.isEmpty()) {
%>
<p>List is empty</p>
<%
} else {
%>
<!-- CREATE LIST USING TABLE -->
<table>
    <%
        for (Item item : list) {
    %>
    <tr>
        <td><%item.getTask();%></td>
        <td><%item.getStartDate();%></td>
        <td><%item.getEndDate();%></td>
        <td><%item.isCompleted();%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>
<a href="addtodo">Add new TODO item</a>

</body>
</html>
