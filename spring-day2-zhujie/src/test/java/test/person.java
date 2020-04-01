package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YZY
 * @date 2020/3/31 - 11:32
 */
public class person<Person> {


    @Test
    public void personTest(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
       Person person = (Person) applicationContext.getBean("person");


    }
}
