/**
 * Consumidor - Recoge valores que previamente ha almacenado el Productor
 * 
 * @author <a href=�http:\\eugeniaperez.es�>Eugenia P�rez Mart�nez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class Consumidor extends Thread {

	/**
	 * El contenedor "compartido" utilizado para sacar y consumir variables.
	 */
	private Contenedor contenedor;

	/**
	 * El n�mero de valores distintos que ser�n introducidos en el contenedor.
	 */
	private static final int ITERACIONES = 10;

	/**
	 * Constructor.
	 *
	 * @param c Contenedor que ser� utilizado por el Consumidor.
	 */
	public Consumidor(Contenedor c) {
		contenedor = c;
	}

	/**
	 * Consume (saca o extrae) un n�mero entero del Contenedor y se duerme durante medio segundo.
	 */
	@Override
	public void run() {
		int valor;
		for (int i = 1; i <= Consumidor.ITERACIONES; i++) {
			valor = contenedor.get();
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
}
