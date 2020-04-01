package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author YZY
 * @date 2020/3/30 - 15:24
 */
//@Configuration
    //如果不加该注解，即使你指定了该包所在的类，spring也不会扫描该类，
    // 要么在创建容器中加该类参数，要么使用@import导入该类
public class jdbcConfiguration {

    @Value("${jdbc.driver}")
    String driver;

    @Value("${jdbc.url}")
    String url;

    @Value("${jdbc.user}")
    String user;

    @Value("${jdbc.password}")
    String password;

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
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(user);
            comboPooledDataSource.setPassword(password);
            return comboPooledDataSource;
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
    }
}
