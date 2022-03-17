package com.hucheng.web;

import com.hucheng.pojo.Cart;
import com.hucheng.pojo.Order;
import com.hucheng.pojo.OrderItem;
import com.hucheng.pojo.User;
import com.hucheng.service.OrderService;
import com.hucheng.service.UserService;
import com.hucheng.service.impl.OrderServiceImpl;
import com.hucheng.service.impl.UserServiceImpl;
import com.hucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.sendOrder(orderId);
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        Order order = orderService.queryOrderByOrderId(orderId);
        request.setAttribute("orderItems", orderItems);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/pages/order/order_detail.jsp").forward(request,response);
    }
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = WebUtils.parseInt(request.getParameter("userId"), 0);
        List<Order> orders = orderService.showMyOrder(userId);
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }
    protected void receiverOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.receiverOrder(orderId);
        response.sendRedirect(request.getHeader("Referer"));
    }
}
