package ex02;

public class Program {
    public static void main(String[] args) {
        User JeffBezos = new User("Jeff Bezos", 177);
        User IlonMask = new User("Ilon Mask", 151);
        User BernarArno = new User("BernarArno", 150);
        User BillGates = new User( "BillGates", -100);

        System.out.println("\u001B[32m" + "PRINT USER'S INFO:" + "\u001B[0m");
        JeffBezos.printUserInfo();
        IlonMask.printUserInfo();
        BernarArno.printUserInfo();
        BillGates.printUserInfo();

        UsersArrayList users = new UsersArrayList();
        users.addUser(JeffBezos);
        users.addUser(IlonMask);
        users.addUser(BernarArno);
        users.addUser(BillGates);
        System.out.println("\u001B[32m" + "users was successfully added" + "\u001B[0m");

        System.out.println("\u001B[32m" + "retrieve User ID:" + "\u001B[0m");
        users.retriveUserId(JeffBezos.getIdentifier()).printUserInfo();

        System.out.println("\u001B[32m" + "retrieve User index:" + "\u001B[0m");
        users.retriveUserInd(0).printUserInfo();

        System.out.println("\u001B[32m" + "retrieve Number of users:" + "\u001B[0m");
        System.out.println(users.retriveNumberOfUsers());
    }
}
