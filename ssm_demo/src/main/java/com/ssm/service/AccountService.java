package com.ssm.service;
import com.ssm.pojo.Account;
import java.util.List;

/**
 * 业务层接口
 */
public interface AccountService {
    /**
     * 查询所有用户
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 添加并保存用户
     * @param account
     */
    public void saveAccount(Account account);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteAccount(Integer id);

    /**
     * 更新用户信息
     * @param account
     */
    public void updateAccount(Account account);
}
