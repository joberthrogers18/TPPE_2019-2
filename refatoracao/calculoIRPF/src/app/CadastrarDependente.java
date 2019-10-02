package app;

public class CadastrarDependente {

	private Contribuinte source;
	private DadosDependente dadosDependente;
	
	CadastrarDependente(Contribuinte source, DadosDependente dadosDependente){
		this.source = source;
		this.dadosDependente = dadosDependente;
	}
	
	public boolean computar() {
		//cadastrar um dependente = alocar cada parametro desse metodo em seu vetor especifico.
		int numDependentes = source.cadDep.dependentes.length;
		
		//Alocar o nome do dependente
		String[] tempDependentes = new String[numDependentes + 1];
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
		int tempDiaNascDep[] = new int[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempDiaNascDep[i] = source.diaNascDeps[i];
		}
		tempDiaNascDep[numDependentes] = dadosDependente.diaNascimento;
		
		//atualizar o vetor de dias de nascimento dos dependentes
		source.diaNascDeps = tempDiaNascDep;
		
		//verificar a alocacao do dia de nascimento do dependente
		boolean alocacaoDiaNascDep = false;
		if (source.diaNascDeps[numDependentes] == dadosDependente.diaNascimento) 
			alocacaoDiaNascDep = true;
		
		
		
		//Alocar o mes de nascimento do dependente
		int tempMesNascDep[] = new int[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempMesNascDep[i] = source.mesNascDeps[i];
		}
		tempMesNascDep[numDependentes] = dadosDependente.mesNascimento;
		
		//atualizar o vetor de mes de nascimento dos dependentes
		source.mesNascDeps = tempMesNascDep; 
		
		//verificar a alocacao do dia de nascimento do dependente
		boolean alocacaoMesNascDep = false; 
		if (source.mesNascDeps[numDependentes] == dadosDependente.mesNascimento)
			alocacaoMesNascDep = true;
			
		
		
		//alocar o ano de nascimento do dependente
		int tempAnoNascDep[] = new int[numDependentes + 1];
		for (int i=0; i<numDependentes; i++) {
			tempAnoNascDep[i] = source.anoNascDeps[i];
		}
		tempAnoNascDep[numDependentes] = dadosDependente.anoNascimento;
		
		//atualizar o vetor de ano de nascimento dos dependentes
		source.anoNascDeps = tempAnoNascDep;
		
		//verificar a alocacao do ano de nascimento do dependente
		boolean alocacaoAnoNascDep = false;
		if (source.anoNascDeps[numDependentes] == dadosDependente.anoNascimento) 
			alocacaoAnoNascDep = true;
		
		
		return alocacaoNomeDependente && alocacaoDiaNascDep && alocacaoMesNascDep && alocacaoAnoNascDep;
	}
	
}
