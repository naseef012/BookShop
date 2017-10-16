package Models;

/**
 * Created By Naseef M Abdus Sattar on 10/14/2017 at 4:23 PM
 */
public class Book
{
    private int id;
    private String name;
    private long price;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }
}
