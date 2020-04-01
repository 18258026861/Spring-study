package config;

import entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YZY
 * @date 2020/3/31 - 15:43
 */
//把这个当做配置文件
@Configuration
//conponentScan扫描指定包里的类时如果没有@Configuration注解，spring会自动忽略该类
@ComponentScan("entity")
public class Config {

//    添加bean类  id为方法名称，class为返回值
/*
 * Bean注解，用于把当前的返回值作为bean对象存入spring容器中
 *       属性：name:指定bean的id，默认当前方法的名称
 *       如果使用注解配置方法当中有参数，就会去容器中寻找该参数的bean对象
 *       查找方式和@Autowired一样先类型匹配再名称匹配
 * */
    @Bean(name="person")
    public Person person(){
        return new Person();
    }
}
