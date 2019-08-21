package teste;

public class PA {

	private int a0;
	private int r;
	private int n;
	
	public PA(int a0, int r, int n) {
		this.a0 = a0;
		this.r = r;
		this.n = n;
	}
	
	public int[] getTermos() {
		
		int[] resultado = new int[this.n];
	
		
		for(int i = 1; i < this.n + 1; i++) {
			resultado[i - 1] = this.a0 + (i - 1) * this.r; 
		}
		
		return resultado;
	}
	
	public Integer getSoma() {
		
		Integer soma = 0;
		
		for(int i = 1; i < this.n +1; i++) {
			soma += this.a0 + (i - 1) * this.r;
		}
		
		return soma;
	}
	
}
