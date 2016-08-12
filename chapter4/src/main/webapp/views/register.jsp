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
        <table>
            <tr>
                <td>账号名：</td>
                <td>
                    <input type="text" name="userName" value="${user.userName}"
                        onfocus="javascript: if(this.value == '请输入用户名') this.value='';"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td>城市：</td>
                <td>
                    <select>
                        <c:forEach items="${cityList}" var="city">
                            <option>${city}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="注册"/>
                </td>
            </tr>
        </table>
        <%--userName: <input type="text" name="userName" value="${user.userName}"/>--%>
        <%--password: <input type="password" name="password"/>--%>
        <%--city: <select>--%>
        <%--<c:forEach items="${cityList}" var="city">--%>
            <%--<option>${city}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>
        <%--<input type="submit" value="注册"/>--%>
    </form>
</body>
</html>
