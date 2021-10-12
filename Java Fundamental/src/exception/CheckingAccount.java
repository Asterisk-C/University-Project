package exception;

public class CheckingAccount extends Account
{
	private double overdraftProtection;
	
	public CheckingAccount(double balance)
	{
		super(balance);
	}
	
	public CheckingAccount(double balance, double overdraftProtection)
	{
		super(balance);
		this.overdraftProtection = overdraftProtection;
	}
	
	@Override
	public void withdraw(double amount) throws OverdraftException
	{
		
		if(balance + overdraftProtection < amount)
		{
			double deficit = amount - (balance + overdraftProtection);
			throw new OverdraftException("Deficit overdraft", deficit);
		}
		this.balance -= amount;
	}
	
	public static void main(String[] args) 
	{
		CheckingAccount a = new CheckingAccount(1000, 500);
        //´æÁË1000
        a.deposit(1000);
        //²éÑ¯Óà¶î
        System.out.println(a.getBalance());
        try {
            a.withdraw(600);
            System.out.println(a.getBalance());
            a.withdraw(600);
            System.out.println(a.getBalance());
            a.withdraw(600);
            System.out.println(a.getBalance());
            a.withdraw(600);
            System.out.println(a.getBalance());
            a.withdraw(600);
            System.out.println(a.getBalance());
        } catch (OverdraftException e) {
            System.err.println("Deficit overdraft: " + e.getDeficit());
            e.printStackTrace();
        }
	}
}
