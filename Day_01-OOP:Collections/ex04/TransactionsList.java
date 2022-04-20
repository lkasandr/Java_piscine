package ex04;

interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransaction(String uuid);
    Transaction[] toArray();
}
