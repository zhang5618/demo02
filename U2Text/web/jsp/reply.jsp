
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>回复信息列表</title>
</head>
<body bgcolor="#f5f5dc">

<form action="/jsp/add.jsp" method="post">
    <table border="1" style="margin: 100px auto" align="center" bgcolor="#ff7f50" bordercolor="blue" cellpadding="20" cellspacing="0">
        <tr>
            <td colspan="3">
                <h1 align="center" style="color: brown">回复信息列表</h1>
            </td>
        </tr>
        <tr>
            <td colspan="3" align="right"><a href="/text/jsp/add.jsp?invid=${param.invid}">评论</a><input type="button" value="返回帖子列表" onclick="javascript:location.href='/text/index.jsp'"></td>
        </tr>
        <tr>
            <td>回复内容</td>
            <td>回复昵称</td>
            <td>发布时间</td>
        </tr>
        <c:if test="${not empty sessionScope.reps}">
            <c:forEach var="rep" items="${sessionScope.reps}" varStatus="vs">
                <tr <c:if test="${vs.index%2==0}">bgcolor="#a52a2a"</c:if>>
                    <td>${rep.content}</td>
                    <td>${rep.author}</td>
                    <td><fmt:formatDate value="${rep.createdate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</form>


</body>
</html>
