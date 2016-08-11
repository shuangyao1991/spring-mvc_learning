<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shuangyao
  Date: 2016/8/11
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
        userName: <input type="text" name="userName" value="${user.userName}"/>
        password: <input type="password" name="password"/>
        city: <select>
        <c:forEach items="${cityList}" var="city">
            <option>${city}</option>
        </c:forEach>
    </select>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
