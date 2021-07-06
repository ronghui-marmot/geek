package service;

import java.math.BigDecimal;

public interface Account2Service {
    Boolean increaseBalance(String userId, BigDecimal amount);
    String hi(String world);
}
