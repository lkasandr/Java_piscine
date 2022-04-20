package ex04;

public class Program {
    public static void main(String[] args)
    {
        User JeffBezos = new User("Jeff Bezos", 177);
        User IlonMask = new User("Ilon Mask", 151);
        User BernarArno = new User("Bernar Arno", 150);
        User BillGates = new User( "Bill Gates", 100);
        System.out.println("\u001B[32m" + "PRINT USER'S INFO:" + "\u001B[0m");
        JeffBezos.printUserInfo();
        IlonMask.printUserInfo();
        BernarArno.printUserInfo();
        BillGates.printUserInfo();
        TransactionsService service = new TransactionsService();
        service.addUser(JeffBezos);
        service.addUser(IlonMask);
        service.addUser(BernarArno);
        service.addUser(BillGates);
        service.transferTransaction(2, 1, 100);
        service.transferTransaction(1, 3, 50);
        System.out.println("\u001B[32m" + "TEST TRANSFER TRANSACTION:" + "\u001B[0m");
        for(Transaction t : service.retrieveTransfers(1))
            t.printTransactionInfo(t);
        for(Transaction t : service.retrieveTransfers(2))
            t.printTransactionInfo(t);
        for(Transaction t : service.retrieveTransfers(3))
            t.printTransactionInfo(t);
        System.out.println("\u001B[32m" + "TEST REMOVE TRANSACTION:" + "\u001B[0m");
        Transaction[] t = service.retrieveTransfers(1);
        service.removeTransaction(t[0].getIdentifier(), 1);
        for(Transaction t1 : service.retrieveTransfers(1))
            t1.printTransactionInfo(t1);
        System.out.println("\u001B[32m" + "TEST UNPAIR TRANSACTION:" + "\u001B[0m");
        for(Transaction t2 : service.unpairedTransactions())
            t2.printTransactionInfo(t2);
    }
}
