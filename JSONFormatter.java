import java.util.*;
import java.util.Iterator;
import java.util.Set;
import java.io.*;

public class JSONFormatter extends GrammarBaseListener
{
    String nameLabel;
    String emailLabel;
    String phoneNumLabel;
    String addressLabel;
    String openSymbol;
    String closeSymbol;
    String leftBracket;
    String rightBracket;
    Hashtable<String, Customer> customers;
    

    public JSONFormatter()
    {
        this.nameLabel = "\"Name\": ";
        this.emailLabel = "\"Email\": ";
        this.phoneNumLabel = "\"Phone\": ";
        this.addressLabel = "\"Address\": ";
        this.openSymbol = "[";
        this.closeSymbol = "]";
        this.leftBracket = "{";
        this.rightBracket = "}";
        this.customers = new Hashtable<String, Customer>();
    }

    @Override public void enterFormat_Line(GrammarParser.Format_LineContext ctx) 
    { 
        //System.out.println("Entered format line.");
        
    }

    @Override public void exitFormat_Line(GrammarParser.Format_LineContext ctx) 
    { 
        //System.out.println("Exiting format Line");
    }

    @Override
    public void enterData_Line(GrammarParser.Data_LineContext ctx) 
    { 
        //System.out.println("Entered data line.");

        String name = ctx.NAME().getText();
        String email = ctx.EMAIL().getText();
        String phone = ctx.PHONENUM().getText();
        String address = ctx.ADDRESS().getText();

        Customer current = new Customer(name, email, phone, address);

        if(customers.get(email) == null)
        {
            customers.put(email, current);
        }

    }

    public void createFile()
    {
        try
        {
            File json = new File("CustomerDatabase.json");
            FileWriter writer = new FileWriter(json);
            PrintWriter toFile = new PrintWriter(writer);

            toFile.println(openSymbol);

            if (customers.size() != 0)
            {
                Set<String> keys = customers.keySet();
        
            Iterator<String> itr = keys.iterator();

            for(int i = 0; i < customers.size() - 1; i++)
            {
                String nextKey = itr.next();
                print(toFile, nextKey, false);
            }
            
            String nextKey = itr.next();
            print(toFile, nextKey, true);

            }
            

            /*
            Set<String> keys = customers.keySet();
        
            Iterator<String> itr = keys.iterator();

            for(int i = 0; i < customers.size() - 1; i++)
            {
                String nextKey = itr.next();
                print(toFile, nextKey, false);
            }
            
            String nextKey = itr.next();
            print(toFile, nextKey, true);
            */
           
            toFile.print(closeSymbol);
            toFile.close();
            

        } catch (IOException e)
        {
            System.out.println("There was an error creating the file for some reason.\nPlease check the input file and try again");
        }
        
    }

    public void print(PrintWriter toFile, String v, Boolean isLast)
    {
        toFile.println("\t" + leftBracket);
        toFile.println("\t\t" + nameLabel + "\"" + customers.get(v).getName() + "\",");
        toFile.println("\t\t" + emailLabel + "\"" + customers.get(v).getEmail() + "\",");
        toFile.println("\t\t" + phoneNumLabel + "\"" + customers.get(v).getPhone() + "\",");
        toFile.println("\t\t" + addressLabel + "\"" + customers.get(v).getAddress() + "\"");
        
        if(isLast)
        {
            toFile.println("\t" + "}");
        }
        else
        {
            toFile.println("\t" + "},");
        }
    }



}
