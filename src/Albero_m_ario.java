import java.util.LinkedList;

/**
 * Albero di chiavi intere e di arietá m
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
	 * Metodo per effettuare la visita anticipata dell'albero.  
	 * 
	 * @param radice Radice dell'albero
	 */
	private void visitaAnticipata(Nodo_m_ario radice) {
		if (radice != null) {
			System.out.print(radice.getChiave() + " ");
			for (Nodo_m_ario figlio: radice.getFigli()) {
				visitaAnticipata(figlio);
			}
		}
	}
	
	/**
	 * Metodo per effettuare la visita posticipata dell'albero. 
	 * 
	 * @param radice Radice dell'albero
	 */
	private void visitaPosticipata(Nodo_m_ario radice) {
		if (radice != null) {
			for (Nodo_m_ario figlio: radice.getFigli()) {
				visitaPosticipata(figlio);
			}
			System.out.print(radice.getChiave() + " ");
		}
	}
	
	/**
	 * Metodo per effettuare la visita simmetrica dell'albero.
	 * 
	 * @param radice Radice dell'albero
	 */
	private void visitaSimmetrica(Nodo_m_ario radice) {
		if (radice != null) {
			for (int i = 0; i < radice.getGrado()/2; i++) {
				visitaSimmetrica(radice.getFigli()[i]);
			}
			System.out.print(radice.getChiave() + " ");
			for (int i = (radice.getGrado()/2); i < radice.getGrado(); i++) {
				visitaSimmetrica(radice.getFigli()[i]);
			}
		}
	}
	
	/**
	 * Ricerca un nodo per chiave tramite una visita anticipata.
	 * 
	 * @param radice Radice dell'albero su cui effettuare la ricerca
	 * @param chiave Chiave del nodo da ricercare
	 * @return Restituisce il nodo contenente la chiave
	 */
	private Nodo_m_ario findNodo(Nodo_m_ario radice, int chiave) {
		if (radice != null) {
			if (radice.getChiave() == chiave) {
				return radice;
			} else {
				Nodo_m_ario nodo = null;
				for (Nodo_m_ario figlio: radice.getFigli()) {
					nodo = findNodo(figlio, chiave);
					if (nodo != null) {
						return nodo;
					}
				}
				return nodo;
			}
		}
		return null;
	}
	
	/**
	 * Metodo per inserire la radice nel albero
	 * 
	 * @param chiave Valore da attribuire alla radice
	 */
	public void insRacide(int chiave) {
		radice = new Nodo_m_ario(null, chiave, grado);
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
	 * TODO ...
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
	 * Metedo per aggiungere ad un nodo padre un nuovo figlio.
	 * 
	 * @param chiavePadre Chiave del padre a cui aggiungere il figlio
	 * @param chiaveFiglio Chiave del nuovo figlio
	 * @param posizione Posizione del nuovo filgio
	 * @return Restituisce true se inserimento ha avuto esito positivo, false
	 * altrimenti
	 */
	public boolean addNodo(int chiavePadre, int chiaveFiglio, int posizione) {
		boolean result = false;
		Nodo_m_ario padre = findNodo(radice, chiavePadre);
		if (padre != null) {
			Nodo_m_ario	newFiglio = new Nodo_m_ario(padre, chiaveFiglio, grado);
			padre.addFiglio(newFiglio, posizione);
			numNodi += 1;
			result = true;
		}
		return result;
	}

	/**
	 * Metodo per recuperare il primo nodo con la chiave indicata come parametro.
	 * 
	 * @param chiave Chiave da ricercare
	 * @return Restituisce il nodo che ha la chi
	 */
	public Nodo_m_ario findNodo(int chiave) {
		return findNodo(radice, chiave);
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
	
	/**
	 * Metodo per effettuare la visita per livello dell'albero.
	 */
	public void visitaPerLivelli() {
		Coda queue = new Coda();
		queue.enqueue(radice);
		while(!queue.isEmpty()) {
			Nodo_m_ario tempNodo = queue.dequeue();
			System.out.print(tempNodo.getChiave() + " ");
			for (Nodo_m_ario figlio: tempNodo.getFigli()) {
				if (figlio != null) {
					queue.enqueue(figlio);
				}
			}
		}
	}
	
	/**
	 * 
	 * @author Simone Cappabianca - Mat: 5423306
	 *
	 */
	private class Coda {
		
		// Fields
		
		/**
		 * Lista
		 */
		LinkedList<Nodo_m_ario> list;
		
		// Constructors
		
		/**
		 * Costruttore della coda.
		 */
		public Coda() {
			list = new LinkedList<Nodo_m_ario>();
		}
		
		// Methods
		
		/**
		 * Metodo per determinare se la coda é vuota.
		 * 
		 * @return Ritorna true se la coda é vuota, false altrimenti
		 */
		public boolean isEmpty() {
			return list.isEmpty();
		}
		
		/**
		 * Metodo per aggiungere un elemento in fondo alla coda.
		 * 
		 * @param element Elemento da aggiungere
		 */
		public void put(Nodo_m_ario element) {
			list.add(element);
		}
		
		/**
		 * Metodo per aggiungere un elemento in fondo alla coda.
		 * 
		 * @param element Elemento da aggiungere
		 */
		public void enqueue(Nodo_m_ario element) {
			list.add(element);
		}
		
		/**
		 * Metodo per estrarre il primo elemento della coda.
		 * 
		 * @return Restituisce l'elemento estratto
		 */
		public Nodo_m_ario get() {
			return list.remove();
		}
		
		/**
		 * Metodo per estrarre il primo elemento della coda.
		 * 
		 * @return Restituisce l'elemento estratto
		 */
		public Nodo_m_ario dequeue() {
			return list.remove();
		}
	}
}
