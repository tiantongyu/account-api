package tom.yu.account.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Transaction {
    private String id;
    private Account account;
    private Currency currency;
    private BigDecimal amount;
    private String narrative;
    private LocalDate date;
}
