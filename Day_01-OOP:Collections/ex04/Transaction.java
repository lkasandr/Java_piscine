package ex04;

import java.util.UUID;

public class Transaction {

    enum TransferCategory
    {
        OUTCOME,
        INCOME
    }

    private String Identifier;
    private User Recipient;
    private User Sender;
    private TransferCategory category;
    private Integer amount;

    Transaction(User recipient, User sender, String category, Integer amount)
    {
        if (category.equals("OUTCOME"))
        {
            this.category = TransferCategory.OUTCOME;
            this.Sender = recipient;
            this.Recipient = sender;
        }
        else if (category.equals("INCOME"))
        {
            this.category = TransferCategory.INCOME;
            this.Recipient = recipient;
            this.Sender = sender;
        }
        else
            throw new IllegalTransactionException();
        this.amount = amount;
        setUUID();
        Recipient.setBalance(recipient.getBalance() + amount);
        Sender.setBalance(sender.getBalance() - amount);
    }

    Transaction(User recipient, User sender, String category, Integer amount, String uuid)
    {
//        this.category = category;
        if (category.equals("OUTCOME"))
            this.category = TransferCategory.OUTCOME;
        else
            this.category = TransferCategory.INCOME;
        this.Recipient = recipient;
        this.Sender = sender;
        this.amount = amount;
        this.Identifier = uuid;
    }

    public void printTransactionInfo(Transaction t)
    {
        System.out.print(t.Recipient.getName() + "->" + t.Sender.getName());
        System.out.println(", " + t.amount + " " + t.category + " " + t.Identifier);
    }

    public void setUUID()
    {
        this.Identifier = UUID.randomUUID().toString();
    }

    public String getIdentifier()
    {
        return this.Identifier;
    }

    public User getSender()
    {
        return this.Sender;
    }
}
