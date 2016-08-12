<%--
  Created by IntelliJ IDEA.
  User: shuangyao
  Date: 2016/8/12
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一页</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td>
                <input type="text" name="userName" value="${user.userName}"
                       onfocus="javascript: if(this.value == '请输入用户名') this.value='';"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="_target1" value="下一步"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
