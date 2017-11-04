import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacao {

	public static void main(String[] args) {
		
		
		ArrayList<Prestador> prestadoresSA = new ArrayList<Prestador>();
		prestadoresSA.add(new Prestador("Antonio Da Ixkina", "00000001"));
		prestadoresSA.add(new Prestador("Maria Da Outra Ixkina", "00000022"));
		
		Empresa LimpezaSA = new Empresa("LimpezaSA", "000000001-0000/11");
		
		LimpezaSA.cadastra(new Cliente("Wends", "123456789"));
		LimpezaSA.cadastra(new Prestador("Senhor Do Anel", "00000000333"));
		
		LimpezaSA.cadastraServico("Limpeza", "LimpezaA", 1);
		
		try {
			LimpezaSA.agendarServico(LimpezaSA.getClientes().get(1).getCpf(), "Limpeza", LocalDate.now(), LimpezaSA.buscarPrestadoresServico("Limpeza", LocalDate.now()).get(1));
		} catch (ExcecaoAgendar | ExcecaoPessoa | ExcecaoServico e) {
			System.out.println(e.getMessage());
		}
		
		//System.out.println(LimpezaSA.get);
		
		
		
		
				
		
	}

}
