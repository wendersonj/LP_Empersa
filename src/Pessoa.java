
public abstract class Pessoa {
	private String nome;
	private String cpf;
	private int id;
	private static int proxID = 0;
	
	public Pessoa(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
		setId(++proxID);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
