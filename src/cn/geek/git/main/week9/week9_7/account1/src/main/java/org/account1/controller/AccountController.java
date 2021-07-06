package org.account1.controller;

import entity.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Account1Service;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account1")
public class AccountController {
    @Autowired
    private Account1Service account1Service;


    @RequestMapping("/transfer")
    public Boolean transferNest() {
        return account1Service.decreaseBalance("A", new BigDecimal(1));
    }

    @GetMapping("/get")
    public AccountInfo get(@RequestParam("user_id") String user_id){
        return account1Service.selectByUserId(user_id);
    }
}
