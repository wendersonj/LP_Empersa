import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.Iterator;

public class Agenda {
	private Calendar calendario;
	private ArrayList<Calendar> compromissos;
	
	public Calendar getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}

	public ArrayList<Calendar> getCompromissos() {
		return compromissos;
	}

	public void setCompromissos(ArrayList<Calendar> compromissos) {
		this.compromissos = compromissos;
	}
	
	@SuppressWarnings("null")
	public boolean consultaCompromisso(int dia, int mes, int ano){
		Iterator<Calendar> it = compromissos.iterator();
		//(ano-1900), (mes-1), dia
		Calendar calendario = null;
		calendario.set(ano, (mes-1), dia);
		
		while(it.hasNext()){
			if(it.equals(calendario))
				return true;
		}
		
		return false;
	}
	
}
