package com.hucheng.service;

import com.hucheng.pojo.Cart;
import com.hucheng.pojo.Order;
import com.hucheng.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
    public List<Order> showAllOrders();
    public void sendOrder(String orderId);
    public List<OrderItem> showOrderDetail(String orderId);
    public List<Order> showMyOrder(int userId);
    public void receiverOrder(String orderId);
    public Order queryOrderByOrderId(String orderId);
}
