/* This is java program in which we retrive the data from the database 
  @Priyanshu */
package com.slot1jdbc;
import java.sql.*;
public class demoonjdbc1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Here we perfrom Loading and register 
		Class.forName("com.mysql.cj.jdbc.Driver");
	        String ur1="jdbc:mysql://localhost:3306/company";
		String username="root";
		String password="Mukul@321";
		String query="select *from employee where eid=101";
		                                      // Here we getting connection
		Connection con=DriverManager.getConnection(ur1,username,password);
		Statement st=con.createStatement();  // Here we perform creation of statement
		ResultSet rs=st.executeQuery(query); // Here we execute element
	        rs.next();                           // Here we goto the next element
		
		// Here we process the result or we can say that retrive information from database
		String empname="Employee name is : "+rs.getString("ename")+" and he is working as a " +rs.getString("edomian")+" trainer and his monthly salary  is : "+rs.getInt("esalary");
		System.out.println("Employee name : "+empname);
		
		con.close();                         // Here we close connection.
 
	}

}
