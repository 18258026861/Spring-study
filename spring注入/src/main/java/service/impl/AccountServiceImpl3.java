package service.impl;

import Dao.IAcountDao;
import service.IAccountService;

import java.util.*;

/**
 * @author YZY
 * @date 2020/3/28 - 20:41
 */
public class AccountServiceImpl3 implements IAccountService {
    //如果是经常变化的数据，并不适用于注入，比如账号密码就不合适
    private String[] strings;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;


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
        System.out.println(Arrays.toString(strings));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(properties);
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
