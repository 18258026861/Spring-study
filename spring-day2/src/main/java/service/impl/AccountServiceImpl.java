package service.impl;

import Dao.IAccountDao;
import entity.Account;
import service.IAccountService;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:45
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private Account account;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setAccountDao(Account account) {
       accountDao.saveAccount(account);
    }

    @Override
    public List<Account> findAccount() {
        return accountDao.findAccount();
    }

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId) ;
    }

    @Override
    public void saveAccount(String name,float money) {
        accountDao.saveAccount(name,money);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /*@Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }*/
}
