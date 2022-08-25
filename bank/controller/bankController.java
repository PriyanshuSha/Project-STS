package first.bank.controller;
import java.io.IOException;
import java.util.regex.Pattern;
import first.bank.model.bankModel;

public class bankController {
	
	public boolean checkUsername(bankModel bm) throws IOException{
	  String username=bm.getAccHolder();
	  
	  if(Pattern.matches("[a-zA-Z0-9]{5,13}", username))
	  {
		  return true;
	  }
	  else {
		  throw new IOException("\t\t!!------WARNING------ !!\n Username can only be only in alphabet and digits ");
	  }
		
	}
  public boolean checkPassword(bankModel bm) throws IOException {
	String password= bm.getAccPassword();
	
	if(Pattern.matches("[a-zA-Z0-9@#]{6,}",password))
	{
		return true;
	}
	else {
		throw new IOException("\t\t!!------- WARNING-------- !! \n password must have atleast more than 6 character :");
	}
}

public boolean toDeposit(bankModel bm,String pwd) throws IOException{
	
	String password=bm.getAccPassword();
	if(pwd.equals(password)) {
		return true;
	}
	else {
		throw new IOException("Wrong Password !!\n Please enter correct password :");
	}	
}

public boolean toWithdraw(bankModel bm,String pwd,int withdrawAmt) throws IOException{
	
	String password=bm.getAccPassword();
	int accbal =bm.getAccBalance();
	if(pwd.equals(password)) {
		if(accbal>withdrawAmt) {
			return true;
		}
		else {
			throw new IOException("Not Enough Balance !!");
		}
	}
	else {
		throw new IOException("Wrong password !!\n Please enter correct password : ");
	}
	
	
}
}

