package yzy.Dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import yzy.Dao.IAccountDao;
import yzy.entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:44
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements IAccountDao {


    @Override
    public void findAccount() {
        System.out.println("findAccount");
    }

    @Override
    public void findById() {
        System.out.println("findById");
    }

    @Override
    public void saveAccount() {
        System.out.println("saveAccount");
    }

    @Override
    public void updateAccount() {
        System.out.println("updateAccount");
    }

    @Override
    public void deleteAccount() {
        System.out.println("deleteAccount");
    }


}
