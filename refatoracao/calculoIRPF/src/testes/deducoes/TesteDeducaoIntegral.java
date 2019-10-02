package testes.deducoes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TesteDeducaoIntegral {

	private CadastroContribuintes cad;

	@Before
	public void setup() {
		Contribuinte c = Contribuinte.obterContribuinte("Andre");
		cad = CadastroContribuintes.obterCadastro();
		cad.cadastrar(c);
	}
	
	@Test
	public void testCriarUmaDeducaoIntegral() {
		Contribuinte c = cad.pesquisar("Andre");
		boolean resposta = c.criarDeducao("Plano de Saude", 300.0f);
		assertTrue(resposta);
		assertEquals(300.0f, c.getTotalDeducoes(), 0.0f);
	}
	
	@Test 
	public void testCriarDuasDeducoesIntegrais() {
		Contribuinte c = cad.pesquisar("Andre");
		boolean resposta = c.criarDeducao("ContribuicaoPrevidenciaria", 700.0f);
		assertTrue(resposta);
		assertEquals(700.0f, c.getTotalDeducoes(), 0.0f);
		resposta = c.criarDeducao("Plano de Saude", 300.0f);
		assertTrue(resposta);
		assertEquals(1000.0f, c.getTotalDeducoes(), 0.0f);
	}
}
