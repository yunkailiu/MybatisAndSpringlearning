package com.basicOp.main;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.basicOp.mapper.UserMapper;
import com.basicOp.pojo.User;
import com.basicOp.pojo.UserCustom;
import com.basicOp.pojo.UserQueryVo;
import com.basicOp.utils.SqlSessionFactoryUtils;

public class basicOpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testFindUserById();
		// testFindUserByName();
		// testInsertUser();
		// testDeleteUser();
		// testUpdateUser();
		 testFindUserList();
		// testFindUserMap();
		// testFindUserByIdMap();

	}

	// 获得通过id查询得到的User结果
	public static void testFindUserById() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.findUserById(1);
			logger.info(user.toString());
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 利用username进行模糊查询
	public static void testFindUserByName() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			List<User> users = userMapper.findUserByName("小明");
			for (User user : users) {
				logger.info(user.toString());
			}
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 插入数据
	public static void testInsertUser() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setUsername("许昕");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setAddress("中国徐州");
			userMapper.insertUser(user);
			// 提交事务
			sqlSession.commit();
			logger.info(user);
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 删除数据
	public static void testDeleteUser() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteUser(28);
			// 提交事务
			sqlSession.commit();

		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 更新数据
	public static void testUpdateUser() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User();
			user.setId(27);
			user.setUsername("许昕");
			user.setAddress("江苏徐州");
			userMapper.updateUser(user);
			// 提交事务
			sqlSession.commit();

		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 信息综合查询
	public static void testFindUserList() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			UserQueryVo userQueryVo = new UserQueryVo();
			UserCustom userCustom = new UserCustom();
			// userCustom.setSex("1");
			userCustom.setUsername("张三");
			userQueryVo.setUserCustom(userCustom);
			List<UserCustom> list = userMapper.findUserList(userQueryVo);
			logger.info(list);

		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// hashmap查询
	public static void testFindUserMap() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("id", 27);
			hashMap.put("username", "许昕");
			List<User> list = userMapper.findUserMap(hashMap);
			logger.info(list);

		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// 根据id查询用户信息，使用resultMap输出
	public static void testFindUserByIdMap() {
		Logger logger = Logger.getLogger(basicOpMain.class);
		SqlSession sqlSession = null;
		try {
			// 创建会话
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			// 利用sqlSession获得对应的mapper接口后，开始操作数据库
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.findUserByIdMap(27);
			logger.info(user);
		} finally {
			// TODO: handle finally clause
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
