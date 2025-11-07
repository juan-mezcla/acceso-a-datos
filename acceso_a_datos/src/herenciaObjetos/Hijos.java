/**
 * 
 */
package herenciaObjetos;

/**
 * 
 */
public class Hijos implements Padre{
	private int i=0;
	private String text;
	
	
	/**
	 * 
	 */
	public Hijos(int i, String text) {
		this.i=i;
		this.text=text;
	}
	@Override
	public void saludo() {		
		System.out.println("soy el hijo");
	}
	
//	public void saludoHijo() {
//		System.out.println(this.i+" saludo :"+this.text);
//	}

}
