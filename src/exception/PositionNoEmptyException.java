package exception;

/**
 * Eccezione da lanciare per indicare che la popsizione in cui si sta provando
 * ad inserire il nuovo figlio non é vuota.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class PositionNoEmptyException extends Exception {

	private static final long serialVersionUID = 269219572622282739L;

	public String getMessage() {
		return "Exception - Position is not empty";
	}
}
