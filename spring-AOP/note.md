#AOP
##10. 代理模式
为什么要学习代理模式，因为这是SpringAOP的底层<br>
是二十三种设计模式之一，***springAOC和springMVC必考***
- 代理模式的分类   
    - 静态代理
    - 动态代理
    
    ---
    
##10.1 静态代理
角色分析
   - 抽象角色：一般使用接口或者抽象类来解决
   - 真实角色：被代理的角色
   - 代理角色：代理真实角色，并做一些附属操作
   - 客户：访问代理角色的人
   
步骤：
1. 接口（租房操作）
```java
//租房接口
public interface Rent {
    
    public void rent();
    
}
```

2. 真实角色（房东）

```java
//房东要租出去的房子
public class House implements Rent {
    String housName;

    public String getHousName() {
        return housName;
    }

    public House(String housName){
       this.housName = housName;
    }

    public void rent(){
        System.out.println("房东要出租房子"+housName);
    }
}
```

3. 代理角色（中介）
```java
//代理
public class Proxy implements Rent{

    private House house;

    public Proxy(){

    }
    //代理去帮你租这个房子
    public Proxy(House house){
        this.house = house;
    }
//    房子被代理租出去了
    @Override
    public void rent(){
        house.rent();
        seeHouse(house.getHousName());
        money(house.housName);
        fire(house.getHousName());
    }
    public void seeHouse(String housName){
        System.out.println("中介带你看房"+ housName);
    }
    public void money(String housName){
        System.out.println("中介收费"+ housName);
    }
    public void fire(String housName){
        System.out.println("签合同"+ housName);
    }


}
```
4. 客户端访问代理角色（租客） 
```java
public class Client {
    public static void main(String[] args) {
//        看中了某个房子
        House house = new House("无名公寓");
//        找中介
        Proxy proxy = new Proxy(house);
//        中介的附属操作，不用和房东接触
        proxy.rent();

    }

}
```
  
####好处：
- 使真实角色（租客，房东）更加操作纯粹，不用关注公共业务（看房，签合同）
- 公共业务交给了代理（中介），实现了业务的分工（签合同，看房）
- 公共业务发生拓展的时候，方便管理
####缺点
- 一个真实角色就要一个代理，代码量翻倍，开发效率低

##10.2 加深理解
有一个service类用于使用增删改查的操作
```java
public class UserServiceImpl implements UserService{

    //        如果我还想再方法里加语句就很麻烦，不方便去改源代码，那么这个时候就要用代理类

    @Override
    public void add() {
        System.out.println("增");
    }

    @Override
    public void delete() {
        System.out.println("删");
    }

    @Override
    public void update() {
        System.out.println("改");
    }

    @Override
    public void query() {
        System.out.println("查");
    }
}
```
现在我想加一个日志功能,能不能在service类里直接修改呢？

最好不要，因为直接修改源代码可能会出错，而且如果代码量多的话十分麻烦，那么我们可以通过一个代理类来增加功能。
```java
public class UserServiceProxy implements UserService {
    private UserService userService;
//    在代理类里调用并加上日志
public void setUserService(UserService userService) {
    this.userService = userService;
}
    public void log(String callname){
        System.out.println("调用了一次"+callname+"方法");
    }
    @Override
    public void add() {
        userService.add();
        log("add");
    }
    @Override
    public void delete() {
        userService.delete();
        log("delete");
    }
    @Override
    public void update() {
        userService.update();
        log("update");
    }
    @Override
    public void query() {
        userService.query();
        log("query");
    }
}
```
这就是只拓展不修改，不在改变原有代码的基础上增加新功能

没有加一层封装解决不了的方法，如果有，就再加一层。

---

##10.3 动态代理
- 动态代理和静态代理角色是一样的
- 动态代理是动态生成的，不是我们直接写好的
- 分为两大类
    - 基于接口理：基于JDK动态代理（我们学习的）
    - 基于类：cglik
    
需要了解两个类：
- Proxy：代理
    - 提供静态方法方法能创建***动态代理***和实例
- invocationHandler：调用处理程序
    - 每一个代理类都会有一个调用处理程序，当代理类调用该方法，代理类分配到invoke方法通过反射反射

invocationHandler:

Proxy：提供
