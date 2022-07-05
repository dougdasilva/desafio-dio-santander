package BancoSantander.Contas;

public interface IAccount {
	
	void withdraw(double amount);
	void deposit(double amount);
	void transfer(double amount, Account account);
	void bankStatement();
	void overdraftWithdrawal(double amount);
}
