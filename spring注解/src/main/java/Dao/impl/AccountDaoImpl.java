package Dao.impl;

import Dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author YZY
 * @date 2020/3/28 - 20:44
 */
@Repository(value = "accountDao1")
public class AccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("saveaccout1");
    }
}
