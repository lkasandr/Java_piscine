package ex00;

public class Program {
    public static void main(String[] args)
    {
        User JeffBezos = new User(1, "Jeff Bezos", 177);
        User IlonMask = new User(2, "Ilon Mask", 151);
        User BernarArno = new User(3, "BernarArno", 150);
        User BillGates = new User(4, "BillGates", -100);

        System.out.println(BillGates.getBalance());
        BillGates.setBalance(145);
        System.out.println(BillGates.getBalance());

        JeffBezos.printUserInfo();
        IlonMask.printUserInfo();
        BernarArno.printUserInfo();
        BillGates.printUserInfo();

        Transaction transaction1 = new Transaction(JeffBezos, IlonMask, 100);
        Transaction transaction2 = new Transaction(BernarArno, BillGates, 145);

        transaction1.printTransactionInfo();
        transaction2.printTransactionInfo();

        JeffBezos.printUserInfo();
        IlonMask.printUserInfo();
        BernarArno.printUserInfo();
        BillGates.printUserInfo();
    }
}
