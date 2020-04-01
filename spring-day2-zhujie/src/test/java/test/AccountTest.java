package test;

import config.springConfiguration;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yzy.Dao.IAccountDao;
import yzy.entity.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yzy.service.IAccountService;

import java.util.List;

/**
 * @author YZY
 * @date 2020/3/29 - 21:20
 */

/*Junit单元测试没有main方法，用的@Test注解让其执行，Junit不管是否采用spring框架，
*       所以不会读取配置文件，那么@Autowired这种注解就没用了
*       那么现在要搞出一个main方法才能用注解*/

/*整合spring与junit的配置
*       1.导入spring-test包
*       2.使用junit的一个注解代替main'方法
*               @Runwith
*       3.告知spring 容器，spring基于xml还是注解，并说明位置
*               @ContextConfiguration
*                   locations:指定xml位置+classpath
*                   classes：指定注解类位置
* */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringJUnit4ClassRunner.class)*/
public class AccountTest {
    private ApplicationContext applicationContext;

    private IAccountService accountService;

    @Before
    public void init(){
         applicationContext = new AnnotationConfigApplicationContext(springConfiguration.class);
         accountService =  applicationContext.getBean("accountService",IAccountService.class);

    }

    @Test
    public void findAll() {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        注解不能使用bean.xml配置文件了,要使用注解方式，参数为注解类
        accountService.findAccount();

    }
    @Test
    public void findone() {
        accountService.findById();
    }
    @Test
    public void update() {
        accountService.updateAccount();
    }
    @Test
    public void save() {
        accountService.saveAccount();
    }

    @Test
    public void delete() {
    accountService.deleteAccount();
    }
}
