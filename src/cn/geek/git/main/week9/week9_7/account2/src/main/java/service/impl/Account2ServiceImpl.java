package service.impl;

import lombok.extern.slf4j.Slf4j;
import mapper.AccountInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.Account2Service;

import java.math.BigDecimal;

@Service("account2Service")
@Slf4j
public class Account2ServiceImpl implements Account2Service {
    @Autowired
    AccountInfoMapper accountInfoMapper;
    @Override
    @Transactional
    @HmilyTCC(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public Boolean increaseBalance(String user_id, BigDecimal amount) {
        accountInfoMapper.increaseAccountBalance(user_id, amount);
        log.info("******** Account2 Service Begin try ...");
        return Boolean.TRUE;
    }

    @Override
    public String hi(String serverName) {
        return "hello，" + serverName;
    }


    public void confirmMethod(String user_id, Double amount) {
        accountInfoMapper.confirmAccountBalance();
        log.info("******** Account2 Service commit...  ");
    }

    public void cancelMethod(String user_id, Double amount) {
        accountInfoMapper.cancelAccountBalance(user_id);
        log.info("******** Account2 Service begin cancel...  ");

    }
}
