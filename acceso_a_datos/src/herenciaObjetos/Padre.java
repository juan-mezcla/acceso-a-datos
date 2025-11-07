/**
 * 
 */
package herenciaObjetos;

/**
 * 
 */
 abstract public interface Padre {
	public static final int i = 0;
	public static final String text = "hola";
	public default void saludo() {
		System.out.println("soy el la interfaz");
	}
	
	public default void saludoHijo() {
		System.out.println(this.i+" saludo :"+this.text);
	}

}
