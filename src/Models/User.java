package Models;

/**
 * Created By Naseef M Abdus Sattar on 10/14/2017 at 4:23 PM
 */
public class User
{
    private String name;
    private String password;
    private long balance;

    public User(String name, String password, long balance)
    {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public long getBalance()
    {
        return balance;
    }

    public void setBalance(long balance)
    {
        this.balance = balance;
    }
}
