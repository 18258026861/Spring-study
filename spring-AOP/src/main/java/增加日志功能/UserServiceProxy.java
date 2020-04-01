package 增加日志功能;

/**
 * @author YZY
 * @date 2020/3/31 - 21:13
 */
public class UserServiceProxy implements UserService {

    private UserService userService;


//    在代理类里调用并加上日志
//    没有加一层封装解决不了的方法，如果有，就再加一层
    //    这就是只拓展不修改，不在改变原有代码的基础上增加新功能
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
