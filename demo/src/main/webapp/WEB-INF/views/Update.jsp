<%@ page import="java.util.List" %>
<%@ page import="example.entiy.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
    <form method="post" action="/demo/home/UpdateUser">
    <table align="center" border="1">
        <%
            List<User> list=(List<User>) request.getAttribute("users");
            User us=list.get(0);
        %>
        <tr>
            <td>编号：</td>
            <td><input type="text" name="id" style="background-color: darkgray" value="<%=us.getId()%>" readonly="true"></td>
        </tr>
            <td>姓名：</td>
            <td><input type="text" name="name" value="<%=us.getName()%>"></td>
        <tr align="center">
            <td colspan="2"><input type="submit" value="确定"></td>
        </tr>
    </table>
    </form>
</body>
</html>
