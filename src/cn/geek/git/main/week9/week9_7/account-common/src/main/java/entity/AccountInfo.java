package entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountInfo {
    private Long id;
    private String user_id;
    private BigDecimal accountBalance_rmb;
    private BigDecimal accountBalance_usa;
    private BigDecimal frozenBalance_rmb;
    private BigDecimal frozenBalance_usa;

}
