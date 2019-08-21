package teste;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import teste.PA;

@RunWith(Parameterized.class)
public class TestePA {

	Integer a0;
	Integer r;
	Integer n;
	int[] result;
	Integer soma;
	
	public TestePA(Integer a0,Integer r, Integer n, InstanciaParams params) {
		this.a0 = a0;
		this.r = r;
		this.n = n;
		this.result = params.getPa();
		this.soma = params.getSoma();
	}
	
	// Usando testes parametrizados para retornar 
	// varios resultados
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] parametros = new Object[][] {
			{1, 2, 5, new InstanciaParams( new int[] {1,3,5,7,9}, 25) },
			{0 ,3, 4, new InstanciaParams( new int[] {0,3,6,9}, 18)},
			{2,1,6, new InstanciaParams( new int[] {2,3,4,5,6,7}, 27)}
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void test() {
		
		PA pa = new PA(a0, r, n);
		
		assertArrayEquals(this.result, pa.getTermos());
		assertEquals(soma, pa.getSoma());
	}

}
