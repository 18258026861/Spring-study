package yzy.service.impl;

import yzy.Dao.IAccountDao;
import yzy.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yzy.service.IAccountService;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:45
 */
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;





    @Override
    public void findAccount() {
        accountDao.findAccount();
    }

    @Override
    public void findById() {
         accountDao.findById() ;
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }


    @Override
    public void updateAccount( ) {

        accountDao.updateAccount();
    }

    @Override
    public void deleteAccount( ) {

        accountDao.deleteAccount();
    }
}
