package exception;

/**
 * <h1>PositionOutOfBoundException.java</h1>
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class PositionOutOfBoundException extends Exception {

	private static final long serialVersionUID = -3325251484459701619L;

	public String getMessage() {
		return "Exception - Position out of bound";
	}
}
