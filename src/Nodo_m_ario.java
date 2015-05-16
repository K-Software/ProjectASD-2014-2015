/**
 * TODO ...
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class Nodo_m_ario {

	// Fields
	
	/**
	 * TODO ...
	 */
	private int chiave;
	
	/**
	 * TODO ...
	 */
	private Nodo_m_ario[] figli;
	
	// Constructors
	
	/**
	 * TODO ...
	 * 
	 * @param val 
	 */
	public Nodo_m_ario(int val, int grado) {
		chiave = val;
		figli = new Nodo_m_ario[grado];
	}
	
	// Methods
	
	/**
	 * TODO ...
	 * 
	 * @param figlio
	 */
	public void addFiglio(Nodo_m_ario figlio, int posizione) {
		figli[posizione] = figlio;
	}
	
	/**
	 * TODO ...
	 * 
	 * @return
	 */
	public int getChiave() {
		return chiave;
	}
	
	/**
	 * TODO ...
	 * 
	 * @param c
	 */
	public void setChiave(int c) {
		chiave = c;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNunFigli() {
		int numFigli = 0;
		for (Nodo_m_ario figlio : figli) {
			// TODO ...
		}
		return numFigli;
	}
}
