package BancoSantander;

import java.util.ArrayList;
import java.util.List;

import BancoSantander.Cliente.Client;
import BancoSantander.Contas.Account;
import BancoSantander.Contas.BronzeAccount;
import BancoSantander.Contas.SilverAccount;
import Exceptions.SaldoNegativoException;

public class Main {

	public static void main(String[] args) {

		List<Account> accounts = new ArrayList<>();

		// Instanciando class do banco
		Bank santander = new Bank();

		// Criando clientes
		Client client1 = new Client("Goku da Silva", "13/06/1990", "52345678900");
		Client client2 = new Client("Maria Joaquina","14/04/1989","10000000000");

		// Criando uma conta do tipo Bronze Account e outra do tipo SilverAccount
		Account accountBronze = new BronzeAccount(santander, client1, 100.0);
		Account accountSilver = new SilverAccount(santander, client2, 100.0);

		// Salvando contas na lista de contas
		accounts.add(accountBronze);
		accounts.add(accountSilver);
		
		// Ativar um cartão na conta bronzeAccount e outro na conta silverAccount
		CreditCard cardAccBronze = new CreditCard();
		cardAccBronze.activateCreditCard(accountBronze);
		
		CreditCard cardAccSilver = new CreditCard();
		cardAccSilver.activateCreditCard(accountSilver);

		// Realizar depósitos nas contas e imprimir o valor atuar do saldo
		accountBronze.deposit(200.0);
		System.out.printf("Saldo da bronze account após o depósito: %.2f", accountBronze.getBalance());
		
		accountSilver.deposit(200.0);
		System.out.printf("\nSaldo da silver account após o depósito: %.2f", accountSilver.getBalance());
		
		// Saque com 0,2% de juros em cima do valor desejado para bronze account e
		// saldo após o saque
		accountBronze.withdraw(200.0);
		System.out.printf("\nSaldo da bronze account após o saque de 200 reais: %.2f" ,accountBronze.getBalance());
		
		// Saque com 0,1% de juros em cima do valor desejado para bronze account e
		// saldo após o saque
		accountSilver.withdraw(200.0);
		System.out.printf("\nSaldo da silver account após o saque de 200 reais: %.2f\n", accountSilver.getBalance());

		
		//Transferencia de 50 reais de bronzeaccount para silveraccount
		accountBronze.transfer(50.0, accountSilver);
		
		
		// Tratamento de exception personalizada para saque acima do saldo
		try {
			accountBronze.withdraw(350.0);
		} catch (SaldoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		//Saque de 500 reais do cheque especial da bronze account
		accountBronze.overdraftWithdrawal(500.0);

		// Imprimir todas as contas
		for (Account account : accounts) {
			System.out.println("=================================");
			account.bankStatement();
			System.out.println("=================================");
		}
	}
}
