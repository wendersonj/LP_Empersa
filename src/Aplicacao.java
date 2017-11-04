import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacao {

	public static void main(String[] args) {
		Cliente temporario = new Cliente("Wends", "123456789");
		
		ArrayList<Prestador> prestadoresSA = new ArrayList<Prestador>();
		prestadoresSA.add(new Prestador("Antonio Da Ixkina", "00000001"));
		prestadoresSA.add(new Prestador("Maria Da Outra Ixkina", "00000022"));
		
		Empresa LimpezaSA = new Empresa("LimpezaSA", "000000001-0000/11");
		
		LimpezaSA.cadastra(temporario);
		LimpezaSA.cadastra(new Prestador("Senhor Do Anel", "00000000333"));
		
		LimpezaSA.cadastraServico("Limpeza", "LimpezaA", 1);
		

		LocalDate data = LocalDate.now();
		
		try {
			//LimpezaSA.getClientes().get(0).getCpf()
			LimpezaSA.agendarServico("123456789", "Limpeza", LocalDate.now(), LimpezaSA.buscarPrestadoresServico("Limpeza", LocalDate.now()).get(0));
		} catch (ExcecaoAgendar | ExcecaoPessoa | ExcecaoServico e) {
			System.out.println(e.getMessage());
		}
		
		//
		LimpezaSA.imprimeTodosCompromisso();
		
		
		
		
				
		
	}

}
