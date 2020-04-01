package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author YZY
 * @date 2020/3/29 - 23:22
 */
/*
* 该类是一个配置类，它的作用和bean.xml是一样的
* spring新注解
* --@configuration
*   作用：指定当前类是一个配置类
*   当配置类作为AnnotationConfigApplicatonContext对象创建参数时，该注解可以不写
* --@componentScan
*   作用：用于通过注解指定spring在创建容器时要扫描的包
*   属性：value：
*       basepage两者作用一样，都用于指定容器要扫描的包
*       使用此注解相当于在xml中配置了
*           <context:component-scan base-package="yzy"></context:component-scan>
* --@import
*       前面说如果扫描的类前没有@Configration就会忽略，
*       要么在创建容器的时候加上该类这个参数，要么加注解，但是我两者都不想做，该咋办呢？
*   这时候就使用@import注解
*       value:用于指定其他配置类的字节码
*       import注解所在的事父配置类，导入的都是子配置类
*       spring配置中父子关系配置更合理
*
* ----@Properties
*           指定properties文件位置
*       classpath：表示类路径下
* */
@Configuration
@ComponentScan(basePackages = "yzy")
@Import(jdbcConfiguration.class)
//conponentScan扫描指定包里的类时如果没有@Configuration注解，spring会自动忽略该类
@PropertySource("classpath:jdbcConfiguration.properties")
public class springConfiguration {
/*
* Bean注解，用于把当前的返回值作为bean对象存入spring容器中
*       属性：name:指定bean的id，默认当前方法的名称
*       如果使用注解配置方法当中有参数，就会去容器中寻找该参数的bean对象
*       查找方式和@Autowired一样先类型匹配再名称匹配
* */
    @Bean(name="runner")
    @Scope("prototype")
//    创建runner对象
    public QueryRunner runner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

//    创建数据源对象
    @Bean(name = "dataSource")
    public DataSource dataSource(){
        try {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/account");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("yzy665128");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
    }
}
