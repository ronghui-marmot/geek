package org.account1.mapper;

import entity.AccountInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;


public interface AccountInfoMapper {
    @Update("update account set accountBalance_rmb = accountBalance_rmb - #{amount} , freeze_amount_rmb = freeze_amount_rmb + #{amount} " +
            "where accountBalance_rmb > #{amount} and user_id = #{user_id}")
    int decreaseBalance(@Param("user_id") String user_id, @Param("amount") BigDecimal amount);

    @Update("update account set  freeze_amount_rmb = 0 " +
            "where freeze_amount_rmb > 0")
    int confirm();

    @Update("update account set accountBalance_rmb = accountBalance_rmb + freeze_amount_rmb , freeze_amount_rmb = 0 " +
            "where freeze_amount_rmb > 0")
    int cancel();

    @Select("select id as 'id',balance_rmb as 'accountBalance_rmb',balance_usa as 'accountBalance_usa', freeze_amount_rmb as 'frozenBalance_rmb',freeze_amount_usa as 'frozenBalance_usa'" +
            " from account where user_id = #{user_id}")
    AccountInfo selectByUserId(String user_id);
}
