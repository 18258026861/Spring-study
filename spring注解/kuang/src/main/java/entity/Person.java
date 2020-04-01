package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author YZY
 * @date 2020/3/31 - 11:09
 */
@Component
public class Person {
    /*使用这个注解就不用set方法了
    *   */
    /*=============注入数据的注解=======================
        相当于配置文件中的<bean>标签下的<property>标签
        使用注解注入时就可以不用set方法了
        @Autowired:自动按照类型注入只要容器中有唯一的bean对象类型和注入的类型匹配，就可以注入成功
             注意点：如果有多个类型匹配（第一匹配条件）时，就会报错：这时就要确定变量名（第二匹配条件）
            出现位置：可以是变量上，也可以是方法上

         @Qualifier：在按照类注入的基础上按变量名注入，在给类成员注入时不能单独使用，但是方法注入时可以
*           属性：     value 指定bean的id值

    ---------@Resource ：上面两个的集合体
                属性 ：name  指定bean的id值
        以上三个注入都只能注入其他bean类型的数据，基本类型无法使用，集合类型的只能在xml文件实现

        @Value：用于注入基本类型和string
            属性：value：用于指定数据的值
*/
    @Autowired
    @Qualifier(value="dog")
    private Dog dog;
    @Resource
    private Cat cat;
    private String name;


    public void shout(){
        dog.shou();
        cat.shout();
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }
}
