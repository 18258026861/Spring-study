package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YZY
 * @date 2020/3/31 - 22:35
 */
//用这个类自动生成代理类
public class ProxyInvocationhandler implements InvocationHandler {
    //    被代理的接口
    private Object target;

    public void setRent(Object target) {
        this.target = target;
    }


    /*newProxyInstance方法的参数：
        classLoader:类加载器
            用于加载代理对象字节码。和被代理对象使用 相同的字节码，固定写法
    class[]：字节码数组
            用于让代理对象和被代理对象有相同的方法。固定写法
    InovocationHandler:用于提供增强的代码
            让我们写如何代理。通常情况下都是匿名内部类，但不是必须 */
    //得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

//    处理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log("YY");
//        动态代理的本质,就是使用反射机制实现
        Object result = method.invoke(target,args);
        return result;
    }
    public void log(String callname){
        System.out.println("调用了一次"+callname+"方法");
    }

}
