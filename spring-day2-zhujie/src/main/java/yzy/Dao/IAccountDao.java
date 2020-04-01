package yzy.Dao;

import yzy.entity.Account;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:43
 */
public interface IAccountDao {
    void findAccount();

    void findById();

    void saveAccount();

    void updateAccount();

    void deleteAccount();

}
