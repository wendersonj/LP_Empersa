
public class Servico {
	private String nome;
	private String descricao;
	private int duracao; //dias
	
	public Servico(String nome, String descricao, int duracao) {
		setNome(nome);
		setDescricao(descricao);
		setDuracao(duracao);
	}
	
	public int getDuracao() {
		return duracao;
	}

	// talvez precise adicionar uma exce��o aqui para dura��o menor ou igual a zero
	public void setDuracao(int duracao) {
		if(duracao < 1) 
			this.duracao = 1;
		else 
			this.duracao = duracao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
