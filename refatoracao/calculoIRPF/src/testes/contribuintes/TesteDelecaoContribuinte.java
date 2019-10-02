package testes.contribuintes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TesteDelecaoContribuinte {

	CadastroContribuintes cad; 
	Contribuinte c;
	
	@Before
	public void setup() {
		cad = CadastroContribuintes.obterCadastro();
		c = Contribuinte.obterContribuinte("Andre");
		cad.cadastrar(c);
	}
	@Test
	public void testDelecaoContribuinte() {
		assertEquals(1, cad.getNumContribuintesCadastrados());
		Contribuinte d = cad.pesquisar("Andre");
		assertNotNull(d);
		boolean delecao = cad.remover(d);
		assertTrue(delecao); 
	}

}
