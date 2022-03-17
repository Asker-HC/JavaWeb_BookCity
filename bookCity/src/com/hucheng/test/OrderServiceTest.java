package com.hucheng.test;

import com.hucheng.pojo.Cart;
import com.hucheng.pojo.CartItem;
import com.hucheng.pojo.Order;
import com.hucheng.pojo.OrderItem;
import com.hucheng.service.OrderService;
import com.hucheng.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "a", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "b", 1, new BigDecimal(100), new BigDecimal(100)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }

    @Test
    public void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        System.out.println(orders);
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("1111");
    }

    @Test
    public void showOrderDetail() {
        List<OrderItem> orderItems = orderService.showOrderDetail("16461234950612");
        System.out.println(orderItems);
    }

    @Test
    public void showMyOrder() {
        List<Order> orders = orderService.showMyOrder(2);
        System.out.println(orders);
    }

    @Test
    public void receiverOrder() {
    }
}