package com.basicOp.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {
	public static final Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
	private static SqlSessionFactory sqlSessionFactory = null;

	private SqlSessionFactoryUtils() {
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		synchronized (LOCK) {
			if (sqlSessionFactory != null) {
				return sqlSessionFactory;
			}
			try {
				//获得mybatis配置文件
				String resource = "mybatis-config.xml";
				//得到配置文件流
				InputStream inputStream = Resources.getResourceAsStream(resource);
				//通过配置文件流创建会话工厂，传入mabatis的配置文件信息
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return sqlSessionFactory;
		}
	}

	public static SqlSession openSqlSession() {
		if (sqlSessionFactory == null) {
			getSqlSessionFactory();
		}
		//通过工厂得到SqlSession
		return getSqlSessionFactory().openSession();
	}
}
