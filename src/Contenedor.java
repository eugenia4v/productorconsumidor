/**
 * Clase Contenedor: su principal finalidad es almacenar datos producidos por el
 * Productor, y que finalmente serán recogidos por el Consumidor.
 *
 * @author <a href=”http:\\eugeniaperez.es”>Eugenia Pérez Martínez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class Contenedor {

	/**
	 * El dato que será almacenado o extraído.
	 */
	private int dato;

	/**
	 * Será True si existe algún dato esperando a ser extraído por el Consumidor.
	 */
	private boolean existeDato = false;

	/**
	 * Método utilizado por el Productor para introducir un valor en el Contenedor.
	 *
	 * @param valor A introducir en el contenedor.
	 */
	public synchronized void put(int valor) {
		while (existeDato) {
			try {
				// espera a que el Consumidor extraíga
				// el valor que tiene almacenado.
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}

		// Cuando llega a este punto el dato ya ha sido consumido
		//El productor puede almacenar el dato
		this.dato = valor;
		existeDato = true;
		System.out.println("Productor. put: " + valor);
		// Se notifica que el Productor ha puesto un valor
		notifyAll();
	}

	/**
	 * Método que es utilizado por el Consumidor para extraer un valor del Contenedor.
	 * Debe existir al menos un valor para hacerlo. 
	 * @ Return el dato extraído por el Consumidor.
	 */
	public synchronized int get() {
		while (!existeDato) {
			try {
				// espera a que el Productor almacene un dato dentro.
				wait();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}

		//Cuando llega a este punto es el que el dato ha sido almacenado
		//El consumidor puede extraer el dato
		existeDato = false;
		int valorConsumido = this.dato;
		this.dato = 0; //Se simula que se vacía el dato
		System.out.println("Consumidor. get: " + valorConsumido);

		// Se notifica de que el Consumidor ha extraído el dato
		notifyAll();
		return valorConsumido;
	}

}
