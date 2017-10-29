
public class Prestador implements ID {
	private String nome;
	private Agenda agenda;
	private static int qtd;
	private int id;
	
	public Prestador(String nome) {
		super();
		this.nome = nome;
		id = qtd++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return this.id;
	}
	
	public Agenda getAgenda() {
		return agenda;
	}
	
	public boolean marcarCompromisso(){
		return false;
		
	}
	
	
}
