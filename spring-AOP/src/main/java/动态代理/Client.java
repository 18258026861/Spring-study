package 动态代理;

import 增加日志功能.UserService;
import 增加日志功能.UserServiceImpl;

/**
 * @author YZY
 * @date 2020/3/31 - 20:33
 */
public class Client {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        House house = new House();
//        看中了某个房子
//        House house = new House("无名公寓");

//        动态生成代理对象
        ProxyInvocationhandler proxyInvocationHandler = new ProxyInvocationhandler();

//        代理了上面参数里这个这个真实角色
        proxyInvocationHandler.setRent(userService);

        UserService proxy1  = (UserService) proxyInvocationHandler.getProxy();
//        调用代理类的方法
        proxy1.update();
//        Rent11 proxy = (Rent11) proxyInvocationHandler.getProxy();
//        proxy.rent();





    }

}
