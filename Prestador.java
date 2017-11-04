import java.time.LocalDate;
import java.util.ArrayList;

public class Prestador extends Pessoa{
	private ArrayList<Agenda> compromissos = new ArrayList<>();
	
	public Prestador(String nome, String cpf) {
		super(nome, cpf);
	}
		
	public ArrayList<Agenda> getListaCompromissos() {
		return compromissos;
	}
	

	// se tiver adicionado uma exce��o ao criar data para data inv�lida, talvez precis adicionar um try catch aqui
	public boolean marcarCompromisso(LocalDate data, Cliente cliente, Servico servico) {
		if(consultaAgenda(data, servico.getDuracao()) == null) {
			int duracao = servico.getDuracao();
			while(duracao > 0) {
				this.compromissos.add(new Agenda(data.getDayOfMonth(), data.getMonthValue(), data.getYear(), cliente, servico));
				data.plusDays(1);
				duracao--;
			}
			return true;
		} 
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
					if(dataInicio.equals(compromissos.get(i).getData())) 
						return compromissos.get(i);
				}
				dataInicio.plusDays(1);
				duracao--;
			}
			return null;
		}
	
		public String toString() {
			String buffer = null;
			for(Agenda a : compromissos) {
				buffer += a.toString();
			}
			return "\nPrestador: " + super.toString() + "CPF: " + super.getRegistro() + "\n Compromissos: " + buffer;
		}
}
