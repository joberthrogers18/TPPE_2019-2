package testes.rendimentos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TesteCriacaoRendimentoTributavel {

	private CadastroContribuintes cad;
	private Contribuinte c;

	@Before
	public void setup() {
		cad = CadastroContribuintes.obterCadastro();
		c = Contribuinte.obterContribuinte("Andre");
		cad.cadastrar(c);
	}
	
	@Test
	public void testCriacaoUmRendimentoTributavel() {
		c = cad.pesquisar("Andre");
		boolean cadRend = c.cadastrarRendimento("Salario", 5000.0f, true);
		assertTrue(cadRend);
		assertEquals(5000.0f, c.getTotalRendimentos(), 0);
	}
	
	@Test
	public void testCriacaoDoisRendimentosTributaveis() {
		c = cad.pesquisar("Andre");
		boolean cadRend = c.cadastrarRendimento("Salario", 5000.0f, true);
		assertTrue(cadRend);
		assertEquals(5000.0f, c.getTotalRendimentos(), 0);
		cadRend = c.cadastrarRendimento("Aluguel", 3000.0f, true);
		assertTrue(cadRend);
		assertEquals(8000.0f, c.getTotalRendimentos(), 0);
	}
	
	

	@Test
	public void testCriarVariosRendimentos() {
		c = cad.pesquisar("Andre");
		boolean cadRend = c.cadastrarRendimento("Salario", 5000.0f, true);
		assertTrue(cadRend);
		assertEquals(5000.0f, c.getTotalRendimentos(), 0);
		cadRend = c.cadastrarRendimento("Aluguel", 3000.0f, true);
		assertTrue(cadRend);
		assertEquals(8000.0f, c.getTotalRendimentos(), 0);
		cadRend = c.cadastrarRendimento("Bolsa de pesquisa 1", 5000.0f, false);
		assertTrue(cadRend);
		assertEquals(8000.0f, c.getTotalRendimentos(), 0);
	}
}
