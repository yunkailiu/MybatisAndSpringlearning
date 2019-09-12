package com.ssm.dao;

import com.ssm.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 与数据库做交互的接口
 */
@Repository
public interface AccountDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    public Account findById(Integer id);

    /**
     * 添加并保存用户
     * @param account
     */
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from account where id = #{id}")
    public void deleteAccount(Integer id);

    /**
     * 更新用户信息
     * @param account
     */
    @Update("update account set money = #{money} where id = #{id}")
    public void updateAccount(Account account);
}
