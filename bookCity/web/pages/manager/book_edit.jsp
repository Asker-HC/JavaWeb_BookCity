<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <span class="wel_word" style="color: #39987c">编辑图书</span>
    <%-- 静态包含 manager管理模块的菜单  --%>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <form action="manager/bookServlet" method="post">
        <input type="hidden" name="action" value="${empty param.id? "add":"update"}"/>
        <input type="hidden" name="id" value="${requestScope.book.id}"/>
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <table>
            <tr>
                <td>书名</td>
                <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
            </tr>
            <tr>
                <td>作者</td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
            </tr>
            <tr>
                <td>销量</td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
            </tr>
            <tr>
                <td>库存</td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
            </tr>
            <tr>
                <td>操作</td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>