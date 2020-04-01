package service.impl;

import Dao.IAccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.IAccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @author YZY
 * @date 2020/3/28 - 20:41
 */
/*==========创建对象的注解====================
        相当于配置文件中的<bean>标签
@Component作用：把当前类对象存入spring容器
        属性：value：指定bean的id值，如果默认，就是当前类名首字母小写

        @Controller：一般用在表现层
        @Service：业务层
        @Repository：持久层
        这三个和@Component一模一样。
        他们三个是spring狂阶为我们提供的三层使用的注解，本质上没有区别，只是使三层对象更清晰
*
*/

/*=============注入数据的注解=======================
        相当于配置文件中的<bean>标签下的<property>标签
        使用注解注入时就可以不用set方法了
        @Autowired:自动按照类型注入只要容器中有唯一的bean对象类型和注入的类型匹配，就可以注入成功
             注意点：如果有多个类型匹配（第一匹配条件）时，就会报错：这时就要确定变量名（第二匹配条件）
            出现位置：可以是变量上，也可以是方法上

         @Qualifier：在按照类注入的基础上按变量名注入，在给类成员注入时不能单独使用，但是方法注入时可以
*           属性：     value 指定bean的id值

        @Resource ：上面两个的集合体
                属性 ：name  指定bean的id值
        以上三个注入都只能注入其他bean类型的数据，基本类型无法使用，集合类型的只能在xml文件实现

        @Value：用于注入基本类型和string
            属性：value：用于指定数据的值

*/

/*=============注解作用范围=============
        相当于配置文件中的<bean>标签中的scope属性
        @Scope ：指定bean的作用范围
                属性：value 指定范围的取值 这个和配置文件中一样
* */



@Component(value = "accountService")
@Scope(value = "prototype")
public class AccountServiceImpl implements IAccountService {
    //如果是经常变化的数据，并不适用于注入，比如账号密码就不合适
    private String name;
    private Integer age;
    private Date birthday;

    /*（Spring自动帮你匹配）
        Auto用于匹配IAccountDao类型，但是我拥有两个相同的类
        所以如果单独使用@Autowired，就会无法匹配到确定的一个类上，这时候就会报错，这时候就看你变量名是否能够匹配上
   （手动匹配）
        加上@Qualifier指定变量名，不能独立使用，要在@Autowired基础上
    ：那么这时候就不用再创建类的时候指定名称，而是注解指定
    */

    /*@Autowired
    @Qualifier(value = "accountDao2")*/
    //这哥们一个顶上面俩
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    public AccountServiceImpl(){
    }

    public AccountServiceImpl(String name,int age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

    /*==============注解生命周期（了解）==============
            相当于配置文件中的<bean>标签中的init-method和destroy-method属性
            @PreDestroy :销毁方法
            @PostConstruct： 创建方法
    * */
    @PostConstruct
    public void init(){
        System.out.println("对象出生");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("对象死亡");
    }

    @Override
    public void showAccout() {
        System.out.println(name+age+birthday);
    }
}
