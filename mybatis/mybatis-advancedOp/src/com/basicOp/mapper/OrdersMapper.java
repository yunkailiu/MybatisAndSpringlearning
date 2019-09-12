package com.basicOp.mapper;

import java.util.HashMap;
import java.util.List;

import com.basicOp.pojo.Orders;
import com.basicOp.pojo.OrdersCustom;
import com.basicOp.pojo.User;

public interface OrdersMapper {

	public List<OrdersCustom> findOrderUser();

	public List<Orders> findOrdersAndOrderDetailResultMap();

	public List<User> findUserAndItemsResultMap();

	public List<Orders> findOrdersUserLazyLoading();
}
