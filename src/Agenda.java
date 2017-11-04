import java.time.LocalDate;

public class Agenda {
	private LocalDate data;
	private Cliente cliente;
	private Servico servico;
	
	public Agenda(int dia, int mes, int ano, Cliente cliente, Servico servi�o) {
		setdata(dia, mes, ano);
		setCliente(cliente);
		setServi�o(servi�o);
	}

	public LocalDate getData() {
		return data;
	}

	// tavez seja necess�rio tratar uma data inv�lida
	public void setdata(int dia, int mes, int ano) {
		this.data = LocalDate.of(dia, mes, ano);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServi�o() {
		return servico;
	}

	public void setServi�o(Servico servico) {
		this.servico = servico;
	}
	
	
	
}
