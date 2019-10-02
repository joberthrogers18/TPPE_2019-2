package testes.contribuintes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TestePesquisarContribuinte {
	
	CadastroContribuintes cad;
	Contribuinte c = Contribuinte.obterContribuinte("Andre");
	
	@Before
	public void setup() {
		cad = CadastroContribuintes.obterCadastro();
		cad.cadastrar(c);
	}
	
	
	@Test
	public void testPesquisaContribuintes() {
		Contribuinte c = cad.pesquisar("Andre");
		assertNotNull(c); 
		assertEquals("Andre", c.getNome());
	}

}
