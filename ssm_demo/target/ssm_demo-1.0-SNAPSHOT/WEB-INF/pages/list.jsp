<%--
  Created by IntelliJ IDEA.
  User: 刘云锴
  Date: 2019/9/12
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>显示页面</h3>
    <c:forEach items="${accounts}" var="account">
        ${account.name}
        ${account.money}
    </c:forEach>
</body>
</html>
