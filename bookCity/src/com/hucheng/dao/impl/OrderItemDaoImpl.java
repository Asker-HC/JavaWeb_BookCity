package com.hucheng.dao.impl;

import com.hucheng.dao.OrderItemDao;
import com.hucheng.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        int result = update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
        return result;
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select `name`,`count`,`price`,`total_price` totalPrice,`order_id` orderId from t_order_item where `order_id` = ?";
        List<OrderItem> orderItems = queryForList(OrderItem.class, sql, orderId);
        return orderItems;
    }
}
