package service.impl;

import Dao.IAcountDao;
import service.IAccountService;

import java.util.Date;

/**
 * @author YZY
 * @date 2020/3/28 - 20:41
 */
public class AccountServiceImpl implements IAccountService {
    //如果是经常变化的数据，并不适用于注入，比如账号密码就不合适
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,int age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    private IAcountDao acountDao ;
    @Override
    public void saveAccount() {
        acountDao.saveAccount();
    }public void init(){
        System.out.println("对象出生");
    }public void destroy(){
        System.out.println("对象死亡");
    }

    @Override
    public void showAccout() {
        System.out.println(name+age+birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
