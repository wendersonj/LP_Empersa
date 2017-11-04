import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa extends Pessoa {
	
	private String CNPJ;
	private ArrayList<Prestador> prestadores = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Servico> servicos = new ArrayList<>();
	
	public Empresa(String nome, String CNPJ) {
		super(nome, null);
		this.setRegistro(CNPJ);
	}

	//--inicio Métodos EMPRESA
	public ArrayList<Prestador> getPrestadores() {
		return prestadores;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	//--FIM MÉTODOS EMPRESA

	//CRUD
	//Add
	//Remove
	//Atualiza
	//Lê

	public void cadastra(Pessoa cadastro) {
		//	caso não retorne uma pessoa, pode cadastrar.
		if(consultaPessoa(cadastro.getRegistro(), cadastro) == null) {
			if(cadastro instanceof Prestador){
				prestadores.add(new Prestador(cadastro.getNome(), cadastro.getRegistro()));
			}
			else{
				clientes.add(new Cliente(cadastro.getNome(), cadastro.getRegistro()));
			}
		}
		else {
			System.out.println("Pessoa já cadastrada");
		}
	}

	public void remove(String cpf){

	}

	// consulta pessoa cliente ou prestador
	Pessoa consultaPessoa(String cpf, Pessoa quem) {
		if(quem instanceof Cliente){
			if(clientes == null)
				return null;
			for(Cliente c : clientes) {
				if(c.getRegistro().equals(cpf))
					return c;
			}
		}
		if(quem instanceof Prestador){
			if(prestadores == null)
				return null;
			for(Prestador p : prestadores) {
				if(p.getRegistro().equals(cpf))
					return p;
			}
		}

		return null;
	}

	// consulta servico
	public Servico consultaServico(String nome) {
		for(Servico i : servicos) {
			if(i.getNome().equalsIgnoreCase(nome))
				return i;
		}
		return null;
	}


	// Adiciona um serviço na lista de serviços que podem ser prestados
	// necessita de tratamento de exceção
	public void cadastraServico(String nome, String descricao, int duracao) {
		if(consultaServico(nome) == null) 
			servicos.add(new Servico(nome, descricao, duracao));
		else 
			System.out.println("Serviço já existente!");
	}

	// Retorna a lista dos prestadores que prestam um determinado serviço e que possuem agenda livre
	public ArrayList<Prestador> buscarPrestadoresServico(String nomeServico, LocalDate dataInicio){
		ArrayList<Prestador> listaPrestadores = new ArrayList<Prestador>();
		Servico servico = consultaServico(nomeServico);

		// criar tratamento de erro para serviço inexistente
		if(servico == null) 
			return null;

		// criar tratamento de erro para quando não tem prestadores disponíveis
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
		//quem chama o método agendarServico deve tratar com um try-catch para pegar a Exceção.
		// Logo, como vai ser exibida a mensagem de erro passada não é problema da classe e sim de quem usa o método

		
		// testa se o serviço existe
		sv = consultaServico(nomeServico);
		if(sv == null)
			throw new ExcecaoServico();

		// testa se o prestador existe
		prest = (Prestador) consultaPessoa(prest.getRegistro(), prest);			
		if(prest == null)
			throw new ExcecaoPessoa("Prestador Inexistente !");

		//Chegou aqui - registrar serviço no prestador para o cliente passado
		if(prest.marcarCompromisso(dataInicio, c, sv))
			return true; 	//sucesso
		else{
			return false;	//fail
		}

	}

	public void imprimeCompromissos(){
		for(Prestador i : prestadores)
			System.out.println(i.toString());
	}









	//	MÉTODOS DA EMPRESA
	@Override
	public String getRegistro() {
		return CNPJ;
	}
	@Override
	public void setRegistro(String cNPJ) {
		CNPJ = cNPJ;
	}

}
