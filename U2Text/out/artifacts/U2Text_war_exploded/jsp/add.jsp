<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增回复</title>
    <style type="text/css">
        input {
            line-height: 25px;
            width: 200px
        }
    </style>
</head>
<body bgcolor="#f5f5dc">
<form action="/text/reply" method="post" onsubmit="return check1()">
    <input type="hidden" value="${param.invid}" name="invid">
    <table>
        <tr>
            <td colspan="2"><h1>添加回复</h1></td>
        </tr>

        <tr>
            <td>回复内容：（*）</td>
            <td><textarea name="content"  cols="30" rows="10" name="TrueName" id="TrueName"></textarea></td>
        </tr>
        <tr>
            <td>回复昵称：</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="button" value="返回" onclick="javascript:location.href='/text/index.jsp'"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function check1() {
        var v = document.getElementById("TrueName").value;
        if (v.trim() == "") {
            alert('必须输入回复内容！');
            return false;
        }
    }
</script>
</html>
