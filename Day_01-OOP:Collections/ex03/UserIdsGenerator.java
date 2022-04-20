package ex03;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private Integer id;

    UserIdsGenerator()
    {
        this.id = 0;
    }

    public static UserIdsGenerator getInstance()
    {
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }

    public Integer generateId()
    {
        this.id++;
        return this.id;
    }
}
