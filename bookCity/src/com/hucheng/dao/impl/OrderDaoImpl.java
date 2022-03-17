package com.hucheng.dao.impl;

import com.hucheng.dao.OrderDao;
import com.hucheng.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        int result = update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        return result;
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public void changeOrderStatus(String orderId, int status) {
        String sql = "update t_order set `status`=? where `order_id` = ?";
        update(sql, status, orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where `user_id` = ?";
        return queryForList(Order.class, sql, userId);
    }

    @Override
    public Order queryOrderByOrderId(String orderId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where `order_id` = ?";
        return queryForOne(Order.class, sql, orderId);
    }


}
