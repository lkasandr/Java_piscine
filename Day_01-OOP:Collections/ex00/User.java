package ex00;

public class User
{
    private Integer Identifier;
    private String Name;
    private Integer Balance;

    User(Integer id, String name, Integer balance)
    {
        setIdentifier(id);
        setName(name);
        setBalance(balance);
    }

    public void printUserInfo()
    {
        System.out.println("id: " + getIdentifier() + " name: " + getName() + " balance: " + getBalance());
    }

    public Integer getIdentifier()
    {
        return this.Identifier;
    }

    public String getName()
    {
        return this.Name;
    }

    public Integer getBalance()
    {
        return this.Balance;
    }

    public void setIdentifier(Integer id){
        this.Identifier = id;
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
