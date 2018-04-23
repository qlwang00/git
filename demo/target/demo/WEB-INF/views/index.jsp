<%@ page import="java.util.List" %>
<%@ page import="example.entiy.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <table align="center" border="1">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>操作</th>
        </tr>
        <%
            List<User> list=(List<User>) request.getAttribute("users");
            for(User u:list)
            {
        %>
        <tr align="center">
            <td><%=u.getId()%></td>
            <td><%=u.getName()%></td>
            <td>
                <input type="button" value="编辑" onclick="window.location.href='/demo/home/Update?id='+'<%=u.getId()%>'">
                <input type="button" value="删除" onclick="window.location.href='/demo/home/Delete?id='+'<%=u.getId()%>'">
            </td>
        </tr>
        <%
            }
        %>
        <tr align="center">
            <td colspan="3"><input type="button" value="添加" onclick="window.location.href='/demo/home/Add'"></td>
        </tr>
    </table>
</body>
</html>