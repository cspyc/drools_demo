package droolscours;

import java.util.Date;

public class CashFlow {

	private long accountNo;
	private int type;
	private double amount;
	private Date date;
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CashFlow [accountNo=" + accountNo + ", type=" + type + ", amount=" + amount + ", date=" + date + "]";
	}
	
	
}
