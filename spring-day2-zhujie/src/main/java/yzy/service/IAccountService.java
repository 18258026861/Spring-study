package yzy.service;

import yzy.entity.Account;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 19:44
 */
public interface IAccountService {
    void findAccount();

    void findById( );

    void saveAccount();

    void updateAccount( );

    void deleteAccount( );
}
