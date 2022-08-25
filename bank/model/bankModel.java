package first.bank.model;

public class bankModel {
	private int accNumber;
	private int accBalance;
	private String accHolder;
	private String accPassword;
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public int getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(int accBalance) {
		this.accBalance = accBalance;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	public String getAccPassword() {
		return accPassword;
	}
	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}
	public void depositeAmount(int amount) {
		this.accBalance +=amount;
	}
	public void withdrawAmount(int amount) {
		this.accBalance -=amount;
	}	
	@Override
	public String toString() {
		return "bankModel [accNumber=" + accNumber + ", accBalance=" + accBalance + ", accHolder=" + accHolder
				+ ", accPassword=" + accPassword + "]";
	}
	
	
	
}
