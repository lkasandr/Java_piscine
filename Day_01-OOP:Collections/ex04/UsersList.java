package ex04;

interface UsersList {
    void addUser(User user);
    User retriveUserId(Integer id);
    User retriveUserInd(Integer index);
    Integer retriveNumberOfUsers();
}
