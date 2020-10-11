package tom.yu.account.api.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import tom.yu.account.api.model.Account;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testGetAccounts() {
        List<Account> accounts = accountMapper.getAccounts();
        Assert.assertEquals(6, accounts.size());
    }

    @Test
    public void testGetAccountByIdSuccess() {
        Account account = accountMapper.getAccountById("00001");
        Assert.assertEquals(new BigDecimal(29870), account.getBalance());
    }

    @Test
    public void testGetAccountByIdNotFound() {
        Account account = accountMapper.getAccountById("abcd");
        Assert.assertNull(account);
    }
}
