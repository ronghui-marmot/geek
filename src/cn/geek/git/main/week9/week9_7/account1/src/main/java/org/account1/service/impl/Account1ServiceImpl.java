package org.account1.service.impl;

import entity.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.account1.mapper.AccountInfoMapper;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.Account1Service;
import service.Account2Service;

import java.math.BigDecimal;

@Service("account1Service")
@Slf4j
public class Account1ServiceImpl implements Account1Service {
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Autowired
    private Account2Service account2Service;

    @Override
    @Transactional
    @HmilyTCC(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public Boolean decreaseBalance(String name, BigDecimal amount) {

        //从账户扣减
        if (accountInfoMapper.decreaseBalance(name, amount) <= 0) {
            //扣减失败
            throw new HmilyRuntimeException("Account1 exception，扣减失败");
        }
        //远程调用account2
        if (!account2Service.increaseAccountBalance("A", amount)) {
            throw new HmilyRuntimeException("account2Client exception");
        }
        if (amount.intValue()==10) {//异常一定要抛在Hmily里面
            throw new RuntimeException("account1 make exception  10");
        }
        log.info("******** Account1 Service  end try...  ");

        return Boolean.TRUE;
    }

    @Override
    public AccountInfo selectByUserId(String user_id) {
        return accountInfoMapper.selectByUserId(user_id);
    }


    public boolean confirmMethod(String user_id, Double amount) {
        int result = accountInfoMapper.confirm();
        log.info("******** Bank1 Service begin commit...");
        return result > 0;
    }

    public boolean cancelMethod(String user_id, Double amount) {
        int result = accountInfoMapper.cancel();
        log.info("******** Bank1 Service end rollback...  ");
        return result > 0;
    }
}
