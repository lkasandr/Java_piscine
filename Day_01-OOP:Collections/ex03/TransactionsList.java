package ex03;

interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransaction(String uuid);
    Transaction[] toArray();
}
