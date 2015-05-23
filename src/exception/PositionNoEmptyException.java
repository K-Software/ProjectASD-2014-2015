package exception;

/**
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class PositionNoEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 269219572622282739L;

	public String getMessage() {
		return "Exception - Position is not empt";
	}
}
