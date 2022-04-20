package ex04;

public class TransactionsService {
    private UsersArrayList users;

    TransactionsService()
    {
        this.users = new UsersArrayList();
    }

    public void addUser(User newUser)
    {
        this.users.addUser(newUser);
    }

    public Integer retrieveBalance(Integer userId)
    {
        User user = users.retriveUserId(userId);
        return user.getBalance();
    }

    public void transferTransaction(Integer idRecipient, Integer idSender, Integer amount) throws IllegalTransactionException
    {
        User recipient = users.retriveUserId(idRecipient);
        User sender = users.retriveUserId(idSender);

        if (amount <= 0 || sender.getBalance() < amount)
            throw new IllegalTransactionException();

        Transaction t1 = new Transaction(recipient, sender, "INCOME", amount);
        Transaction t2 = new Transaction(sender, recipient, "OUTCOME", amount, t1.getIdentifier());

        recipient.setTransactions(t1);
        sender.setTransactions(t2);
    }

    public Transaction[] retrieveTransfers(Integer userId)
    {
        User user = users.retriveUserId(userId);
        return (user.getTransactions().toArray());
    }

    public void removeTransaction(String transactionId, Integer userId)
    {
        User user = users.retriveUserId(userId);
        user.getTransactions().removeTransaction(transactionId);
    }

    public Transaction[] unpairedTransactions()
    {
        TransactionsLinkedList unpair = new TransactionsLinkedList();
        for(int i = 0; i < users.retriveNumberOfUsers(); ++i)
        {
            boolean valid = false;
            User user = users.retriveUserInd(i);
            for(Transaction t : user.getTransactions().toArray())
            {
                valid = false;
                for(Transaction t1 : t.getSender().getTransactions().toArray())
                {
                    if (t.getIdentifier().equals(t1.getIdentifier()))
                        valid = true;
                }
                if (valid == false)
                    unpair.addTransaction(t);
            }
        }
        return unpair.toArray();
    }
}
