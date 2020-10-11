package tom.yu.account.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tom.yu.account.api.model.Transaction;

import java.util.List;

@Mapper
public interface TransactionMapper {

    @Select("SELECT * FROM transactions WHERE account_id = #{accountId}")
    @Results(
            @Result(property = "account", column = "account_id",
                    one = @One(select = "tom.yu.account.api.mapper.AccountMapper.getAccountById")
            )
    )
    List<Transaction> getTransactionsByAccountId(@Param("accountId") String id);
}
