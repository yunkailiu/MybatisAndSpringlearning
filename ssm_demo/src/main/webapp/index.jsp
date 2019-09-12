<%--
  Created by IntelliJ IDEA.
  User: 刘云锴
  Date: 2019/9/12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询所有</a>
    <%--<a href="account/findById?id=1">按照id查询</a>--%>

    <form action="account/findById" method="post">
        用户id:<input type="text" name="id">
        <input type="submit" value="查询">
    </form>

    <form action="account/saveAccount" method="post">
        姓名:<input type="text" name="name"><br>
        金额:<input type="text" name="money">
        <input type="submit" value="提交">
    </form>

    <form action="account/delete" method="post">
        用户id:<input type="text" name="id">
        <input type="submit" value="删除">
    </form>

    <form action="account/update" method="post">
        用户id:<input type="text" name="id">
        金额:<input type="text" name="money">
        <input type="submit" value="提交">
    </form>

</body>
</html>
