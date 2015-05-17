/**
 * Questa classe rappresenta un nodo di chiave intera di grado m.
 * 
 * @author Simone Cappabianca - Mat: 5423306
 *
 */
public class Nodo_m_ario {

	// Fields
	
	/**
	 * Chiave del nodo.
	 */
	private int chiave;
	
	/**
	 * Grado del nodo.
	 */
	private int grado;
	
	private Nodo_m_ario padre;
	
	/**
	 * Figli del nodo
	 */
	private Nodo_m_ario[] figli;
	
	// Constructors
	
	/**
	 * Crea un nodo di chiave val e di grado grado
	 * 
	 * @param val Valore da attribuire alla chiave
	 * @param m Grado del nodo 
	 */
	public Nodo_m_ario(Nodo_m_ario padre, int val, int m) {
		chiave = val;
		grado = m;
		this.padre = padre;
		figli = new Nodo_m_ario[grado];
	}
	
	// Methods
	
	/**
	 * Metodo che restituisce la chiave del nodo
	 * 
	 * @return Restituisce la chiave del nodo
	 */
	public int getChiave() {
		return chiave;
	}
	
	/**
	 * Metodo per settare la chiave di nodo
	 * 
	 * @param val Valore da attribuire alla chiave del nodo
	 */
	public void setChiave(int val) {
		chiave = val;
	}
	
	/**
	 * Metodo che restituisce il grado del nodo.
	 * 
	 * @return Restituisce il grado del nodo
	 */
	public int getGrado() {
		return grado;
	}
	
	/**
	 * Metodo per aggiungere un figlio al nodo in una determinata posizione
	 * 
	 * @param figlio Nodo da aggiungere come figlio
	 * @param posizione Posizione in cui aggiungere il figlio
	 */
	public void addFiglio(Nodo_m_ario figlio, int posizione) {
		figli[posizione] = figlio;
	}
	
	/**
	 * Metodo per recuperare il padre del nodo.
	 * 
	 * @return Restituisce il padre del nodo
	 */
	public Nodo_m_ario getPadre() {
		return padre;
	}
	
	/**
	 * Metodo per recuperare i figli del nodo
	 * 
	 * @return Restituisce i figli del nodo
	 */
	public Nodo_m_ario[] getFigli() {
		return figli;
	}
	
	/**
	 * Metodo per recuperare il numero di figlio del nodo
	 * 
	 * @return Restituisce il numero di figli del nodo
	 */
	public int getNunFigli() {
		int numFigli = 0;
		for (Nodo_m_ario figlio : figli) {
			if (figlio != null) {
				numFigli += 1;
			}
		}
		return numFigli;
	}
}
