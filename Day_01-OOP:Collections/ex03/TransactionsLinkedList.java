package ex03;

public class TransactionsLinkedList implements TransactionsList{
    public class Node {
        private Node previousTransaction;
        private Transaction currentTransaction;
        private Node nextTransaction;

        Node(Node prev, Transaction transaction, Node next)
        {
            this.previousTransaction = prev;
            this.currentTransaction = transaction;
            this.nextTransaction = next;
        }
    }

    private Node head;
    private Node last;
    private Integer size;

    TransactionsLinkedList()
    {
        this.size = 0;
    }

    public void addTransaction(Transaction transaction) {
        Node temp = this.last;
        Node newNode = new Node(temp, transaction, null);
        this.last = newNode;
        if (this.head == null)
            this.head = newNode;
        else
            temp.nextTransaction = newNode;
        this.size++;
    };

    public void removeTransaction(String uuid) {
        Node tempNode = findTransaction(uuid);
        Transaction temp = tempNode.currentTransaction;
        Node prev = tempNode.previousTransaction;
        Node next = tempNode.nextTransaction;
        if(prev == null)
            this.head = next;
        else
        {
            prev.nextTransaction = next;
            tempNode.previousTransaction = null;
        }
        if(next == null)
            this.last = prev;
        else
        {
            next.previousTransaction = prev;
            tempNode.nextTransaction = null;
        }
        tempNode.currentTransaction = null;
        this.size--;
    };

    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[this.size];
        Node node = this.head;
        if (node == null)
            return transactions;
        for(int i = 0; i < this.size; ++i)
        {
            transactions[i] = node.currentTransaction;
            node = node.nextTransaction;
        }
        return transactions;
    };

    private Node findTransaction(String uuid) throws TransactionNotFoundException
    {
        Node temp = this.head;
        while(temp.nextTransaction != null)
        {
            if (temp.currentTransaction.getIdentifier().equals(uuid))
                return temp;
            temp = temp.nextTransaction;
        }
        throw new TransactionNotFoundException("Not found transaction");
    }
}
