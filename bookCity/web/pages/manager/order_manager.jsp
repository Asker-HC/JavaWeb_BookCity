<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>


</head>
<body>

<div id="header">

    <span class="wel_word" style="color: #39987c">订单管理系统</span>

    <%-- 静态包含 manager管理模块的菜单  --%>
    <%@include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>单号</td>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>状态</td>
        </tr>
        <c:if test="${empty requestScope.orders}">
            <tr>
                <td colspan="5"><a href="${pageScope.basePath}pages/manager/manager.jsp">当前系统无订单信息，转至后台管理</a></td>
            </tr>
        </c:if>
        <c:if test="${not empty requestScope.orders}">
            <c:forEach items="${requestScope.orders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.createTime}</td>
                    <td>${order.price}</td>
                    <td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
                    <td>
                        <c:choose>
                            <c:when test="${order.status==0}">
                            <a href="orderServlet?action=sendOrder&orderId=${order.orderId}">点击发货</a>
                            </c:when>
                            <c:when test="${order.status==1}">
                                待签收
                            </c:when>
                            <c:when test="${order.status==2}">
                                已签收
                            </c:when>
                        </c:choose>

                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>