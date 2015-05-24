package exception;

/**
 * Eccezione da lanciare per indicare che la posizione é fuori dall'insieme dei
 * valori consentiti.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class PositionOutOfBoundException extends Exception {

	private static final long serialVersionUID = -3325251484459701619L;
	
	public String getMessage() {
		return "Exception - Position out of bounds";
	}
}
