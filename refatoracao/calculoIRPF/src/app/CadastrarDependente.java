package app;

public class CadastrarDependente {

	private Contribuinte source;
	private DadosDependente dadosDependente;
	private int numDependentes;
	
	CadastrarDependente(Contribuinte source, DadosDependente dadosDependente){
		this.source = source;
		this.dadosDependente = dadosDependente;
		
		//cadastrar um dependente = alocar cada parametro desse metodo em seu vetor especifico.
		this.numDependentes = source.cadDep.dependentes.length;
		
	}
	
	public boolean computar() {
		
		//Alocar o nome do dependente
		String[] tempDependentes = new String[adicionandoNumeroDeDependetes(numDependentes)];
		for (int i=0; i<numDependentes; i++) {
			tempDependentes[i] = source.cadDep.dependentes[i];
		}
		tempDependentes[numDependentes] = source.nome;
		
		//atualizar o vetor de dependentes
		source.cadDep.dependentes = tempDependentes;
		
		//verificar alocacao de dependente
		boolean alocacaoNomeDependente = false;
		if (source.cadDep.dependentes[numDependentes].equals(source.nome))
			alocacaoNomeDependente = true;
		
		//Alocar o dia de nascimento do dependente
		int tempDiaNascDep[] = new int[adicionandoNumeroDeDependetes(numDependentes)];
		tempDiaNascDep = gerarVetor(tempDiaNascDep, source.diaNascDeps);
		tempDiaNascDep[numDependentes] = dadosDependente.diaNascimento;
		
		//atualizar o vetor de dias de nascimento dos dependentes
		source.diaNascDeps = tempDiaNascDep;
		
		//verificar a alocacao do dia de nascimento do dependente
		boolean alocacaoDiaNascDep = false;
		alocacaoDiaNascDep = verificarAlocacao(source.diaNascDeps, dadosDependente.diaNascimento);
		
		//Alocar o mes de nascimento do dependente
		int tempMesNascDep[] = new int[adicionandoNumeroDeDependetes(numDependentes)];
		tempMesNascDep = gerarVetor(tempMesNascDep, source.mesNascDeps);
		tempMesNascDep[numDependentes] = dadosDependente.mesNascimento;
		
		//atualizar o vetor de mes de nascimento dos dependentes
		source.mesNascDeps = tempMesNascDep; 
		
		//verificar a alocacao do dia de nascimento do dependente
		boolean alocacaoMesNascDep = false;
		alocacaoMesNascDep = verificarAlocacao(source.mesNascDeps, dadosDependente.mesNascimento);
		
		
		//alocar o ano de nascimento do dependente
		int tempAnoNascDep[] = new int[adicionandoNumeroDeDependetes(numDependentes)];
		tempAnoNascDep = gerarVetor(tempAnoNascDep, source.anoNascDeps);
		tempAnoNascDep[numDependentes] = dadosDependente.anoNascimento;
		
		//atualizar o vetor de ano de nascimento dos dependentes
		source.anoNascDeps = tempAnoNascDep;
		
		//verificar a alocacao do ano de nascimento do dependente
		boolean alocacaoAnoNascDep = false;
		alocacaoAnoNascDep = verificarAlocacao(source.anoNascDeps, dadosDependente.anoNascimento);
		
		
		return alocacaoNomeDependente && alocacaoDiaNascDep && alocacaoMesNascDep && alocacaoAnoNascDep;
	}

	private boolean verificarAlocacao(int[] vetorAlocado, int dado) {
		boolean alocacao = false;
		
		if (vetorAlocado[numDependentes] == dado)
			alocacao = true;
		
		return alocacao;
	}

	private int adicionandoNumeroDeDependetes(int numDependentes) {
		return numDependentes + 1;
	}
	
	private int[] gerarVetor(int[] vetorAux, int[] vetorAdicionado) {
		
		
		for (int i=0; i<numDependentes; i++) {
			vetorAux[i] = vetorAdicionado[i];
		}
		
		return vetorAux;
	}
	
}
