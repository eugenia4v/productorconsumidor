/**
 * 
 * Clase Productor. Producte y almcena n�meros enteros (del 1 al 10), espera por
 * el consumidor, el cual deber� consumir un dato antes de que el productor
 * vuelva a almacenar el siguiente.
 *
 * @author <a href=�http:\\eugeniaperez.es�>Eugenia P�rez Mart�nez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class Productor extends Thread {

	/**
	 * El contenedor "compartido" utilizado para almacenar variables.
	 */
	private Contenedor contenedor;

	/**
	 * El n�mero de valores diferentes introducidos en el Contenedor.
	 */
	private static final int ITERACIONES = 10;

	/**
	 * Constructor.
	 *
	 * @param c Contenedor utilizado por el Productor
	 */
	public Productor(Contenedor c) {
		contenedor = c;
	}

	/**
	 * Produce un n�mero entero, lo almacena en el contenedor y se duerme medio
	 * segundo.
	 */
	@Override
	public void run() {
		for (int i = 1; i <= Productor.ITERACIONES; i++) {
			contenedor.put(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
