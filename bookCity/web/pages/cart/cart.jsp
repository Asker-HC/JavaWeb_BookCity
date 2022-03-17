<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("你是否确认删除[" + $(this).parent().parent().find("td:first").text() + "]？");
            })

            $("a.clearClass").click(function () {
                return confirm("你是否确认清空购物车？");
            })

            $(".updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                var id = $(this).attr("id");
                if (this.value > 0){
                    var count = Math.round(this.value);
                }else{
                    var count = 1;
                }
                if (confirm("确定要将【" + name + "】商品数量改为：" + count + "吗？")) {
                    location.href = "${pageScope.basePath}cartServlet?action=updateCount&id=" + id + "&count=" + count;
                } else {
                    this.value = this.defaultValue;
                }
            })
        });
    </script>

</head>
<body>

<div id="header">

    <span class="wel_word" style="color: #39987c">购物车</span>

    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>


</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input class="updateCount" style="width: 50px"
                           id="${entry.value.id}"
                           type="text" value="${entry.value.count}">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteClass" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空! 请前往选购商品</a></td>
            </tr>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clearClass"
                                       href="cartServlet?action=clearItem&id=${entry.value.id}">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>