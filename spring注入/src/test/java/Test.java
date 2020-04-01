import Dao.IAcountDao;
import entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * @author YZY
 * @date 2020/3/28 - 15:11
 */
public class Test {
    public static void main(String[] args) {
        //这种耦合性很强，需要通过spring改进
       /* IAccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();*/

/*
    applicationcontext:拿到spring容器
    根据id获取对象

    Applicationcontext的三个常用实现类：
     （常用）ClassPathXmlApplicationContext：加载类路径下的配置文件，
                                要求配置文件必须在类路径下，不在的话，加载不了
            FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）
            AnnotationConfigApplicationContext：用于读取注解创建容器的

       核心同期的两个接口引发的问题：
       ApplicationContext:  （单例对象使用）
            他在构建核心容器时，创建对象采取的策略是采用立即加载的方式。
            也就是说，只要一读取完配置文件就立马创建配置文件中的对象
        BeanFactory:   功能不够完善 （多例对象使用）
            它创建核心容器时，创建对象采取的策略是采用延迟加载的方式。
            也就是说，什么时候根据id获取对象了，什么时候才创建对象

*/

        //-------ApplicationContext---- 读取配置文件，读取完就创建完对象了
        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //这句话执行完后就已经创建对象了

        //IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        //IAccountService accountService1 =  applicationContext.getBean("accountServlet",accountService.getClass());



         //----------BeanFactory-------- 读取id获取对象后才创建对象
        /*Resource resource = new ClassPathResource("bean.xml");
        //知道下面那句通过id获取对象后才创建了对象
        BeanFactory factory = new XmlBeanFactory(resource);

        IAccountService accountService1 = (IAccountService) factory.getBean("accountService");
    */

        //IAccountService accountService2 = (IAccountService) applicationContext.getBean("accountService");
        //System.out.println(accountService == accountService2);//prototype多例范围下false

        /*//手动关闭容器
        applicationContext.close();//当前这个对象是实现类，但是看成了接口类型，这时候要用子类（ClassPathXmlApplicationContext）不用父类(pplicationContext)
        //当对象是多例时，并不会出现销毁*/

        //IAccountService accountService2 = (IAccountService) applicationContext.getBean("accountService2");

        /*IAccountService accountService3 = (IAccountService) applicationContext.getBean("accountService3");
        accountService3.showAccout();
        */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = applicationContext.getBean("person",Person.class);

        person.shout();


    }

}
