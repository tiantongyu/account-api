package tom.yu.account.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tom.yu.account.api.mapper.AccountMapper;
import tom.yu.account.api.mapper.TransactionMapper;
import tom.yu.account.api.model.Account;
import tom.yu.account.api.model.Transaction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class AccountApiController {

    private AccountMapper accountMapper;
    private TransactionMapper transactionMapper;

    @Autowired
    public AccountApiController(AccountMapper accountMapper,
                                TransactionMapper transactionMapper) {
        this.accountMapper = accountMapper;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping("/accounts")
    public List<Account> retrieveAccounts() {
        try {
            LocalDate now = LocalDate.now();
            List<Account> accounts = accountMapper.getAccounts();
            accounts.forEach(account -> account.setBalanceDate(now));
            return accounts;
        } catch (Exception e) {
            log.error("An internal error occurred: {}.\nStacktrace: {}", e.getMessage(), e.getStackTrace());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/account/{accountId}/transactions")
    public List<Transaction> retrieveTransactions(@PathVariable String accountId) {
        try {
            return transactionMapper.getTransactionsByAccountId(accountId);
        } catch (Exception e) {
            log.error("An internal error occurred: {}.\nStacktrace: {}", e.getMessage(), e.getStackTrace());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
