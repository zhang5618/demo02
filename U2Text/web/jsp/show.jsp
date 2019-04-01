
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f5f5dc">
<h1 align="center" style="color: brown">课工场论坛管理系统</h1>
<form action="${pageContext.request.contextPath}/show" method="post" style="text-align: center">
    <table border="1" align="center" bgcolor="#ff7f50" bordercolor="blue" cellpadding="20" cellspacing="0">
        <tr>
            <td colspan="7" align="center"><h1>帖子列表</h1></td>
        </tr>
        <tr align="center">
            <td colspan="7">
                帖子标题: <input type="text" name="title" class="clear" value="${sessionScope.page.title}">
                <input type="hidden" name="currPage" value="1">
                <input type="submit" value="查询">
            </td>
        </tr>
        <tr>
            <td>序号</td>
            <td>标题</td>
            <td>内容摘要</td>
            <td>作者</td>
            <td>发布时间</td>
            <td>操作</td>
            <td><a href="/text/jsp/more.jsp">新增帖子</a></td>
        </tr>
        <c:if test="${not empty sessionScope.list}">
            <c:forEach var="invi" items="${sessionScope.list}" varStatus="vs">
                <tr <c:if test="${vs.index%2==0}">bgcolor="#a52a2a"</c:if>>
                    <td>${invi.id}</td>
                    <td>${invi.title}</td>
                    <td>${invi.summary}</td>
                    <td>${invi.author}</td>
                    <td>${invi.createdate}</td>
                    <td><a href="/text/reply?invid=${invi.id}">查看回复</a></td>
                    <td><a href="/text/delete?id=${invi.id}" onclick="return confirm('确定删除该条发帖及相关回复?')">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7" align="center">${sessionScope.msg}</td>
            </tr>
        </c:if>
    </table>
    <%--分页--%>
    <table border="1" cellpadding="15" cellspacing="10" align="center" bgcolor="fuchsia">
        <tr>
            <td><a href="javascript:toPage(1)">首页</a></td>
            <td><a href="javascript:toPage(${sessionScope.page.currPage-1})">上一页</a></td>
            <c:forEach var="i" begin="1" end="${sessionScope.page.totalPage}">
                <td><a href="javascript:toPage(${i})">${i}</a></td>
            </c:forEach>
            <td><a href="javascript:toPage(${sessionScope.page.currPage+1})">下一页</a></td>
            <td><a href="javascript:toPage(${sessionScope.page.totalPage})">尾页</a></td>
            <td>跳转到第<input style="width: 30px;" type="text" value="${sessionScope.page.currPage}">页，
                <input style="width: 30px;" onclick="toPage(this.previousElementSibling.value)"
                       type="button" value="go"></td>
        </tr>
    </table>
</form>

</body>
<script>
    var ops = document.getElementsByClassName("clear")
    for (var i = 0; i < ops.length; i++) {//实现双击清除输入框里面的数据
        ops[i].ondblclick = function () {
            this.value = "";

        }
    }

    function toPage(currPage) {
        if (currPage < 1) {
            currPage = 1;
        }
        var totalPage = ${sessionScope.page.totalPage};
        if (currPage > totalPage) {
            currPage = totalPage;
        }
        if (currPage == 0) {
            currPage = 1;
        }
        /*是浏览器地址栏   属于客户端路径*/
        location.href = "/text/show?currPage=" + currPage;
    }


</script>
</html>
