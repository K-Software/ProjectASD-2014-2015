/**
 * Albero di chiavi chiavi intere e di arietá m
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
	private int numNodi = 0;
	
	// Constructors
	
	/**
	 * Crea un albero di grado m
	 * 
	 * @param m Grado dell'albero. 
	 */
	public Albero_m_ario(int m) {
		grado = m;
	}
	
	// Methods
	
	/**
	 * Metodo per effettuare una visita anticipata del nodo
	 * 
	 * @param padre
	 */
	private void visitaAnticipata(Nodo_m_ario padre) {
		if (padre != null) {
			System.out.print(padre.getChiave() + " ");
			for (Nodo_m_ario figlio: padre.getFigli()) {
				visitaAnticipata(figlio);
			}
		}
	}
	
	/**
	 * 
	 * @param padre
	 */
	private void visitaPosticipata(Nodo_m_ario padre) {
		if (padre != null) {
			for (Nodo_m_ario figlio: padre.getFigli()) {
				visitaPosticipata(figlio);
			}
			System.out.print(padre.getChiave());
		}
	}
	
	/**
	 * 
	 * @param padre
	 */
	private void visitaSimmetrica(Nodo_m_ario padre) {
		// TODO ...
	}
	
	/**
	 * Metodo per inserire la radice nel albero
	 * 
	 * @param chiave Valore da attribuire alla radice
	 */
	public void insRacide(int chiave) {
		radice = new Nodo_m_ario(chiave, grado);
		numNodi += 1;
	}

	/**
	 * Metodo che restituisce il Nodo_m_ario della radice dell'albero 
	 * 
	 * @return Restituisce la radice dell'albero
	 */
	public Nodo_m_ario getRadice() {
		return radice;
	}

	/**
	 * ...
	 * 
	 * @param chiave Chiave della nuova radice
	 * @param posizione Posizione da attribuire alla vecchia chiave
	 */
	public void insNuovaRadice(int chiave, int posizione) {
		// TODO ...
	}
		
	/**
	 * Restituisci il numero dei nodi totali presente nell'albero.
	 * 
	 * @return Numero totale dei nodi
	 */
	public int getNumNodi() {
		return numNodi;
	}
	
	/**
	 * Ricerca un nodo per chiave tramite una visita anticipata.
	 * 
	 * @param radice Radice dell'albero su cui effettuare la ricerca
	 * @param chiave Chiave del nodo da ricercare
	 * @return Restituisce il nodo contenente la chiave
	 */
	public Nodo_m_ario findNodo(Nodo_m_ario radice, int chiave) {
		if (radice.getChiave() == chiave) {
			return radice;
		} else {
			for (Nodo_m_ario figlio: radice.getFigli()) {
				return findNodo(figlio, chiave);
			}
		}
		return null;
	}
	
	/**
	 * Metedo per aggiungere ad un nodo padre un nuovo figlio.
	 * 
	 * @param chiavePadre Chiave del padre a cui aggiungere il figlio
	 * @param chiaveFiglio Chiave del nuovo figlio
	 * @param posizione Posizione del nuovo filgio
	 */
	public boolean addNodo(int chiavePadre, int chiaveFiglio, int posizione) {
		boolean result = false;
		Nodo_m_ario padre = findNodo(radice, chiavePadre);
		if (padre != null) {
			Nodo_m_ario	newFiglio = new Nodo_m_ario(chiaveFiglio, grado);
			padre.addFiglio(newFiglio, posizione);
			result = true;
		}
		return result;
	}

	/**
	 * Metodo per effettuare la visita anticipata dell'albero.
	 */
	public void visitaAnticipata() {
		visitaAnticipata(radice);
	}
	
	/**
	 * Metodo per effettuare la visita posticipata dell'albero.
	 */
	public void visitaPosticipata() {
		visitaPosticipata(radice);
	}
	
	/**
	 * Metodo per effettuare la visita simmetrica dell'albero.
	 */
	public void visitaSimmetrica() {
		visitaSimmetrica(radice);
	}
}
