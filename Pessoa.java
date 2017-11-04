
public abstract class Pessoa {
	private String nome;
	private String registro;
	
	public Pessoa(String nome, String registro) {
		setNome(nome);
		setRegistro(registro);
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public String toString(){
		return "\nNome: " + this.nome; 
	}
}
