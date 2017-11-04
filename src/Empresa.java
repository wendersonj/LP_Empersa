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

	//--inicio Métodos EMPRESA
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
	//--FIM MÉTODOS EMPRESA


	//CRUD
	//Add
	//Remove
	//Atualiza
	//Lê

	public void Cadastra(Pessoa cadastro) {
		//	caso não retorne uma pessoa, pode cadastrar.
		if(consultaPessoa(cadastro.getCpf(), cadastro) == null) {
			if(cadastro instanceof Prestador)
				prestadores.add(new Prestador(cadastro.getNome(), cadastro.getCpf()));
			else
				clientes.add(new Cliente(cadastro.getNome(), cadastro.getCpf()));
		}
		else {
			System.out.println("Pessoa já cadastrada");
		}
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
