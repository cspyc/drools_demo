package droolscours;

import java.text.DateFormat;
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
//	@Override
//	public String toString() {
//		return "CashFlow [accountNo=" + accountNo + ", type=" + type + ", amount=" + amount + ", date=" + date + "]";
//	}

	public CashFlow() {
		super();
	}

	public CashFlow(Date mvtDate, double amount, int type, long accountNo) {
		super();
		this.date = mvtDate;
		this.amount = amount;
		this.type = type;
		this.accountNo = accountNo;
	}

	public static int CREDIT = 1;
	public static int DEBIT = 2;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buff = new StringBuffer();
		buff.append("-----CashFlow-----)\n");
		buff.append("Account no=" + this.accountNo + "\n");
		if (this.date != null) {
			buff.append("Movement Date= " + DateFormat.getDateInstance().format(this.date) + "\n");
		} else {
			buff.append("No Movement date was set\n");
		}
		buff.append("Mouement Amount=" + this.amount + "\n");
		buff.append("-----CashFlow end--)");
		return buff.toString();
	}

}
