package com.ssm.controller;

import com.ssm.pojo.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有数据
     *
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有用户");
        List<Account> accounts = accountService.findAll();
        /*for (Account account: accounts) {
            System.out.println(account);
        }*/
        model.addAttribute("accounts", accounts);
        return "list";
    }

    /**
     * 按照id查询用户
     *
     * @return
     */
    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam(value = "id") Integer id) {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(accountService.findById(id));
        model.addAttribute("accounts", accounts);
        return "list";
    }

    /**
     * 保存账户
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:findAll";
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String deleteAccount(@RequestParam(value = "id") Integer id) {
        accountService.deleteAccount(id);
        return "redirect:findAll";
    }

    /**
     * 更新用户金额
     * @param account
     * @return
     */
    @RequestMapping("/update")
    public String updateAccount(Model model,Account account) {
        accountService.updateAccount(account);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(accountService.findById(account.getId()));
        model.addAttribute("accounts", accounts);
        return "list";
    }
}
