<%--
  Created by IntelliJ IDEA.
  User: BG332400
  Date: 2018/4/12
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <form method="post" action="/demo/home/AddUser">
        <table>
            <tr>
                <td>编号：</td>
                <td><input type="text" name="id"></td>
            </tr>
                <td>姓名：</td>
                <td><input type="text" name="name"></td>
            <tr align="center">
                <td colspan="2"><input type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</body>
</html>
