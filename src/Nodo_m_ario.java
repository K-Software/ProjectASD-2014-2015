/**
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class Nodo_m_ario {

	// Fields
	
	/**
	 * 
	 */
	private int chiave;
	
	/**
	 * 
	 */
	private Nodo_m_ario[] figli;
	
	// Constructors
	
	/**
	 * ...
	 * 
	 * @param val 
	 */
	public Nodo_m_ario(int val, int grado) {
		chiave = val;
		figli = new Nodo_m_ario[grado];
	}
	
	// Methods
}
