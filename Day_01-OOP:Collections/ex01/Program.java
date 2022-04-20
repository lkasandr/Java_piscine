package ex01;

public class Program {
    public static void main(String[] args)
    {
        User JeffBezos = new User("Jeff Bezos", 177);
        User IlonMask = new User("Ilon Mask", 151);
        User BernarArno = new User("BernarArno", 150);
        User BillGates = new User( "BillGates", -100);

        System.out.println(BillGates.getBalance());
        BillGates.setBalance(145);
        System.out.println(BillGates.getBalance());

        JeffBezos.printUserInfo();
        IlonMask.printUserInfo();
        BernarArno.printUserInfo();
        BillGates.printUserInfo();
    }
}
