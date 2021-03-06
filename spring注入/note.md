##XML
xml前缀
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

```

---

###spring 对bean管理
- ####创建bean的三种方式
    - 创建方式一：
        - 使用默认构造函数
       spring的配置文件使用bean标签且只有id和class属性，没有其他属性和标签，
        - 如果没有默认构造函数，就不能创建
    
*      <bean id="accountService" class="service.impl.AccountServiceImpl"/>
    - 创建方法二：
        - 使用jar包中的方法创建对象（某个类中的方法创建对象），并存入spring容器
 *     <bean id="instanceFactory" class="com.gx.InstanceFactory"/>
       <bean id="accountService" factory-bean="instancefactory" factory-method="saveAccount"/>
      
    - 创建方法三：
        -  使用工厂中的静态方法创建对象（某个类中的静态方法），并存入spring容器
                  static不需要实例化没，所以可以直接合并成一句话
*      <bean id="staticFactory" class="com.gx.staticFactory" factory-method="saveAccount"></bean>

---

- ####bean对象的作用范围
   - bean的scope属性： 用于指定bean的作用范围
        - 取值：singleton：单例的（默认值）
            - prototype：多例的
            - request:作用web请求的请求范围
            - session:作用于web应用的会话范围
            - blobal-session;作用于全局会话（集群）范围，不是集群范围就是session
    
*        <bean id="accountService" class="service.impl.AccountServiceImpl" scope="prototype"/>

---

- ####bean对象的生命周期
    - 单例对象：单例对象的生命周期跟随容器
         - 出生:但容器创建时，对象就出生
         - 存活：容器活着对象就活着
         - 死亡：容器销毁，对象死亡
    - 多例对象：
         -  出生：当我们使用对象时spring框架为我们创建
         - 存活：单对象在使用中就存活
         - 死亡：单对象长时间不用，且没有别的对象应用，就被被垃圾回收
*        <bean id="accountService" class="service.impl.AccountServiceImpl" scope="prototype" init-method="init" destroy-method="destroy"/>

---

- ###spring依赖注入
    - 依赖注入DI：Dependency Injection:降低程序的耦合 
         - 能注入的数据由三种：
              - 基本类型和string
              - 其他bean类型（在配置文件中活着注解配置的bean）
              - 复杂类型、集合类型
         - 注入的方式三种：
              - 构造函数提供
              - 使用set方法
              - 使用注解
                

- 构造函数注入
   - ***construct-arg*** ：因为默认构造已经不见了，所以要使用标签：construct-arg
        - 标签中的属性：
            - type：指定要注入的数据类型
            - index：索引位置，指定要注入的数据，从0开始
            -（常用）name：给指定名称赋值
            - value:给基本类型和String类型数据
            - ref:给其他类型数据，在spring容器中出现过的
   - ***优势***：创建bean对象时，必须注入数据，否赵不能创建
   - ***劣势***：改变了bean实例化，当我们用不到某些数据也必须赋值
             所以除了非用不可之外，一般使用set方法

*       <bean id="accountService" class="service.impl.AccountServiceImpl">
        <constructor-arg name="name" value="YY"></constructor-arg>
        <constructor-arg name="age" value="18"></constructor-arg>
        <constructor-arg name="birthday" ref="date"></constructor-arg>
        </bean>
        <bean id="date" class="java.util.Date" ></bean> 
  
---

- set方法注入
     - 标签： property，出现在bean内部
          - 标签中的属性：
             - name：给指定名称赋值,这边的name不是变量名，而是set的名称
             - value:给基本类型和String类型数据
             - ref:给其他类型数据，在spring容器中出现过的类里没有默认构造函数不能使用
     - 优势；创建对象没有明确限制，可以直接使用默认构造方法
     - 弊端：没有set方法就不能注入

*       <bean id="accountService2" class="service.impl.AccountServiceImpl2">
        <property name="name" value="YY"/>
        <property name="age" value="18"/>
        <property name="birthday" ref="date"/>
        </bean>
        <bean id="date" class="java.util.Date" ></bean>        
        
---

- 复杂类型、集合类型的注入
   - 用于给List结构注入的标签：
        - list array set
   - 用于Map结构集合注入的标签：
        - map props
   - 结构相同，可以互换，所以只要记两组就行了
*       <bean id="accountService3" class="service.impl.AccountServiceImpl3">
             <property name="strings">
                 <array>
                     <value>YY</value>
                     <value>YZY</value>
                 </array>
             </property>
             <property name="set">
                 <set>
                     <value>YY</value>
                     <value>YZY</value>
                 </set>
             </property>
             <property name="map">
                 <map>
                     <entry key="A" value="B"></entry>
                 </map>
             </property>
             <property name="list">
                 <array>
                     <value>YY</value>
                     <value>YZY</value>
                 </array>
             </property>
             <property name="properties">
                 <props>
                     <prop key="A" >a</prop>
                     <prop key="B" >b</prop>
                 </props>
             </property>
         </bean>
         <bean id="person" class="entity.Person" autowire="byType">
     
         </bean>
         <bean id="dog" class="entity.Dog"/>
         <bean id="cat" class="entity.Cat"/>
