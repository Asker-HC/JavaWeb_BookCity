<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>


</head>
<body>

<div id="header">

    <span class="wel_word" style="color: #39987c">订单号：${requestScope.orderItems[0].orderId}</span>

    <%-- 静态包含 manager管理模块的菜单  --%>
    <%@include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
    <div>
        <span style="color: green">客户ID：</span>
        ${requestScope.order.userId}
        &nbsp;&nbsp;
        <span style="color: green">时间：</span>
        ${requestScope.order.createTime}
        &nbsp;&nbsp;
        <span style="color: green">总金额：</span>
        ${requestScope.order.price}元
        &nbsp;&nbsp;
        <span style="color: green">当前状态：</span>
        <c:choose>
            <c:when test="${order.status==0}">
                等待商家发货
            </c:when>
            <c:when test="${order.status==1}">
                等待客户签收
            </c:when>
            <c:when test="${order.status==2}">
                订单已完成
            </c:when>
        </c:choose>
    </div>
    <table>
        <tr>
            <td>商品</td>
            <td>价格</td>
            <td>数量</td>
            <td>金额</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.count}</td>
                <td>${item.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>