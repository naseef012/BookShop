package View;

import Data.DataService;
import Models.Book;

import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 10/16/2017 at 12:59 AM
 */
public class ViewData
{
   public void showBookList()
   {
       DataService ds = new DataService();
       List<Book> li = ds.getBookList();
       for (Book u : li)
       {
           System.out.println(u.getId() + " " + u.getName() + " " + u.getPrice());
       }
   }
}
