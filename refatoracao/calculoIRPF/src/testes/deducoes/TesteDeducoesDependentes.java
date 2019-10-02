package testes.deducoes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TesteDeducoesDependentes {

	private CadastroContribuintes cad;

	@Before
	public void setup() {
		Contribuinte c = Contribuinte.obterContribuinte("Andre");
		cad = CadastroContribuintes.obterCadastro();
		cad.cadastrar(c);
	}
	
	@Test
	public void testDeducaoUmDependente() {
		Contribuinte c = cad.pesquisar("Andre"); 
		boolean resposta = c.cadastrarDependente("Miguel", 9, 3, 2019);
		assertTrue(resposta);
		assertEquals(189.59f, c.getTotalDeducoes(), 0.0f);
	}
	
	@Test
	public void testCadastroDoisDependentes() {
		Contribuinte c = cad.pesquisar("Andre");
		boolean resposta = c.cadastrarDependente("Miguel", 9, 3, 2019);
		assertTrue(resposta);
		resposta = c.cadastrarDependente("Maria", 15, 05, 2018);
		assertTrue(resposta);
		assertEquals(379.18f, c.getTotalDeducoes(), 0.0f);
	}
	
	@Test
	public void testCadastroTresDependentes() {
		Contribuinte c = cad.pesquisar("Andre");
		boolean resposta  = c.cadastrarDependente("Miguel", 9, 3, 2019);
		assertTrue(resposta);
		resposta = c.cadastrarDependente("Maria", 15, 05, 2018);
		assertTrue(resposta);
		resposta = c.cadastrarDependente("Carlos", 16, 11, 2017);
		assertTrue(resposta);
		assertEquals(568.77, c.getTotalDeducoes(), 0.01f);
	}

}
