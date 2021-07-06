package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Account2Service;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account2")
public class AccountController {
    @Autowired
    private Account2Service account2Service;
    @GetMapping("/hi")
    public String hello(){
        return "hi,this is account2!";
    }

    @RequestMapping("/transfer")
    public Boolean test2(@RequestParam("amount") Double amount) {
        this.account2Service.increaseBalance("B", BigDecimal.valueOf(amount));
        return true;
    }
}