
public class Cliente implements ID{
	private String nome;
	private String CPF;
	private static int IDS_CLIENTE = 0;
	private int id;
		
	public Cliente(String nome, String cPF) {
		super();
		this.nome = nome;
		CPF = cPF;
		id= ++IDS_CLIENTE;
	}

	public int getIDS_CLIENTE() {
		return IDS_CLIENTE;
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
