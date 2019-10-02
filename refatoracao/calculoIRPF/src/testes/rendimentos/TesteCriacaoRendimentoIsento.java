package testes.rendimentos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TesteCriacaoRendimentoIsento {

	private CadastroContribuintes cad;
	private Contribuinte c;
	
	@Before
	public void setup() {
		cad = CadastroContribuintes.obterCadastro();
		c = Contribuinte.obterContribuinte("Andre");
		cad.cadastrar(c);
	}
	
	@Test
	public void testCriarRendimentoIsento() {
		c = cad.pesquisar("Andre");
		boolean cadRend = c.cadastrarRendimento("Bolsa de Pesquisa", 2000.0f, false);
		assertTrue(cadRend);
		assertEquals(0.0f, c.getTotalRendimentos(), 0.0f);
	}
	
	@Test 
	public void testCriarDoisRendimentosIsentos() {
		c = cad.pesquisar("Andre");
		boolean cadRend = c.cadastrarRendimento("Bolsa de pesquisa 1", 5000.0f, false);
		assertTrue(cadRend);
		assertEquals(0.0f, c.getTotalRendimentos(), 0);
		cadRend = c.cadastrarRendimento("Bolsa de pesquisa 2", 3000.0f, false);
		assertTrue(cadRend);
		assertEquals(0.0f, c.getTotalRendimentos(), 0);
	}

}
