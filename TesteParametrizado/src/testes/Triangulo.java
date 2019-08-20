package testes;

public class Triangulo {
	
	private Integer a, b, c;
	
	// Sendo a e b os catetos e c a hipotenusa de um triangulo temos:
	
	Triangulo(Integer a, Integer b, Integer c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Integer getA (){
		return this.a;
	}
	
	public Integer getB () {
		return this.b;
	}
	
	public Integer getC () {
		return this.c;
	}
	
	public Boolean ehTriangulo(){
		
		if ( Math.abs(this.b - this.c) < this.a && this.a < this.b + this.c ) {
			return true;
		}
		else if( Math.abs(this.a - this.c) < this.b && this.b < this.a + this.c ) {
			return true;
		}
		else if( Math.abs(this.b - this.a) < this.c && this.c < this.a + this.b ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
