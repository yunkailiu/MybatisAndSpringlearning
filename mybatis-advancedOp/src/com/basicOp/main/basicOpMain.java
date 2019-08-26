package com.basicOp.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.basicOp.mapper.OrdersMapper;
import com.basicOp.pojo.Orders;
import com.basicOp.pojo.OrdersCustom;
import com.basicOp.pojo.User;
import com.basicOp.utils.SqlSessionFactoryUtils;

public class basicOpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testFindOrderUser();
		// testFindOrdersAndOrderDetailResultMap();
		// testFindUserAndItemsResultMap();
		testFindOrdersUserLazyLoading();

	}

	// 一对一映射查询
	public static void testFindOrderUser() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			OrdersMapper userMapper = sqlSession.getMapper(OrdersMapper.class);
			List<OrdersCustom> list = userMapper.findOrderUser();
			logger.info(list);
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 一对多映射查询
	public static void testFindOrdersAndOrderDetailResultMap() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			OrdersMapper userMapper = sqlSession.getMapper(OrdersMapper.class);
			List<Orders> list = userMapper.findOrdersAndOrderDetailResultMap();
			logger.info(list);
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 多对多映射查询
	public static void testFindUserAndItemsResultMap() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			OrdersMapper userMapper = sqlSession.getMapper(OrdersMapper.class);
			List<User> list = userMapper.findUserAndItemsResultMap();
			logger.info(list);
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 延迟加载
	public static void testFindOrdersUserLazyLoading() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
			List<Orders> list = ordersMapper.findOrdersUserLazyLoading();
			logger.info(list);
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
