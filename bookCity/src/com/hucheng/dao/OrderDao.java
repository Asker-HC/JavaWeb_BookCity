package com.hucheng.dao;

import com.hucheng.pojo.Order;

import java.util.List;

public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> queryOrders();
    public void changeOrderStatus(String orderId,int status);
    public List<Order> queryOrdersByUserId(int userId);
    public Order queryOrderByOrderId(String orderId);
}
