package test;

import Dao.IAccountDao;
import entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IAccountService;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 21:20
 */

/*测试配置*/
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {
        private ApplicationContext applicationContext;
        private IAccountService accountService;

       /* @Before
        public void init(){
            applicationContext = new ClassPathXmlApplicationContext("bean.xml");
            accountService = (IAccountService) applicationContext.getBean("accountService");

        }*/

    @Test
    public void findAll() {
        List<Account> accounts = accountService.findAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void findone() {

    }
    @Test
    public void update() {

    }
    @Test
    public void save() {
        /*Account account = new Account();
        account.setName("TT");
        account.setMoney(2234f);*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
        accountDao.saveAccount("YY",2324);
    }
    @Test
    public void delete() {

    }
}
