package entity;

/**
 * @author YZY
 * @date 2020/3/29 - 20:29
 */
public class Account {

    private int id;
    private String name;
    private float money;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "AccountDaoImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

}