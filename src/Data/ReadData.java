package Data;

import Models.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 10/14/2017 at 4:29 PM
 */
public class ReadData
{
    /**
     This Method reads all the data from the Book.txt file line by line and stores them in an ArrayList
     line by line.

     @return ArrayList<String>
     */
    public List<String> readUserFile ()
    {
        try
        {
            List<String> lines = new ArrayList<>();
            String line = null;

            FileReader f = new FileReader("User.txt");
            BufferedReader bf = new BufferedReader(f);

            while ((line = bf.readLine())!=null)
            {
                lines.add(line);
            }

            bf.close();
            return lines;

        }
        catch (FileNotFoundException f)
        {
            System.out.println("File not found");
            f.printStackTrace();
            return null;
        }
        catch (IOException e)
        {

            System.out.println("Could not read file");
            e.printStackTrace();
            return null;
        }

    }

    /**
    This Method reads all the data from the Book.txt file line by line and stores them in an ArrayList
    line by line.

     @return ArrayList<String>
     */
    public List<String> readBookFile()
    {
        try
        {
            List<String> lines = new ArrayList<>();
            String line = null;

            FileReader f = new FileReader("Book.txt");
            BufferedReader br = new BufferedReader(f);

            while ((line = br.readLine())!=null)
            {
                lines.add(line);
            }

            br.close();
            return lines;
        }
        catch (FileNotFoundException f)
        {
            System.out.println("File not found");
            f.printStackTrace();
            return null;
        }
        catch (IOException e)
        {

            System.out.println("Could not read file");
            e.printStackTrace();
            return null;
        }
    }

}
