<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/5
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${not empty sessionScope.user}">
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临线上书城</span>
        <a href="orderServlet?action=showMyOrders&userId=${sessionScope.user.id}">我的订单</a>
        <a href="userServlet?action=logout">注销</a>
        <a href="index.jsp">返回</a>
    </c:if>
</div>