package ex02;

public class UsersArrayList implements UsersList{
    private User[] users = new User[10];
    private Integer sizeArray = 10;
    private Integer index = 0;

    public void addUser(User user) throws NullPointerException
    {
        if (user == null)
            throw new NullPointerException();
        if (this.index.equals(sizeArray))
        {
            this.users = getNewArray(this.users);
            this.sizeArray *= 2;
        }
        this.users[index] = user;
        this.index++;
    };

    public User retriveUserId(Integer id) throws UserNotFoundException
   {
        for(int i = 0; i < this.sizeArray; ++i)
        {
            if (this.users[i].getIdentifier().equals(id))
                return this.users[i];
        }
        throw new UserNotFoundException("User not found");
    };

    public User retriveUserInd(Integer index) throws ArrayIndexOutOfBoundsException, UserNotFoundException
    {
        if (index < 0 || index >= sizeArray)
            throw new ArrayIndexOutOfBoundsException();
        if (users[index] == null)
            throw new UserNotFoundException("User not found");
        return users[index];

    };
    public Integer retriveNumberOfUsers()
    {
        return (this.index);
    };

    private User[] getNewArray(User[] users)
    {
        User[] temp = new User[this.sizeArray * 2];
        for(int i = 0; i < this.sizeArray; ++i)
        {
            temp[i] = users[i];
        }
        return temp;
    }
}
