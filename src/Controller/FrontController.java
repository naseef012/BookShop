package Controller;

import Calculation.PriceCalculations;
import Data.DataService;
import Data.ReadData;
import Models.Book;
import Models.User;
import View.ViewData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created By Naseef M Abdus Sattar on 10/14/2017 at 4:47 PM
 */
public class FrontController
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String UserEnteredData="";
        User loggedInUser = null;

        Map<Integer , Long> userBookList = new HashMap<>();

        for (int i = 0;i<3;i++)
        {
            System.out.println("Enter Your User Name: ");
            String userName = s.nextLine();

            System.out.println("Enter Your Password: ");
            String password = s.nextLine();

            DataService ds = new DataService();

            for (User user: ds.getUserList())
            {
                if (user.getName().equals(userName) && user.getPassword().equals(password))
                {
                    System.out.println("Log in Successful!");
                    loggedInUser = user;
                    break;
                }
            }
            if (loggedInUser!=null)
                break;
            else
                System.out.println("Wrong Credentials! You have "+(2-i)+" chances left");

        }

        /**
         *
         */

        while (true)
        {
            System.out.println("Enter B/b to see Book List or Q/q to log out! ");
            UserEnteredData = s.nextLine();
            if (UserEnteredData.equals("q") || UserEnteredData.equals("Q"))
                break;
            else
            {
                ViewData v = new ViewData();
                v.showBookList();

                System.out.println("Enter S/s to select for to buy or Q/q to log out! ");
                UserEnteredData=s.nextLine();

                if (UserEnteredData.equals("Q") || UserEnteredData.equals("q"))
                    break;
                else if (UserEnteredData.equals("S") || UserEnteredData.equals("s"))
                {
                    System.out.println("Enter the Number of the book to buy or press Q/q to log out!");
                    UserEnteredData = s.nextLine();
                    if (UserEnteredData.equals("Q") || UserEnteredData.equals("q"))
                        break;
                    else
                    {
                        DataService ds = new DataService();

                        int bookId = Integer.parseInt(UserEnteredData);
                        long bookPrice = ds.getBookPrice(bookId);

                        if (bookPrice!=-1)
                        {
                            userBookList.put(bookId,bookPrice);
                        }
                        else
                        {
                            System.out.println("Book Not Found!");
                        }
                    }
                }
                else
                {
                    System.out.println("Sorry You Pressed the Wrong Key!");
                }
            }
        }
        PriceCalculations pc = new PriceCalculations();

        if (pc.hasBalance(loggedInUser , userBookList))
        {
            System.out.println("Your Current Balance after purchase is: " + pc.getBalance());
        }
        else
        {
            System.out.println("Sorry You do not have enough balance!");
        }
        System.out.println(" ");
        System.out.println("Thank You!");

    }
}
