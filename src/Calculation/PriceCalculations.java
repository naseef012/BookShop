package Calculation;

import Data.DataService;
import Models.Book;
import Models.User;

import java.util.Map;

/**
 * Created By Naseef M Abdus Sattar on 10/16/2017 at 1:17 AM
 */
public class PriceCalculations
{
    private long balance;
    public boolean hasBalance(User user , Map<Integer,Long> bookList)
    {
        long cost = 0;
        for (Map.Entry m: bookList.entrySet())
        {
            cost = cost + (long) m.getValue();
        }
        balance = user.getBalance() - cost;
        if (balance !=0)
            return true;
        else
            return false;
    }

    public long getBalance ()
    {
        return balance;
    }
}
