

public class CalcularValor {

	Acesso _source;
	int quantidadeHoras;
	int quantidadeMinutos;
	float valorTotal;
	
	CalcularValor(Acesso source){
		this.valorTotal = 0;
		this.quantidadeMinutos = 0;
		_source = source;
		quantidadeHoras = 0;
		quantidadeMinutos = 0;
	}
	
	float computar() { 
		
		if (verificarhoraSaidaEhMaior() && verificarMinutoSaidaEhMaior()) {
			quantidadeMinutos = calcularMinutos();
			quantidadeHoras = clacularHora();
		}
		else {
			quantidadeMinutos = _source.minutosSaida + (60 - _source.minutosEntrada);
			quantidadeHoras = clacularHora() - 1;
		}
		
		final float valorHoras = quantidadeHoras * _source.VALOR_HORA;
		final float valorFracoes =  (float) Math.ceil(quantidadeMinutos / 15.0) * _source.VALOR_FRACAO;
		
		valorTotal = 0;
		valorTotal += valorHoras; 
		valorTotal += valorFracoes;		
		
		if (quantidadeHoras >=9)
			return _source.VALOR_DIARIA;
		else 
			return valorTotal;
		
	}

	private int calcularMinutos() {
		return _source.minutosSaida - _source.minutosEntrada;
	}

	private boolean verificarMinutoSaidaEhMaior() {
		return _source.minutosSaida >= _source.minutosEntrada;
	}

	private int clacularHora() {
		return _source.horaSaida - _source.horaEntrada;
	}

	private boolean verificarhoraSaidaEhMaior() {
		return _source.horaSaida >= _source.horaEntrada;
	}
	
}
