/*  This is java program for performing bank operations with regular experation and Exception handling
    
    @author Priyanshu */



package first.bank;
import java.util.Scanner;
import first.bank.controller.bankController;
import first.bank.model.bankModel;
import static java.lang.System.*;

public class App 
{
    public static void main( String[] args )
    {
       bankController bc=new bankController();  // Scanner object 
       bankModel bm =new bankModel();          // object of bankmodel 
       Scanner ps=new Scanner(System.in);
       out.println("\t\t\t-------Welcome to Great  Bank of India -------");
       out.println("Enter Account Holder name : ");
       String accHolderName=ps.next();
       bm.setAccHolder(accHolderName);
       try
       {
       	if(bc.checkUsername(bm))   // checking  username with validations 
       	{
       		  out.println("Enter Password For Your Account :");
       	        String accPassword=ps.next();
       	        bm.setAccPassword(accPassword);
       	        try {
       	        	
       	        		if(bc.checkPassword(bm))  // checking password with validations 
       	        		{
       	        			out.println("Enter Account Number :");
       	        	        int accNumber = ps.nextInt();
       	        	        bm.setAccNumber(accNumber);
       	        	        out.println("Enter Minimum balance :");
       	        	        int accBalance=ps.nextInt();
       	        	        bm.setAccBalance(accBalance);
       	        	        out.println("\t\t\t------your account details are here ------");
       	                    out.println(bm.toString());
       	                    
       	                   int op=0;
       	                    while(op<3)  
       	                    {
       	                    out.println("Please Select Operation : \n Press 1 for Deposit \n Press 2 for Withdraw \n Press 3 for Exit");
       	                   op=ps.nextInt();
       	                    switch(op) {
       	                   
       	                    case 1-> // This is for performing Deposite operations
       	                    {
       	                    	out.println("Enter password for  deposit amount : ");
       	                    	String pwd=ps.next();
       	                    	try {
       	                    		if(bc.toDeposit(bm, pwd)) 
       	                    		{
       	                    		out.println("Enter amount for deposit :");
       	                    		int newAmt=ps.nextInt();
       	                    		bm.depositeAmount(newAmt);
       	                    		out.println("your account balance is :"+bm.getAccBalance());	
       	                    		}
       	                    	}
       	                    	catch(Exception e)
       	                    	{
       	                    		out.println(e.getMessage());
       	                    	}
       	                    	
       	                    }
       	                   
       	                    case 2->  // This is for performing Withdraw operations
       	                    
       	                    {
       	                    	out.println("Enter password for  withdraw amount :");
       	                    	String pwd=ps.next();
       	                    	out.println("Enter amount for withdraw :");
   	                    		int newAmt=ps.nextInt();
   	                    		try {
   	                    			if(bc.toWithdraw(bm, pwd, newAmt)) {
   	                    				bm.withdrawAmount(newAmt);
   	                    				out.println("Withdraw successfull \nYour current account balance is : "+bm.getAccBalance());
   	                    			}
   	                    		}
   	                    	// here we catch the Exception
   	                    		    catch(Exception e) {
   	                    			out.println(e.getMessage());
   	                    		}
       	                    }
       	                    	default->System.exit(0); // This is for entering default operation to perform
       	                    
       	                    }
       	                    }
       	        		}
       	        }
       	      // here we catch the Exception
       	            catch(Exception e) {
       	        	out.println(e.getMessage());
       	        }
       	}
       }
       catch(Exception e) // here we catch the Exception
       {
       	out.println(e.getMessage());
       	System.exit(0);
       }
       ps.close(); // must close Scanner object
   }
}
