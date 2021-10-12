package exception;

public class Account 
{
	protected double balance;
	
	public Account(double balance)
	{
		this.balance = balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public void withdraw(double amount) throws OverdraftException
	{
		
		if(balance < amount)
		{
			throw new OverdraftException("Balance should bigger than 0", amount-this.balance);
		}
		balance -= amount;
	}
	
	public class OverdraftException extends Exception
	{
		private double deficit;
		public double getDeficit()
		{
			return deficit;
		}
		
		public OverdraftException(String message, double deficit)
		{
			super(message);
			this.deficit = deficit;
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Account test = new Account(99);
		test.deposit(1);
		test.getBalance();
		try {
			test.withdraw(200);
		}catch (OverdraftException e) {
			System.err.println(e.getDeficit());
			e.printStackTrace();
		}
		
	}

}
