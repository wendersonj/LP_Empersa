import java.time.LocalDate;
import java.util.ArrayList;

public class Prestador implements ID {
	private String nome;
	private ArrayList<Agenda> compromissos = null;
	private static int ID_PRESTADOR = 0;
	private int matricula;
	
	public Prestador(String nome) {
		super();
		this.nome = nome;
		this.matricula = ++ID_PRESTADOR;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return ID_PRESTADOR;
	}
		
	public boolean marcarCompromisso(){
		return false;
	}
	
	public ArrayList<Agenda> getCompromissos() {
		return compromissos;
	}
	public void addCompromissos(ArrayList<Agenda> compromissos) {
		this.compromissos = compromissos;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	
	
	//ALTERAÇÕES ISABELA
	// se tiver adicionado uma exceção ao criar data para data inválida, talvez precis adicionar um try catch aqui
		public boolean addAgenda(LocalDate data, Cliente cliente, Servico servico) {
			if(consultaAgenda(data, servico.getDuracao()) == null) {
				this.compromissos.add(new Agenda(data.getDayOfMonth(), data.getMonthValue(), data.getYear(), cliente, servico));
				return true;
			} else
				return false;
		}
		
		public boolean removeAgenda(Agenda compromissos) {
			if(consultaAgenda(compromissos.getData(), compromissos.getServiço().getDuracao()) != null) {
				this.compromissos.remove(compromissos);
				return true;
			}else
				return false;
		}
		
		// não dá para adicionar uma exceção quando a data não estiver na compromissos
		// porque pode ser justamente o que está sendo procurado, como é o caso quando uma nova data é adicionada à compromissos
		public Agenda consultaAgenda(LocalDate dataInicio, int duracao){
			while(duracao > 0) {
				for(int i = 0; i < compromissos.size(); i++) {
					if(dataInicio.equals(compromissos.get(i).getData())) return compromissos.get(i);
				}
				dataInicio.plusDays(1);
				duracao--;
			}
			return null;
		}
	
}
