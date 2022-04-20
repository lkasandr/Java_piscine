package ex03;

public class Program {
    public static void main(String[] args)
    {
        User JeffBezos = new User("Jeff Bezos", 177);
        User IlonMask = new User("Ilon Mask", 151);
        User BernarArno = new User("Bernar Arno", 150);
        User BillGates = new User( "Bill Gates", 100);

        Transaction transaction1 = new Transaction(JeffBezos, IlonMask, 100);
        Transaction transaction2 = new Transaction(BernarArno, BillGates, 145);

        System.out.println("\u001B[32m" + "PRINT USER'S INFO:" + "\u001B[0m");
        JeffBezos.printUserInfo();
        IlonMask.printUserInfo();
        BernarArno.printUserInfo();
        BillGates.printUserInfo();

        JeffBezos.setTransactions(transaction1);
        IlonMask.setTransactions(transaction1);
        BernarArno.setTransactions(transaction2);
        BillGates.setTransactions(transaction2);

        System.out.println("\u001B[32m" + "PRINT JeffBezos's TRANSACTION:" + "\u001B[0m");
        for(Transaction trans : JeffBezos.getTransactions().toArray()) {
            trans.printTransactionInfo(trans);
        }

        Transaction transaction3 = new Transaction(IlonMask, BillGates, 100);
        Transaction transaction4 = new Transaction(JeffBezos, BernarArno, 145);

        TransactionsLinkedList allTransactions = new TransactionsLinkedList();
        allTransactions.addTransaction(transaction1);
        allTransactions.addTransaction(transaction2);
        allTransactions.addTransaction(transaction3);
        allTransactions.addTransaction(transaction4);
        System.out.println("\u001B[32m" + "PRINT ALL TRANSACTION:" + "\u001B[0m");
        for(Transaction trans : allTransactions.toArray()) {
            trans.printTransactionInfo(trans);
        }

        System.out.println("\u001B[32m" + "TEST REMOVE TRANSACTION:" + "\u001B[0m");
        allTransactions.removeTransaction(transaction1.getIdentifier());
        for(Transaction trans : allTransactions.toArray()) {
            trans.printTransactionInfo(trans);
        }
    }
}
