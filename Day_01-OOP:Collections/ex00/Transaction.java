package ex00;

import java.util.UUID;

public class Transaction {

    enum TransferCategory
    {
        CREDIT,
        DEBIT
    }

    private String Identifier;
    private User Recipient;
    private User Sender;
    private TransferCategory category;
    private Integer amount;

    Transaction(User recipient, User sender, Integer amount)
    {
        setRecipient(recipient);
        setSender(sender);
        setAmount(amount);
        setUUID();
        setCategory(amount);
        recipient.setBalance(recipient.getBalance() + amount);
        sender.setBalance(sender.getBalance() - amount);
    }

    public void printTransactionInfo()
    {
        if (this.amount < 0) {
            System.out.print(this.Sender.getName() + "->" + this.Recipient.getName());
            System.out.println(", " + this.amount + ", OUTCOME, " + this.Identifier);
        }
        else
        {
            System.out.print(this.Recipient.getName() + "->" + this.Sender.getName());
            System.out.println(", " + this.amount + ", INCOME, " + this.Identifier);
        }
    }

    public void setUUID()
    {
        this.Identifier = UUID.randomUUID().toString();
    }

    public void setRecipient(User user)
    {
        this.Recipient = user;
    }

    public void setSender(User user)
    {
        this.Sender = user;
    }

    public void setCategory(Integer amount)
    {
        if (amount >= 0)
            this.category = TransferCategory.DEBIT;
        else
            this.category = TransferCategory.CREDIT;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }
}
