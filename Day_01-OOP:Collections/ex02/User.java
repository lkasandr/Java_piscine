package ex02;

public class User {
    private Integer id;
    private String Name;
    private Integer Balance;

    User(String name, Integer balance)
    {
        this.id = UserIdsGenerator.getInstance().generateId();
        setName(name);
        setBalance(balance);
    }

    public void printUserInfo()
    {
        System.out.println("id: " + getIdentifier() + " name: " + getName() + " balance: " + getBalance());
    }

    public Integer getIdentifier()
    {
        return this.id;
    }

    public String getName()
    {
        return this.Name;
    }

    public Integer getBalance()
    {
        return this.Balance;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setBalance(Integer balance){
        if (balance < 0)
            this.Balance = 0;
        else
            this.Balance = balance;
    }
}
