package 动态代理;
/**
 * @author YZY
 * @date 2020/3/31 - 20:31
 */
//房东要租出去的房子
public class House implements Rent11 {


    public House(){

    }

    public void rent(){
        System.out.println("房东要出租房子");
    }
}
