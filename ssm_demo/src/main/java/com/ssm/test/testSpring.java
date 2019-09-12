package com.ssm.test;

import com.ssm.dao.AccountDao;
import com.ssm.pojo.Account;
import com.ssm.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试文件
 */
public class testSpring {

    /**
     * 测试Service是否连接成功
     */
    @Test
    public void testService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.findAll();
    }

    /**
     * 测试查询功能
     * @throws Exception
     */
    @Test
    public void testFindAllAndById() throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        // 调用查询方法
        List<Account> accounts = dao.findAll();
        for (Account account:accounts){
            System.out.println(account.toString());
        }
        System.out.println(dao.findById(1));
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试插入功能
     */
    @Test
    public void testSaveAccount() throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        // 调用插入方法
        Account account = new Account();
        account.setName("樊振东");
        account.setMoney(1000d);
        dao.saveAccount(account);

        // 事务提交
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试删除
     */
    @Test
    public void testDeleteAccount() throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        // 调用插入方法
        dao.deleteAccount(11);
        // 事务提交
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdateAccount() throws Exception {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        // 调用插入方法
        Account account = dao.findById(1);
        account.setMoney(3000d);
        dao.updateAccount(account);
        // 事务提交
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
