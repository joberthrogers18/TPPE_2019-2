package testes;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import testes.Triangulo;

@RunWith(Parameterized.class)
public class TesteTriangulo {
	
	private Integer a;
	private Integer b;
	private Integer c;
	private Boolean resultadoEsperado;
	
	public TesteTriangulo(Integer a, Integer b, Integer c, Boolean resultadoEsperado){
		this.a = a;
		this.b = b;
		this.c = c;
		this.resultadoEsperado = resultadoEsperado;
	}
	
	@Parameters
	public static Iterable getParameter() {
		Object[][] params = new Object[][] {
			{10, 14, 8, true},
			{1, 100, 5, false},
			{5, 10, 9, true},
			{300, 10, 50, false}
		};
		
		return Arrays.asList(params);
	}
	
	
	@Test
	public void testEhTriangulo() {
		
		Triangulo triangulo = new Triangulo(this.a, this.b, this.c);
		
		
		assertEquals(this.resultadoEsperado, triangulo.ehTriangulo());
	}

}
