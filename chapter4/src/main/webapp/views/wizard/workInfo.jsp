<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shuangyao
  Date: 2016/8/12
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作信息</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>所在城市：</td>
            <td>
                <select name="workInfo.city">
                    <c:forEach items="${cityList}" var="city">
                        <option value="${city}"
                                <c:if test="${user.workInfo.city eq city}">
                                    selected = "selected"
                                </c:if>
                        >${city}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>职位：</td>
            <td>
                <input type="text" name="workInfo.job" value="${user.workInfo.job}"/>
            </td>
        </tr>
        <tr>
            <td>工作年限：</td>
            <td>
                <input type="text" name="workInfo.year" value="${user.workInfo.year}"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="_target1" value="上一步"/>
            </td>
            <td>
                <input type="submit" name="_finish" value="完成"/>
            </td>
            <td>
                <input type="submit" name="_cancel" value="取消"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
