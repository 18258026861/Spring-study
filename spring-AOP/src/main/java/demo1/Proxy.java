package demo1;

/**
 * @author YZY
 * @date 2020/3/31 - 20:34
 */
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
