
package com.slot1jdbc;
import java.util.Scanner;                                     // Here we use a Scanner class to take input from user 
import static java.lang.System.*;                             // Here we use System class to avoid System from System.out.println
public class bankingMain {

	public static void main(String[] args) throws Exception{
		
		Scanner PS=new Scanner(System.in);                    // Here we create Scanner object as PS
		bankingDao dao=new bankingDao();
		bankingCustomer b1=new bankingCustomer();
		out.println("\t\t\t\t------WELCOME TO WORLD'S BEST BANK------");
		out.println("**Please Select Operation : \nPRESS :1 for Register Account \nPRESS :2 for Login into Account");
		int op=PS.nextInt();
		
		switch(op) {
		case 1->{
		                                                      // Here we perform operations related to create account
			out.println(" ---Please enter your details to create NEW ACCOUNT--- ");
			out.print("Enter Customer's Name : ");
			String cName=PS.next();                           // Here we read user's name from user 
			out.print("Create your  Password : ");
			String cPwd=PS.next();                            // Here we read user's Password from user 
			out.print("Enter Cutstomer's PhoneNumber : ");
			String cPhone=PS.next();                          // Here we read user's Phone number  from user 
			out.print("Enter Account balance : ");
			int cAccbal=PS.nextInt();                         // Here we read user's Account balance from user 
			b1.cName=cName;
			b1.cPassword=cPwd;
			b1.cPhone=cPhone;
			b1.cAccbal=cAccbal;
			
			dao.connect();                                    // Here we connect our program from database
			int res=dao.registerCustomer(b1);
			if(res!=0) {
				out.println("\t\t\t-----Account Created successfully-----");
				out.println("\t\t\t-----PLEASE NOTDOWN YOUR PASSWORD FOR FUTURE USES-----");
			}
			else {
				out.println("\t\t\t-----OOPS SORRY !!----- \nSomething  wrong, please tryagain");
			}
		}
		
		case 2->{
			                                                  // Here we perform operations related to Login 
			out.println("Please Enter Customer Details to Login");
			out.print("Enter Customer's Name : ");            // Here we read user's name from user for login
			String cName=PS.next();
			out.print("Enter Customer's Password : ");        // Here we read user's Password from user for login
			String cPwd=PS.next();
			
			dao.connect();                                    // Here we connect our program from database
			int res=dao.login(cName, cPwd);
			if(res==0) {                                      // Here we check user's entered details is correct or not related to login
				out.println("\t\t\t-----Wrong Username Or Password, PLEASE TRY AGAIN-----");
			}
			else if(res==-1) {
				out.println("\t\t\t----Account Not Found Please Register yourself-----");
			}
			else {                                           // Here we grant permission to the user for perform other transactions
				out.println("\t\t\t------Login Successfully------");
			                                                 // Here we are giving access to the user for withdraw or deposit
				int op2=0;
				while(op2<5) {
				out.println("**Please Select Operation : \nPRESS :1 for Withdraw Amount \nPRESS :2 for deposit Amount \nPRESS :3 for Check Your Balance \nPRESS :4 for change your Password \nPRESS :5 for Exit ");
				op2=PS.nextInt();
				switch(op2) {
				
				case 1->{
					                                         // Here we Perform withdraw operation 
					out.println("Enter Amount To Withdraw : ");
					int amt=PS.nextInt();
				    int res2=dao.withdraw(res, amt);
					if(res2<=0) {
						out.println("OOPSS...!! Something Wrong");
					}
					else {
						out.println("*Withdraw Done Successfully, Your Updated Blance is :"+res2);
						
					}
				}
				case 2->{
					                                         // Here we perform deposit operation
					System.out.println("Enter amount to deposit :");
					int amount=PS.nextInt();
					int res2=dao.deposit(res, amount);
					if(res2==-1) {
						System.out.println("\t\t\t------Something went wrong------");
					}
					else {
						System.out.println("*Deposit done, updated balance is : "+res2);
					}
				}
				
				case 3->{
					                                        // Here we check users balance 
					System.out.println("*Your Current Balance is : "+dao.checkBalance(res));
				}
				case 4->{
					                                       // Here we change user's Password 
					System.out.println("Enter your Old Password : ");
					String pwd=PS.next();
					System.out.println("Enter new password : ");
					String newpin=PS.next();
					int count=dao.passwordChange(res, pwd,newpin);

				if(count<=0)
				{
					System.out.println("\t\t\t------Password not matched------");
				}
				else {
					System.out.println("\t\t\t------password updated successfully------");
				}
				}
				
				}
				
			}
		}

	}

	} PS.close();     // Here we close Scanner object
		}}
