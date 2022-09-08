/*This is a java Program in which we enter user details into database and retrieve details from database 
   @author Priyanshu */

package com.slot1jdbc;
import java.sql.*;  // It is a important package which is we import to work with sql.
public class bankingDao {
  
	Connection con=null;
	// Here we connect our program with database
	public void connect()throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Mukul@321");	
		
	}
	
	 public int registerCustomer(bankingCustomer b1)throws Exception {
		 // Here we we perform operations related to registration of customer
		String query="insert into banking(cName,cPassword,cPhone,cAccbal) values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1,b1.cName);              // Here we enter name of the customer at 1st column in database
		pst.setString(2, b1.cPassword);         // Here we enter name of the customer at 2st column in database
		pst.setString(3, b1.cPhone);            // Here we enter name of the customer at 3rd column in database
		pst.setInt(4, b1.cAccbal);              // Here we enter name of the customer at 4th column in database
		
		int count=pst.executeUpdate();          // Here we update all informations of user into the database
		return count;
		
	}
	
	public int login(String userName, String Pwd)throws Exception{
		//Here we we perform operations related to Login 
		String query="select * from banking where cname= '"+userName+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next()) {                                                
			    String cpwd=rs.getString(3);                                               
			if(cpwd.equals(Pwd)) {
			    int eId=rs.getInt(1);           // Here we access match users password                                         
			    return eId;
			}
			else {
			    return 0;
				 }
			}
		else {
		       return -1;
			 }
	}
	
	
	public int withdraw(int cId,int amount)throws Exception {
		//Here we we perform operations related to Withdraw amount from account 
		String query="select * from banking where cid="+cId;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		int accbal=rs.getInt(5);              // Here we get account balance from database  
		
	 if(accbal>amount) {                      // Here we check condition in which we match account balance with withdraw amount
			accbal-=amount;                   // Here we withdraw amount from account
			String query2="update banking set caccbal="+accbal+" where cid="+cId;
			Statement st2=con.createStatement();
			int res=st2.executeUpdate(query2);
			return accbal;                    // Here we return updated balance to the user after withdraw done  
		}	
	 else {
			return -1;
		}	
}
	public int deposit(int cId, int amount)throws Exception{
		//Here we we perform operations related to deposit amount in the account
		String query="select * from banking where cid="+cId;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next())
		{
		int accbal=rs.getInt(5);            // Here also we get account balance from database  
		accbal+=amount;                     // Here we add amount into account
		String query2="update banking set caccbal="+accbal+" where cid="+cId;
		PreparedStatement pst=con.prepareStatement(query2);
		pst.executeUpdate();
		return accbal;                      // Here we return updated balance to the user after deposit done
		}
		else {
			return -1;
		}
	}
	
	public int checkBalance(int cId)throws Exception{
		//Here we we perform operations related to Check account balance 
		String query="select * from banking where cid="+cId;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		int accbal=rs.getInt(5);          // Here also we get account balance from database 
		return accbal;                    // Here we return updated balance to the user 
		
	}
	
	public int passwordChange(int cId, String oldPassword,String newPassword)throws Exception{
		//Here we we perform operations related to Change user's Password 
		String query="select * from banking where cid="+cId;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String pwd=rs.getString(3);      // Here also we get account password from database
		
		if(pwd.equals(oldPassword)) {    // Here we match old password with database password
			String query2="update banking set cpassword="+newPassword+" where cid="+cId;
			PreparedStatement pst=con.prepareStatement(query2);
			int Passwordd=pst.executeUpdate();
			return Passwordd;            // Here we return new password to the user
		}
		else {
			return -1;
		}
		

} }
