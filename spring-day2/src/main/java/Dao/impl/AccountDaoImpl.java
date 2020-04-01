package Dao.impl;

import Dao.IAccountDao;
import entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:44
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    private JdbcTemplate jdbcTemplate;

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public List<Account> findAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public Account findById(Integer accountId) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void saveAccount(String name,float money) {
        String sql="insert into account(name,money) values(?,?)";
        jdbcTemplate.update(sql,name,money);
        /*try {
                 runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?,money = ? where id = ? ", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAccount(Account account) {

    }


    /*@Override
      public  void deleteAccount(Integer accountId){
        try {
            runner.update("delete from account where id = ?",accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}


