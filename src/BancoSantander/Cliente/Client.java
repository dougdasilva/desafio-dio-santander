package BancoSantander.Cliente;

public class Client {
	
	private String fullName;	
	private String birthday;
	private String cpf;
	
	public Client(String fullName, String birthday, String cpf) {
		super();
		this.fullName = fullName;
		this.birthday = birthday;
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "[fullName=" + fullName + ", birthday=" + birthday + ", cpf=" + cpf + "]";
	}
}
