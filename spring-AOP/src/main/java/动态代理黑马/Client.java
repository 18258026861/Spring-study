package 动态代理黑马;

import 增加日志功能.UserService;
import 增加日志功能.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YZY
 * @date 2020/3/31 - 20:33
 */
public class Client {
    public static void main(String[] args) {

        final UserService userService = new UserServiceImpl();
        House house = new House();


         /*newProxyInstance方法的参数：
        classLoader:类加载器
            用于加载代理对象字节码。和被代理对象使用 相同的字节码，固定写法
    class[]：字节码数组
            用于让代理对象和被代理对象有相同的方法。固定写法
    InovocationHandler:用于提供增强的代码
            让我们写如何代理。通常情况下都是匿名内部类，但不是必须 */
       UserService userServiceproxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                                  /*proxy：当前代理对象的引用
                                    method:当前执行的方法
                                    args：执行方法需要的参数
                                  * */

//                                  这里就相当于代理类得到了真实角色的方法，可以再里面加功能，最后在main方法里调用你想要的代理类.方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                          增强功能

                            System.out.println("调用一次"+method.getName()+"方法");


//                        返回被代理对象的方法
                        return method.invoke(userService,args);
                    }
                });
//
       userServiceproxy.add();






    }

}
