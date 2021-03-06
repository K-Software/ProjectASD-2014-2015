import exception.NodoNotExistException;
import exception.PositionNoEmptyException;
import exception.PositionOutOfBoundException;

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
	
	/**
	 * Padre del nodo.
	 */
	private Nodo_m_ario padre;
	
	/**
	 * Figli del nodo.
	 */
	private Nodo_m_ario[] figli;
	
	/**
	 * Identifica se é una radice.
	 */
	private boolean radice;
	
	// Constructors
	
	/**
	 * Crea un nodo figlio di padre di chiave val e di grado grado.
	 * 
	 * @param padre Nodo padre
	 * @param val Valore da attribuire alla chiave
	 * @param m Grado del nodo 
	 */
	public Nodo_m_ario(Nodo_m_ario padre, int val, int m) {
		chiave = val;
		grado = m;
		this.padre = padre;
		figli = new Nodo_m_ario[grado];
		radice = false;
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
	 * Metodo per controllare se un nodo é una radice di un albero e quindi ha 
	 * dei figli.
	 * 
	 * @return Restituisce true se il nodo ha dei figli
	 */
	public boolean isRadice() {
		return radice;
	}
	
	/**
	 * Metodo per aggiungere un figlio al nodo in una determinata posizione
	 * 
	 * @param figlio Nodo da aggiungere come figlio
	 * @param posizione Posizione in cui aggiungere il figlio
	 * @throws PositionOutOfBoundException Posizione non corretta
	 * @throws PositionNoEmptyException Posizione occupata
	 */
	public void addFiglio(Nodo_m_ario figlio, int posizione) 
			throws PositionNoEmptyException, PositionOutOfBoundException {
		if (posizione >= 0 && posizione < grado) {
			if (figli[posizione] == null) {
				figli[posizione] = figlio;
				radice = true;
			} else {
				throw new PositionNoEmptyException();
			}
		} else {
			throw new PositionOutOfBoundException();
		}
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
	 * Metodo per assegnare il padre del nodo
	 * 
	 * @param padre Padre del nodo
	 */
	public void setPadre(Nodo_m_ario padre) {
		this.padre = padre;
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
