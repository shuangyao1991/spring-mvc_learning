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
    <title>学校信息</title>
</head>
<body>
    <form method="post">
        <table>
            <tr>
                <td>学校类型：</td>
                <td>
                    <select name="schoolInfo.type">
                        <c:forEach items="${schoolTypeList}" var="schoolType">
                            <option value="${schoolType}"
                                <c:if test="${user.schoolInfo.type eq schoolType}">
                                    selected = "selected"
                                </c:if>
                            >${schoolType}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>学校名称：</td>
                <td>
                    <input type="text" name="schoolInfo.name" value="${user.schoolInfo.name}"/>
                </td>
            </tr>
            <tr>
                <td>专业：</td>
                <td>
                    <input type="text" name="schoolInfo.specialty" value="${user.schoolInfo.specialty}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="_target0" value="上一步"/>
                </td>
                <td>
                    <input type="submit" name="_target2" value="下一步"/>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
