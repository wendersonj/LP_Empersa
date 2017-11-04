
public class Cliente extends Pessoa{
	
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public String toString() {
		return "\n Cliente: " + super.toString() + "CPF: " + super.getRegistro();
	}
}
