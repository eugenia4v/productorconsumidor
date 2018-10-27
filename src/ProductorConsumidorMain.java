/**
 * Clase principal del algoritmo Productor-Consumidor.
 *
 * @author <a href=�http:\\eugeniaperez.es�>Eugenia P�rez Mart�nez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class ProductorConsumidorMain {

	/**
	 * Punto de entrada de la aplicaci�n
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Contenedor c = new Contenedor();
		
		Productor productor = new Productor(c);
		Consumidor consumidor = new Consumidor(c);

		productor.start();
		consumidor.start();
	}
}
