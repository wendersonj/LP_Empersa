import java.util.Iterator;

@SuppressWarnings("serial")
public class ExcecaoID extends Exception {

	public ExcecaoID (String lista){
		super("Lista "+lista + "não possui o ID pesquisado !");
	}

	@SuppressWarnings("rawtypes")
	public ExcecaoID(Class<? extends Iterator> class1) {
		super("Lista "+class1 + "não possui o ID pesquisado !");
	}
	
}
