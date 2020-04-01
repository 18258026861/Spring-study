package 增加日志功能;

/**
 * @author YZY
 * @date 2020/3/31 - 21:11
 */
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userService);
        userServiceProxy.add();
    }
}
