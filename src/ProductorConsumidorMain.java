/**
 * Clase principal del algoritmo Productor-Consumidor.
 *
 * @author <a href=”http:\\eugeniaperez.es”>Eugenia Pérez Martínez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class ProductorConsumidorMain {

	/**
	 * Punto de entrada de la aplicación
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
