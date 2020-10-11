package tom.yu.account.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Account {
    private String id;
    private String name;
    private AccountType type;
    private Currency currency;
    private BigDecimal balance;
    private LocalDate balanceDate;
}
