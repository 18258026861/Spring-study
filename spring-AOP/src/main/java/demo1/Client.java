package demo1;

/**
 * @author YZY
 * @date 2020/3/31 - 20:33
 */
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
