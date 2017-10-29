
public class Cliente implements ID{
	private String nome;
	private String CPF;
	private int id = 0;
		
	public Cliente(String nome, String cPF) {
		super();
		this.nome = nome;
		CPF = cPF;
		id ++;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public int getId() {
		return this.id;
	}

}
