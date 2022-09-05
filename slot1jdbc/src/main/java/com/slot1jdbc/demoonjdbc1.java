package com.slot1jdbc;

import java.sql.*;
public class demoonjdbc1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
	    String ur1="jdbc:mysql://localhost:3306/company";
		String username="root";
		String password="Mukul@321";
		String query="select *from employee where eid=101";
		
		Connection con=DriverManager.getConnection(ur1,username,password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
	    rs.next();
		
		
		String empname="Employee name is : "+rs.getString("ename")+" and he is working as a " +rs.getString("edomian")+" trainer and his monthly salary  is : "+rs.getInt("esalary");
		System.out.println("Employee name : "+empname);
		
		con.close();

	}

}
