package BancoSantander;

public class Bank {
	
	private final Integer number = 33;	
	private final String name = "Santander";
	private final String agency = "1234-5";

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}
	
	public String getAgency() {
		return agency;
	}

	@Override
	public String toString() {
		return "[number=" + number + ", name=" + name + ", agency=" + agency + "]";
	}
}
