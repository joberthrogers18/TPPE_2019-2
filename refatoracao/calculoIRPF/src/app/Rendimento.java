package app;

public class Rendimento {

	private String nomeRendimento;
	private float valor;
	private boolean ehTributavel;

	private Rendimento(String nomeRendimento, float valor, boolean ehTributavel) {
		this.nomeRendimento = nomeRendimento;
		this.valor = valor;
		this.ehTributavel = ehTributavel;
	}

	public static Rendimento obterRendimento(String nomeRendimento, 
											float valor,
											boolean ehTributavel) {
		Rendimento r = new Rendimento(nomeRendimento, valor, ehTributavel);
		return r;
	}

	public float getValor() {
		return valor;
	}

	public boolean ehTributavel() {
		return ehTributavel;
	}

}
