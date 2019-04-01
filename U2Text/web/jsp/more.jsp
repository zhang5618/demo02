<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增帖子</title>
    <style type="text/css">
        input {
            line-height: 25px;
            width: 200px
        }
    </style>
</head>
<body bgcolor="#f5f5dc">
<form action="/text/delete" method="post">
    <table>
        <tr>
            <td colspan="2"><h1>添加帖子</h1></td>
        </tr>
        <tr>
            <td>标题</td>
            <td><textarea name="title"  cols="30" rows="2" name="TrueName"></textarea></td>
        </tr>
        <tr>
            <td>内容摘要</td>
            <td><textarea name="summary"  cols="30" rows="10" name="TrueName"></textarea></td>
        </tr>
        <tr>
            <td>作者：</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="button" value="返回" onclick="javascript:location.href='/text/index.jsp'"></td>
        </tr>
    </table>
</form>
</body>
</html>
