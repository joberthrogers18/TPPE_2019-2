package testes.contribuintes;
import static org.junit.Assert.*;

import org.junit.Test;

import app.CadastroContribuintes;
import app.Contribuinte;

public class TesteCadastroContribuintes {

	@Test
	public void testCadastroContribuinte() {
		CadastroContribuintes cad = CadastroContribuintes.obterCadastro();
		assertNotNull(cad);
		assertEquals(0, cad.getNumContribuintesCadastrados());
		
		Contribuinte c = Contribuinte.obterContribuinte("Andre");
		assertNotNull(c);
		
		assertTrue(cad.cadastrar(c));
		assertEquals(1, cad.getNumContribuintesCadastrados());
	}
	
	
	

}
