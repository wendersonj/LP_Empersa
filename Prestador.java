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
	

	// se tiver adicionado uma exceção ao criar data para data inválida, talvez precis adicionar um try catch aqui
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
