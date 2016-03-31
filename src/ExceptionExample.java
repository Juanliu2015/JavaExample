import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;

/**
 * Some of these exceptions are caused by user error, 
 * others by programmer error, 
 * and others by physical resources that have failed in some manner.
 * 
 *JVM Exceptions: These are exceptions/errors that are exclusively or logically thrown by the JVM. 
 *Examples : NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException,
 *
 *Programmatic Exceptions:These exceptions are thrown explicitly by the application or the API programmers 
 *Examples: IllegalArgumentException, IllegalStateException.
 */
public class ExceptionExample {

	public ExceptionExample() {
		// TODO Auto-generated constructor stub
	}
/**
 * Checked exceptions: A checked exception is an exception that occurs at the compile time, 
 * these are also called as compile time exceptions. These exceptions cannot simply be ignored at the time of compilation, 
 * the Programmer should take care of (handle) these exceptions.
 * 
 * Unchecked exceptions:An Unchecked exception is an exception that occurs at the time of execution, 
 * these are also called as Runtime Exceptions, these include programming bugs, 
 * such as logic errors or improper use of an API. runtime exceptions are ignored at the time of compilation.
 * 
 * Errors: These are not exceptions at all, but problems that arise beyond the control of the user or the programmer. 
 * Errors are typically ignored in your code because you can rarely do anything about an error.
 * For example, if a stack overflow occurs, an error will arise. They are also ignored at the time of compilation.
 * @param args
 * @throws FileNotFoundException
 */
	public static void main(String[] args) throws FileNotFoundException { 
		
		// checked exception
		//File file = new File("/file.txt");
		//FileReader fr = new FileReader(file); //if you use FileReader class in your program to read data from a file, if the file specified in its constructor doesn't exist, then an FileNotFoundException occurs,
		
		CheckingAccount c = new CheckingAccount(001);
		System.out.println("Depositing $500...");
	    c.deposit(500.00);
	    
	    try
	      {
	         System.out.println("\nWithdrawing $100...");
	         c.withdraw(100.00);
	         System.out.println("\nWithdrawing $600...");
	         c.withdraw(600.00);
	      }catch(InsufficientFundsException e)
	      {
	         System.out.println("Sorry, but you are short $" + e.getAmount());
	         e.printStackTrace();
	      }
	    }
		
	/*	int[] num = null;
		try{
			num = new int[]{1,2,3,4,5};
			System.out.println(num[5]);//ArrayIndexOutOfBoundsException:unchecked exception
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Exception thrown:"+e);
		}finally{
			num[0] = 6;
			System.out.println("First element value: " +num[0]);
			System.out.println("The finally statement is executed");
			
		}
		
		*/
		
/*		
		try
		{
		   FileInputStream file = new FileInputStream("/file.txt");
		   byte x = (byte) file.read();
		}catch(IOException i)
		{
		   i.printStackTrace();
		   
		}catch(FileNotFoundException f) //Not valid!
		{
		   f.printStackTrace();
		   
		}
*/
		
	/*	try
		{
		   //Protected code
		}catch(ExceptionType1 e1)
		{
		   //Catch block
		}catch(ExceptionType2 e2)
		{
		   //Catch block
		}catch(ExceptionType3 e3)
		{
		   //Catch block
		}finally
		{
		   //The finally block always executes.
		}*/
		
		
		
	}
	
/*	public void deposit(double amount) throws RemoteException, InsufficientFundsException
	   {
	      // Method implementation
	      throw new RemoteException();
	   }
	
*/


 class ReadData_Demo {

	   public static void main(String args[]){
	      FileReader fr=null;		
	      try{
	         File file=new File("file.txt");
	         fr = new FileReader(file);  char [] a = new char[50];
	         fr.read(a); // reads the content to the array
	         for(char c : a)
	         System.out.print(c); //prints the characters one by one
	      }catch(IOException e){
	          e.printStackTrace();
	       }
	       finally{	
	          try{
	              fr.close();
	          }catch(IOException ex){		
	               ex.printStackTrace();
	           }
	       }
	    }

	}
 
 /**
  * try with resources To use this statement,
  * To use this statement you simply need to declare the required resources within the parenthesis, 
  * the created resource will be closed automatically at the end of the block, 
  * below given is the syntax of try-with-resources statement
  * @author juan
  *
  */
 //you simply need to declare the required resources within the parenthesis, the created resource will be closed automatically at the end of the block, below given is the syntax of try-with-resources statement
class Try_withDemo {

	   public static void main(String args[]){
	      		
	      try(FileReader fr=new FileReader("E://file.txt")){
	         char [] a = new char[50];
	         fr.read(a); // reads the contentto the array
	         for(char c : a)
	         System.out.print(c); //prints the characters one by one
	      }catch(IOException e){
	          e.printStackTrace();
	       }   
	   }
	}

class CheckingAccount
{
   private double balance;
   private int number;
   
   public CheckingAccount(int number)
   {
      this.number = number;
   }
   
   public void deposit(double amount)
   {
      balance += amount;
   }
   
   public void withdraw(double amount) throws InsufficientFundsException
   {
      if(amount <= balance)
      {
         balance -= amount;
      }
      else
      {
         double needs = amount - balance;
         throw new InsufficientFundsException(needs);
      }
   }
   
   public double getBalance()
   {
      return balance;
   }
   
   public int getNumber()
   {
      return number;
   }
}

//define your own checked exception, if runtime exception, extends RuntimeException class
class InsufficientFundsException extends Exception
{
   private double amount;
   public InsufficientFundsException(double amount)
   {
      this.amount = amount;
   } 
   public double getAmount()
   {
      return amount;
   }
}

