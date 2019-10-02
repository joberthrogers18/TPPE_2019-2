package app;

import java.util.LinkedList;
import java.util.List;

public class Contribuinte {

	private String nome;
	private List<Rendimento> rendimentos;
	private Deducao[] deducoes;
	private CadastroDependente cadDep = new CadastroDependente(new String[0]);
	private int[] diaNascDeps = new int[0];
	private int[] mesNascDeps = new int[0];
	private int[] anoNascDeps = new int[0];
	private float baseDeCalculo;

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
		
		//cadastrar um dependente = alocar cada parametro desse metodo em seu vetor especifico.
		int numDependentes = cadDep.dependentes.length;
		
		//Alocar o nome do dependente
		String[] tempDependentes = new String[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempDependentes[i] = cadDep.dependentes[i];
		}
		tempDependentes[numDependentes] = nome;
		
		//atualizar o vetor de dependentes
		cadDep.dependentes = tempDependentes;
		
		//verificar alocacao de dependente
		boolean alocacaoNomeDependente = false;
		if (cadDep.dependentes[numDependentes].equals(nome))
			alocacaoNomeDependente = true;
		
		
		
		//Alocar o dia de nascimento do dependente
		int tempDiaNascDep[] = new int[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempDiaNascDep[i] = diaNascDeps[i];
		}
		tempDiaNascDep[numDependentes] = dadosDependente.diaNascimento;
		
		//atualizar o vetor de dias de nascimento dos dependentes
		diaNascDeps = tempDiaNascDep;
		
		//verificar a alocacao do dia de nascimento do dependente
		boolean alocacaoDiaNascDep = false;
		if (diaNascDeps[numDependentes] == dadosDependente.diaNascimento) 
			alocacaoDiaNascDep = true;
		
		
		
		//Alocar o mes de nascimento do dependente
		int tempMesNascDep[] = new int[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempMesNascDep[i] = mesNascDeps[i];
		}
		tempMesNascDep[numDependentes] = dadosDependente.mesNascimento;
		
		//atualizar o vetor de mes de nascimento dos dependentes
		mesNascDeps = tempMesNascDep; 
		
		//verificar a alocacao do dia de nascimento do dependente
		boolean alocacaoMesNascDep = false; 
		if (mesNascDeps[numDependentes] == dadosDependente.mesNascimento)
			alocacaoMesNascDep = true;
			
		
		
		//alocar o ano de nascimento do dependente
		int tempAnoNascDep[] = new int[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempAnoNascDep[i] = anoNascDeps[i];
		}
		tempAnoNascDep[numDependentes] = dadosDependente.anoNascimento;
		
		//atualizar o vetor de ano de nascimento dos dependentes
		anoNascDeps = tempAnoNascDep;
		
		//verificar a alocacao do ano de nascimento do dependente
		boolean alocacaoAnoNascDep = false;
		if (anoNascDeps[numDependentes] == dadosDependente.anoNascimento) 
			alocacaoAnoNascDep = true;
		
		
		return alocacaoNomeDependente && alocacaoDiaNascDep && alocacaoMesNascDep && alocacaoAnoNascDep;
	}

	public float calcularBase() {
		this.baseDeCalculo =  getTotalRendimentos() - getTotalDeducoes();
		return baseDeCalculo;
	}
}