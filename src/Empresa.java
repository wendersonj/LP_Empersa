import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Empresa {
	private String nome;
	private String CNPJ;
	private ArrayList<ID> prestadores;
	private ArrayList<ID> clientes;
	private ArrayList<Servico> listaServicos;
	private Agenda agenda;
	
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
	public ArrayList<ID> getPrestadores() {
		return prestadores;
	}
	
	//CRUD Prestadores
	//Add
	//Remove
	//Atualiza
	//Lê
	
	public void setPrestadores(ArrayList<ID> prestadores) {
		this.prestadores = prestadores;
	}
	
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public ArrayList<ID> getClientes() {
		return clientes;
	}
	
	public void setClientes(ArrayList<ID> clientes) {
		this.clientes = clientes;
	}


	//Polimorfismo parametrico usando interface ID
	public ID consulta(int id, List<ID> lista) throws ExcecaoID{
		Iterator<ID> it = lista.iterator();
		while(it.hasNext()){
			ID atual = it.next();
			if( atual.getId() == id)
				return atual;
		}	
		throw new ExcecaoID(it.getClass());
	}

	public boolean agendarServico(int clienteId, int prestadorId, Serviço sv, Date dataInicio) throws ExcecaoID{
		Cliente cliente = null;
		Prestador prestador = null;
		
		try{
			cliente = (Cliente) consulta(clienteId, clientes);			
		}
		catch(ExcecaoID e){
			System.out.println(e.getMessage());
			return false;
		}

		try{
			prestador = (Prestador) consulta(prestadorId, prestadores);
		}
		catch(ExcecaoID e){
			System.out.println(e.getMessage());
			return false;
		}
		
		prestador.marcarCompromisso();
		
		
		return false;

	}

}
