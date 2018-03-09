package model.adminRequests;

import model.order.Order;
import model.user.User;

import java.util.List;

public interface iRequests {
    List<Order> selectAllApproved();
    List<Order> selectAllOrders();
}
