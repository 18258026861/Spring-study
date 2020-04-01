
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

/**
 * @author YZY
 * @date 2020/3/28 - 15:11
 */
public class t {
    public static void main(String[] args) {
        //这种耦合性很强，需要通过spring改进
       /* IAccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();*/
        //如果要关闭方法，那么要使用这种创建方式
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");


        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        //accountService.saveAccount();

        //关闭
        applicationContext.close();





    }
}
