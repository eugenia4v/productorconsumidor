/**
 * 
 * Clase Productor. Producte y almcena números enteros (del 1 al 10), espera por
 * el consumidor, el cual deberá consumir un dato antes de que el productor
 * vuelva a almacenar el siguiente.
 *
 * @author <a href=”http:\\eugeniaperez.es”>Eugenia Pérez Martínez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class Productor extends Thread {

	/**
	 * El contenedor "compartido" utilizado para almacenar variables.
	 */
	private Contenedor contenedor;

	/**
	 * El número de valores diferentes introducidos en el Contenedor.
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
	 * Produce un número entero, lo almacena en el contenedor y se duerme medio
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
