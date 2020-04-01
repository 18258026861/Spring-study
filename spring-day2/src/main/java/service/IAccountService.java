package service;

import Dao.impl.AccountDaoImpl;
import entity.Account;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:44
 */
public interface IAccountService {
    List<Account> findAccount();

    Account findById(Integer accountId);

    void saveAccount(String name,float money);

    void updateAccount(Account account);

//    void deleteAccount(Integer accountId);
}
