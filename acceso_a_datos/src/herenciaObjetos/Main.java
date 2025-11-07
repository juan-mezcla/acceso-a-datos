/**
 * 
 */
package herenciaObjetos;

/**
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hijos h=new Hijos(1,"perro");
		Padre ph=h;
		
		h.saludo();
		ph.saludo();
		h.saludoHijo();
	}

}
