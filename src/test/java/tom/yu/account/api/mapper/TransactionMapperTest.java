package tom.yu.account.api.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import tom.yu.account.api.model.Currency;
import tom.yu.account.api.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
public class TransactionMapperTest {
    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    public void getTransactionsByAccountId() {
        List<Transaction> transactions = transactionMapper.getTransactionsByAccountId("00001");
        Assert.assertEquals(3, transactions.size());
        Transaction first = transactions.get(0);
        Assert.assertEquals(new BigDecimal(1000), first.getAmount());
        Assert.assertEquals(Currency.AUD, first.getCurrency());
        Assert.assertEquals("testaccount1", first.getAccount().getName());
    }
}
