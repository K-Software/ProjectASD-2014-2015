/**
 * Albero di chiave intero
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class Albero_m_ario {

	// Fields
	
	/**
	 * Grado dell'albero
	 */
	private int grado;
	
	/**
	 * Radice dell'albero
	 */
	private Nodo_m_ario radice;
	
	/**
	 * Numero dei nodi presenti nell'albero
	 */
	private int numNodi;
	
	// Constructors
	
	/**
	 * ...
	 * 
	 * @param m Grado dell'albero. 
	 */
	public Albero_m_ario(int m) {
		grado = m;
	}
	
	// Methods
	
	/**
	 * ...
	 * 
	 * @param chiave
	 */
	public void insRacide(int chiave) {
		radice = new Nodo_m_ario(chiave, grado);
	}
	
	/**
	 * ...
	 * 
	 * @param chiave Chiave della nuova radice
	 * @param posizione Posizione da attribuire alla vecchia chiave
	 */
	public void insNuovaRadice(int chiave, int posizione) {
		// TODO ...
		Nodo_m_ario oldRadice = radice;
		radice = new Nodo_m_ario(chiave, grado);
		radice.addFiglio(oldRadice, posizione);
		numNodi += 1;
	}
	
	/**
	 * ... 
	 * 
	 * @return Restituisce la radice dell'albero
	 */
	public Nodo_m_ario getRadice() {
		return radice;
	}
	
	/**
	 * Restituisci il numero dei nodi totali presente nell'albero
	 * 
	 * @return Numero totale dei nodi
	 */
	public int getNumNodi() {
		return numNodi;
	}
}
