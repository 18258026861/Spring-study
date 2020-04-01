package 增加日志功能;

/**
 * @author YZY
 * @date 2020/3/31 - 21:09
 */
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
