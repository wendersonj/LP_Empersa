import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa extends Pessoa {
	private String CNPJ;

	public Empresa(String nome, String CNPJ) {
		super(nome, null);
		this.setCNPJ(CNPJ);
	}

	private ArrayList<Prestador> prestadores;
	private ArrayList<Cliente> clientes;
	private ArrayList<Servico> listaServicos;
	private Agenda agenda;

	//--inicio M�todos EMPRESA
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
	//--FIM M�TODOS EMPRESA


	//CRUD
	//Add
	//Remove
	//Atualiza
	//L�

	public void cadastra(Pessoa cadastro) {
		//	caso n�o retorne uma pessoa, pode cadastrar.
		if(consultaPessoa(cadastro.getCpf(), cadastro) == null) {
			if(cadastro instanceof Prestador)
				prestadores.add(new Prestador(cadastro.getNome(), cadastro.getCpf()));
			else
				clientes.add(new Cliente(cadastro.getNome(), cadastro.getCpf()));
		}
		else {
			System.out.println("Pessoa j� cadastrada");
		}
	}

	public void remove(int id){

	}

	public void remove(String cpf){

	}

	// consulta pessoa cliente ou prestador
	Pessoa consultaPessoa(String cpf, Pessoa quem) {
		if(quem instanceof Cliente){
			for(Cliente c : clientes) {
				if(c.getCpf().equals(cpf))
					return c;
			}
		}
		if(quem instanceof Prestador){
			for(Prestador p : prestadores) {
				if(p.getCpf().equals(cpf))
					return p;
			}
		}

		return null;
	}

	// consulta servico
	public Servico consultaServico(String nome) {
		for(Servico i : listaServicos) {
			if(i.getNome().equalsIgnoreCase(nome))
				return i;
		}
		return null;
	}


	// Adiciona um servi�o na lista de servi�os que podem ser prestados
	// necessita de tratamento de exce��o
	public void cadastraServico(String nome, String descricao, int duracao) {
		if(consultaServico(nome) == null) 
			listaServicos.add(new Servico(nome, descricao, duracao));
		else 
			System.out.println("Servi�o j� existente!");
	}

	// Retorna a lista dos prestadores que prestam um determinado servi�o e que possuem agenda livre
	public ArrayList<Prestador> buscarPrestadoresServico(String nomeServico, LocalDate dataInicio){
		ArrayList<Prestador> listaPrestadores = new ArrayList<Prestador>();
		Servico servico = consultaServico(nomeServico);

		// criar tratamento de erro para servi�o inexistente
		if(servico == null) 
			return null;

		// criar tratamento de erro para quando n�o tem prestadores dispon�veis
		for(Prestador i : prestadores) {
			if(i.consultaAgenda(dataInicio, servico.getDuracao()) == null) 
				listaPrestadores.add(i);
		}
		return listaPrestadores;
	}



	public boolean agendarServico(String CpfCliente, String nomeServico, LocalDate dataInicio, Prestador prest) throws ExcecaoAgendar{
		Cliente c = null;
		Servico sv = null;
		Prestador p = null;

		// testa se o cliente existe
		try{
			
			c = (Cliente) consultaPessoa(CpfCliente, c);
			if(c == null)
				throw new ExcecaoPessoa();
		}
		catch(ExcecaoPessoa e){
			System.out.println(e.getMessage());
			return false;
		}

		// testa se o servi�o existe
		try{
			sv = consultaServico(nomeServico);
			if(sv == null)
				throw new ExcecaoServico();
		}
		//modificar a excecao
		catch(ExcecaoServico e){
			System.out.println(e.getMessage());
			return false;
		}

		// testa se o prestador existe
		try{		
			prest = (Prestador) consultaPessoa(prest.getCpf(), p);			
			if(prest == null)
				throw new ExcecaoPessoa();
		}
		catch(ExcecaoPessoa e)	{
			System.out.println(e.getMessage());
			return false;
		}
		
		
		
		
		
		
		return false;

	}

























	
	//	M�TODOS DA EMPRESA

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	@Override
	public String getCpf() {
		return getCNPJ();
	}



}
