package testes.baseDeCalculo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Contribuinte;

public class BaseDeCalculoTeste {

	private Contribuinte c;

	@Before
	public void setup() {
		c = Contribuinte.obterContribuinte("Andre");
	}
	
	@Test
	public void testBaseDeCalculo1() {
		//1 rendimento tributavel, 1 deducao simples
		c.cadastrarRendimento("Salario", 10000, true);
		c.cadastrarRendimento("Bolsa de Pesquisa", 2000, false);
		
		c.criarDeducao("Contribuicao previdenciaria", 1000);
		
		assertEquals(1000f, c.getTotalDeducoes(), 0f);
		assertEquals(9000f, c.calcularBase(), 0f);
	}
	
	@Test 
	public void testBaseDeCalculo2() {
		//1 rendimento tributavel, 1 dependente, 1 deducao simples
		c.cadastrarRendimento("Salario", 10000, true);
		c.cadastrarDependente("Carlos", 30, 3, 2019);
		c.criarDeducao("Contribuição Previdenciaria", 500);
		
		assertEquals(689.59f, c.getTotalDeducoes(), 0.01f);
		assertEquals(9310.41f, c.calcularBase(), 0f);
	}
	
	@Test 
	public void testBaseDeCalculo3() {
		//2 rendimento tributavel, 2 dependentes, 1 deducao simples
		c.cadastrarRendimento("Salario", 4000, true);
		c.cadastrarRendimento("Aluguel", 500, true);
		
		c.cadastrarDependente("Carlos", 21, 11, 2016);
		c.cadastrarDependente("Daniel", 2, 6, 2018);
		
		c.criarDeducao("Contribuição Previdenciária", 300);
		
		assertEquals(679.18f, c.getTotalDeducoes(), 0.001f);
		assertEquals(3820.82f, c.calcularBase(), 0.001f);
	}
}
