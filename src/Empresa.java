import java.util.ArrayList;

public class Empresa {
	private String nome;
	private String CNPJ;
	private ArrayList<Prestador> prestadores;
	private Agenda agenda;
	private ArrayList<Cliente> clientes;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public ArrayList<Prestador> getPrestadores() {
		return prestadores;
	}
	public void setPrestadores(ArrayList<Prestador> prestadores) {
		this.prestadores = prestadores;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	}
