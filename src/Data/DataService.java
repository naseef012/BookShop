package Data;

import Models.Book;
import Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 10/14/2017 at 4:26 PM
 */
public class DataService
{
    private List<User> userList = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();

    public void addUser(User user)
    {
        userList.add(user);
    }

    public void addBook (Book book)
    {
        bookList.add(book);
    }



    public List<User> getUserList()
    {
        ReadData r = new ReadData();
        List<String> userFileOutput = r.readUserFile();
        for (String s: userFileOutput)
        {
            String tuple[] = s.split("\\s+");
            addUser(new User (tuple[0], tuple[1], Long.parseLong(tuple[2])));
        }
        return userList;
    }

    public List<Book> getBookList()
    {
        ReadData r = new ReadData();

        List<String> bookFileOutput = r.readBookFile();

        for (String s : bookFileOutput)
        {
            String indiviualStrings[] = s.split("\\s+");

            Book book = new Book();

            book.setId(Integer.parseInt(indiviualStrings[0]));
            book.setPrice(Long.parseLong(indiviualStrings[indiviualStrings.length-1]));

            String name = "";
            for (int i=1;i<indiviualStrings.length-1;i++)
            {
                name = indiviualStrings[i] +" "+name;
            }

            book.setName(name.trim());

            addBook(book);
        }
        return bookList;
    }

    public long getBookPrice(int id)
    {
        for (Book b: getBookList())
        {
            if (b.getId() == id)
                return b.getPrice();
        }
        return -1;
    }
}
