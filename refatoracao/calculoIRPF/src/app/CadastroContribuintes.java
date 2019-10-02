package app;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CadastroContribuintes {
	
	private List<Contribuinte> cadastro;

	private CadastroContribuintes() {
		cadastro = new LinkedList<Contribuinte>();
	}
	
	public static CadastroContribuintes obterCadastro() {
		CadastroContribuintes cad = new CadastroContribuintes();
		return cad;
	}

	public int getNumContribuintesCadastrados() {
		return cadastro.size();
	}

	public boolean cadastrar(Contribuinte c) {
		boolean resposta = cadastro.add(c);
		return resposta;
	}

	public Contribuinte pesquisar(String nome) {
		Contribuinte resposta = null;
		for (Contribuinte c : cadastro) {
			if (c.getNome().equals(nome))
				resposta = c;
		}
		return resposta;
	}

	public boolean remover(Contribuinte d) {
		Iterator<Contribuinte> it = cadastro.iterator();
		
		int deletar = -1;
		while (it.hasNext()) {
			Contribuinte c = it.next();
			if (c.equals(d))
				deletar = cadastro.indexOf(c);
		}
		
		boolean resposta = false;
		if (deletar != -1) {
			cadastro.remove(deletar);
			resposta = true;
		}
		
		return resposta;
	}
	
}
