##注解
注解前缀
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">
</beans>
```

注解的***第一种方式***：不用@Component,直接类在xml里手动注入

```xml
<!--支持注解模式-->
    <context:annotation-config></context:annotation-config>
    <!--使用@Autowired注解就不用写property标签属性了，也可以在bean后面加autowired属性-->
    <bean id="person" class="entity.Person"></bean>
    <bean id="dog" class="entity.Dog"/>
    <bean id="cat" class="entity.Cat"/>
```

注解的***第二种方式***：使用@Component，等价于<bean id=""class=""/>
  -  @Controller：一般用在表现层
  -  @Service：业务层
   - @Repository：持久层

```xml
<!--指定要扫描的包，包下的注解会生效，其实这条写了，支持注解模式那条就已经包含进去了-->
    <context:component-scan base-package="entity"></context:component-scan>
```

```java
    @Autowired
    @Qualifier(value = "accountDao2")
    //这哥们一个顶上面俩
    @Resource(name = "accountDao1")
    private Dog dog;
```

- 注入数据的注解
          相当于配置文件中的<bean>标签下的<property>标签
          使用注解注入时就可以不用set方法了
  - ***@Autowired***:
        自动按照类型注入只要容器中有唯一的bean对象类型和注入的类型匹配，就可以注入成功
    - 注意点 用于匹配指定类型，但是我拥有两个相同的类所以就会无法匹配到确定的一个类上，这时候就匹配与变量名相同的bean，如果都不对就报错，这时候
                加上@Qualifier指定变量名
  
  - ***@Qualifier***：
        在按照类注入的基础上按变量名注入，在给类成员注入时不能单独使用，但是方法注入时可以
             属性：value 
                    指定bean的id值
  
  - ***@Resource*** ：上面两个的集合体
      - 属性 ：name  
            指定bean的id值
            
- 以上三个注入都只能注入其他bean类型的数据，基本类型无法使用，集合类型的只能在xml文件实现
  - ***@Value***：用于注入基本类型和string
      - 属性：value
                用于指定数据的值
    *            @Value(value="lanmao") 相当于<property id="cat" value="lanmao">
                     private Cat cat;
##注解作用范围
相当于配置文件中的<bean>标签中的scope属性
- @Scope ：指定bean的作用范围
    - 属性：value 指定范围的取值 这个和配置文件中一样
*                       @Scope(value = "prototype")
 
##注解生命周期（了解）
 - 相当于配置文件中的<bean>标签中的init-method和destroy-method属性
- @PostConstruct:创建方法
   *            @PostConstruct： 创建方法
                public void init(){
                System.out.println("对象出生");}  
    

      
- @PreDestroy :销毁方法
    *           public void destroy(){
                System.out.println("对象死亡");
                }


#小结  xml和注解
