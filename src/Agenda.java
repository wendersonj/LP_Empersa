import java.time.LocalDate;

public class Agenda {
	private LocalDate data;
	private Cliente cliente;
	private Servico servico;
	
	public Agenda(int dia, int mes, int ano, Cliente cliente, Servico serviço) {
		setdata(dia, mes, ano);
		setCliente(cliente);
		setServiço(serviço);
	}

	public LocalDate getData() {
		return data;
	}

	// tavez seja necessário tratar uma data inválida
	public void setdata(int dia, int mes, int ano) {
		this.data = LocalDate.of(dia, mes, ano);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServiço() {
		return servico;
	}

	public void setServiço(Servico servico) {
		this.servico = servico;
	}
	
	
	
}
