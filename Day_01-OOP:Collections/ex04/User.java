package ex04;

public class User {
    private Integer id;
    private String Name;
    private Integer Balance;
    private TransactionsLinkedList transactions;

    User(String name, Integer balance)
    {
        this.id = UserIdsGenerator.getInstance().generateId();
        setName(name);
        setBalance(balance);
        transactions = new TransactionsLinkedList();
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
            this.Balance = balance;
    }

    public TransactionsLinkedList getTransactions()
    {
        return this.transactions;
    }

    public void setTransactions(Transaction transaction)
    {
        this.transactions.addTransaction(transaction);
    }
}
