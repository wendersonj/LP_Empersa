import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa extends Pessoa {
	private String CNPJ;

	public Empresa(String nome, String CNPJ) {
		super(nome, null);
		this.setCNPJ(CNPJ);
	}

	private ArrayList<Prestador> prestadores = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Servico> listaServicos = new ArrayList<>();
	private ArrayList<ArrayList<Agenda>> listaAgendas = new ArrayList<>(); //Lista todos os COMPROMISSOS de TODOS os PRESTADORES

	//--inicio M�todos EMPRESA
	public ArrayList<Prestador> getPrestadores() {
		return prestadores;
	}

	public void setPrestadores(ArrayList<Prestador> prestadores) {
		this.prestadores = prestadores;
		for(Prestador i : this.prestadores)
			atualizaAgendaGeral(i);
	}

	public ArrayList<ArrayList<Agenda>> getListaAgendas() {
		return this.listaAgendas;
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
			if(cadastro instanceof Prestador){
				prestadores.add(new Prestador(cadastro.getNome(), cadastro.getCpf()));
				//prestadores.add((Prestador) cadastro);
			}
			else{
				//clientes.add((Cliente) cadastro);
				clientes.add(new Cliente(cadastro.getNome(), cadastro.getCpf()));
			}
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
			if(clientes == null)
				return null;
			for(Cliente c : clientes) {
				if(c.getCpf().equals(cpf))
					return c;
			}
		}
		if(quem instanceof Prestador){
			if(prestadores == null)
				return null;
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



	public boolean agendarServico(String CpfCliente, String nomeServico, LocalDate dataInicio, Prestador prest) 
			throws ExcecaoAgendar, ExcecaoPessoa, ExcecaoServico{

		Cliente c = new Cliente(null, CpfCliente);
		Servico sv = null;

		// testa se o cliente existe
		c = (Cliente) consultaPessoa(CpfCliente, c);
		if(c == null)
			throw new ExcecaoPessoa("Cliente Inexistente !"); 
		//quem chama o m�todo agendarServico deve tratar com um try-catch para pegar a Exce��o.
		// Logo, como vai ser exibida a mensagem de erro passada n�o � problema da classe e sim de quem usa o m�todo


		// testa se o servi�o existe
		sv = consultaServico(nomeServico);
		if(sv == null)
			throw new ExcecaoServico();


		// testa se o prestador existe

		prest = (Prestador) consultaPessoa(prest.getCpf(), prest);			
		if(prest == null)
			throw new ExcecaoPessoa("Prestador Inexistente !");


		//Chegou aqui - registrar servi�o no prestador para o cliente passado
		if(prest.marcarCompromisso(dataInicio, c, sv))
			return true; 	//sucesso
		else{
			return false;	//fail
		}

	}


	private void atualizaAgendaGeral(Prestador p){
		this.listaAgendas.add(p.getListaCompromissos());
	}

	public void imprimeTodosCompromisso(){
		for(int i = 0; i < this.listaAgendas.size(); i ++){
			System.out.println("\n");
			for(int j = 0; j < this.listaAgendas.get(i).size(); j ++ ){
				System.out.println("Cliente: " + listaAgendas.get(i).get(j).getCliente().getNome());
				System.out.println("Data: " + listaAgendas.get(i).get(j).getData().getDayOfMonth() +
						"/"+listaAgendas.get(i).get(j).getData().getMonthValue() + "/"+ listaAgendas.get(i).get(j).getData().getYear());
				System.out.println("Servi�o: " + listaAgendas.get(i).get(j).getServi�o().getNome());
			}
		}
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

	@Override
	public void setCpf(String cpf) {
		setCNPJ(cpf);
	}


}
