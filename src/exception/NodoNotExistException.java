package exception;

/**
 * Eccezione da lanciare quando non esiste nessun nodo che contiene una 
 * determinata chiave.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class NodoNotExistException extends Exception {

	private static final long serialVersionUID = -5064131987791631453L;

	public String getMessage() {
		return "Exception - Node not exist";
	}
}
