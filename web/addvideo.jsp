<%--
  Created by IntelliJ IDEA.
  User: 李克顺
  Date: 2019/3/11
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/VideoServlet?info=addvideo" enctype="multipart/form-data" method="post">
    <table align="center">
        <tr>
            <td>账号</td>
            <td><input type="text" name="id"  value="${param.get('id')}" readonly></td>
        </tr>
        <tr>
            <td>视频</td>
            <td><input type="file" name="video"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
