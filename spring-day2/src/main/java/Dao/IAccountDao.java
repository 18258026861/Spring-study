package Dao;

import Dao.impl.AccountDaoImpl;
import entity.Account;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:43
 */
public interface IAccountDao {
    List<Account> findAccount();

    Account findById(Integer accountId);

    void saveAccount(String name,float money);

    void updateAccount(Account account);

    void saveAccount(Account account);

    /*void deleteAccount(Integer accountId);*/

}
