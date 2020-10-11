package tom.yu.account.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tom.yu.account.api.model.Account;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Select("SELECT * FROM account")
    List<Account> getAccounts();

    @Select("SELECT * FROM account WHERE id = #{id}")
    Account getAccountById(@Param("id") String id);

}
