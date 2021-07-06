package service;

import entity.AccountInfo;

import java.math.BigDecimal;

public interface Account1Service {
//    boolean payment()
    Boolean decreaseBalance(String userId, BigDecimal amount);
    AccountInfo selectByUserId(String userId);
}
