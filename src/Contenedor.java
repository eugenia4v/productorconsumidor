/**
 * Clase Contenedor: su principal finalidad es almacenar datos producidos por el
 * Productor, y que finalmente ser�n recogidos por el Consumidor.
 *
 * @author <a href=�http:\\eugeniaperez.es�>Eugenia P�rez Mart�nez</a>
 * @mailto eugenia.perez.martinez@gmail.com
 */
public class Contenedor {

	/**
	 * El dato que ser� almacenado o extra�do.
	 */
	private int dato;

	/**
	 * Ser� True si existe alg�n dato esperando a ser extra�do por el Consumidor.
	 */
	private boolean existeDato = false;

	/**
	 * M�todo utilizado por el Productor para introducir un valor en el Contenedor.
	 *
	 * @param valor A introducir en el contenedor.
	 */
	public synchronized void put(int valor) {
		while (existeDato) {
			try {
				// espera a que el Consumidor extra�ga
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
	 * M�todo que es utilizado por el Consumidor para extraer un valor del Contenedor.
	 * Debe existir al menos un valor para hacerlo. 
	 * @ Return el dato extra�do por el Consumidor.
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
		this.dato = 0; //Se simula que se vac�a el dato
		System.out.println("Consumidor. get: " + valorConsumido);

		// Se notifica de que el Consumidor ha extra�do el dato
		notifyAll();
		return valorConsumido;
	}

}
