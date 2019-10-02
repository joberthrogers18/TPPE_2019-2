package app;

import java.util.LinkedList;
import java.util.List;

public class Contribuinte {

	public String nome;
	private List<Rendimento> rendimentos;
	private Deducao[] deducoes;
	public CadastroDependente cadDep = new CadastroDependente(new String[0]);
	public int[] diaNascDeps = new int[0];
	public int[] mesNascDeps = new int[0];
	public int[] anoNascDeps = new int[0];
	public float baseDeCalculo;

	private Contribuinte() {
		rendimentos = new LinkedList<Rendimento>();
		deducoes = new Deducao[0];
	}
	
	public Contribuinte(String nome) {
		this();
		this.nome = nome;
	}

	public static Contribuinte obterContribuinte(String nome) {
		Contribuinte c = new Contribuinte(nome);
		return c;
	}

	public String getNome() {
		return nome;
	}

	public boolean cadastrarRendimento(String nomeRendimento, 
										float valor, 
										boolean ehTributavel) {
		Rendimento r = Rendimento.obterRendimento(nomeRendimento, valor, ehTributavel);
		boolean resposta = rendimentos.add(r);
		return resposta;
	}

	public float getTotalRendimentos() {
		float resposta = 0; 
		for (int i=0; i < rendimentos.size(); i++) {
			Rendimento r = rendimentos.get(i);
			if (r.ehTributavel()) {
				resposta = resposta + r.getValor();
			}
		}
		return resposta;
	}

	public boolean criarDeducao(String descricao, float valor) {
		Deducao d = new Deducao(descricao, valor);
		
		//adicionar nova deducao ao vetor
		//variavel que informa se adicao de deducao teve sucesso
		boolean adicao = false;
		
		//criar posicao no vetor para receber a nova deducao
		int numDeducoes = deducoes.length;
		Deducao[] temp = new Deducao[numDeducoes + 1];
		for (int i=0; i < numDeducoes; i++) {
			temp[i] = deducoes[i];
		}
		
		//adicao da deducao no vetor temporario
		temp[numDeducoes] = d; 
		
		//atualizacao do vetor de deducoes
		deducoes = temp;
		
		//verificacao da insercao da deducao no vetor deducoes
		if (deducoes[numDeducoes] == d)
			adicao = true;
		
		return adicao;
	}

	public float getTotalDeducoes() {
		float resposta = 0; 
		int numDeducoesIntegrais = deducoes.length;
		
		for (int i=0; i < numDeducoesIntegrais; i++) {
			Deducao d = deducoes[i];
			resposta += d.getValor();
		}
		
		float totalDeducoesDependentes = 0;
		for (int i=0; i < cadDep.dependentes.length; i++) {
			totalDeducoesDependentes += 189.59f;
		}
		
		resposta += totalDeducoesDependentes;
		
		return resposta;
	}

	public boolean cadastrarDependente(DadosDependente dadosDependente) {
		return new CadastrarDependente(this, dadosDependente).computar(); 
	}

	public float calcularBase() {
		this.baseDeCalculo =  getTotalRendimentos() - getTotalDeducoes();
		return baseDeCalculo;
	}
}