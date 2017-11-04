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
	
	
	
	//ALTERA��ES ISABELA
	// se tiver adicionado uma exce��o ao criar data para data inv�lida, talvez precis adicionar um try catch aqui
		public boolean addAgenda(LocalDate data, Cliente cliente, Servico servico) {
			if(consultaAgenda(data, servico.getDuracao()) == null) {
				this.compromissos.add(new Agenda(data.getDayOfMonth(), data.getMonthValue(), data.getYear(), cliente, servico));
				return true;
			} else
				return false;
		}
		
		public boolean removeAgenda(Agenda compromissos) {
			if(consultaAgenda(compromissos.getData(), compromissos.getServi�o().getDuracao()) != null) {
				this.compromissos.remove(compromissos);
				return true;
			}else
				return false;
		}
		
		// n�o d� para adicionar uma exce��o quando a data n�o estiver na compromissos
		// porque pode ser justamente o que est� sendo procurado, como � o caso quando uma nova data � adicionada � compromissos
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
