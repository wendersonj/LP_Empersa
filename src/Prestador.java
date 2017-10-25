
public class Prestador {
	private String nome;
	private static int id;
	private Agenda agenda;
	
	
	
	public Prestador(String nome, Agenda agenda) {
		super();
		this.nome = nome;
		this.agenda = agenda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static int getId() {
		return id;
	}
	
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
}
