import java.util.LinkedList;

import exception.NodoNotExistException;
import exception.PositionNoEmptyException;
import exception.PositionOutOfBoundException;

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
	 * Metodo per controllare che la posizione rispetti il grado dell'albero.
	 * 
	 * @param posizione Posizione da controllare
	 * @return Restituisce true se la posizione rispetta il grado dell'albero,
	 * false altrimenti.
	 */
	/*
	private boolean checkGrado(int posizione) {
		if (posizione >= 0 && posizione < grado) {
			return true;
		} else {
			return false;
		}
	}
	*/
	
	/**
	 * Metodo ricorsivo per effettuare la visita anticipata dell'albero.  
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
	 * Metodo ricorsivo per effettuare la visita posticipata dell'albero. 
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
	 * Metodo ricorsivo per effettuare la visita simmetrica dell'albero.
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
	 * Metodo per calcolare l'altezza dell'albero di radice il parametro radice.
	 * 
	 * @param radice Radice dell'albero di cui deve essere calcolata l'altezza
	 * @return Restituisce l'altezza dell'albero.
	 */
	private int getAltezza(Nodo_m_ario radice) {
		if (radice == null) {
			return 0;
		} else {
			int max = 0;
			for (Nodo_m_ario figlio: radice.getFigli()) {
				int numLiv = getAltezza(figlio);
				if ( numLiv > max) {
					max = numLiv; 
				}
			}
			return max + 1;
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
	 * Metodo per inserire una nuova radice all'albero trasformando albero 
	 * precedente un sottoalbero della nuova radice.
	 * 
	 * @param chiave Chiave della nuova radice
	 * @param posizione Posizione da attribuire alla vecchia chiave
	 * @throws PositionOutOfBoundException Posizione non corretta
	 * @throws PositionNoEmptyException Posizione occupata
	 */
	public void insNuovaRadice(int chiave, int posizione) throws PositionOutOfBoundException, PositionNoEmptyException{
		Nodo_m_ario figlio = radice;
		radice = new Nodo_m_ario(null, chiave, grado);
		figlio.setPadre(radice);
		radice.addFiglio(figlio, posizione);
		numNodi += 1;
	}
		
	/**
	 * Metodo per restituire il numero dei nodi totali presente nell'albero.
	 * 
	 * @return Restituisce numero dei nodi
	 */
	public int getNumNodi() {
		return numNodi;
	}
	
	/**
	 * Metodo per calcolare l'altezza dell'albero.
	 * 
	 *  @return Restituisce l'altezza dell'albero
	 */
	public int getAltezza() {
		return getAltezza(radice);
	}
	
	/**
	 * Metedo per aggiungere ad un nodo padre un nuovo figlio.
	 * 
	 * @param chiavePadre Chiave del padre a cui aggiungere il figlio
	 * @param chiaveFiglio Chiave del nuovo figlio
	 * @param posizione Posizione del nuovo filgio
	 * @return Restituisce true se inserimento ha avuto esito positivo, false
	 * altrimenti
	 * @throws PositionOutOfBoundException Posizione non corretta
	 * @throws PositionNoEmptyException Posizione occupata
	 */
	public boolean addNodo(int chiavePadre, int chiaveFiglio, int posizione) throws PositionOutOfBoundException, PositionNoEmptyException {
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
	 * Metodo per trasformare un albero sottoalbero di un determinato nodo. 
	 * 
	 * @param chiave Chiave del nodo in cui deve essere inserito il sottoalbro
	 * @param posizione Posizione in cui deve essere il sottoalbero
	 * @param subAlbero Albero che deve diventare sotto albero
	 * @return Restituisce true se l'inserimento é andato a buon fine, false 
	 * altrimenti
	 * @throws NodoNotExistException Nodo non presente all'interno dell'albero
	 * @throws PositionOutOfBoundException Posizione non corretta
	 * @throws PositionNoEmptyException Posizione occupata
	 */
	public Nodo_m_ario addSubAlbero(int chiave, int posizione, Albero_m_ario subAlbero) 
			throws NodoNotExistException, PositionNoEmptyException, PositionOutOfBoundException {
		Nodo_m_ario nodo = findNodo(chiave);
		if (nodo == null) {
			throw new NodoNotExistException();
		}
		nodo.addFiglio(subAlbero.getRadice(), posizione);
		numNodi += subAlbero.getNumNodi();
		return nodo;
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
	 * Metodo iterativo per effettuare la visita anticipata dell'albero.
	 */
	public void visitaAnticipataIterativa() {
		Pila stack = new Pila();
		stack.push(radice);
		while (!stack.isEmpty()) {
			Nodo_m_ario nodo = stack.pop();
			System.out.print(nodo.getChiave() + " ");
			for (int i = grado-1; i >= 0; i--) {
				if (nodo.getFigli()[i] != null) {
					stack.push(nodo.getFigli()[i]);
				}
			}
		}
	}
	
	/**
	 * Metodo per effettuare la visita posticipata dell'albero.
	 */
	public void visitaPosticipata() {
		visitaPosticipata(radice);
	}
	
	/**
	 * Metodo iterativo per effettuare le visita posticipata dell'albero.
	 */
	public void visitaPosticipataIterativa() {
		Pila stack = new Pila();
		stack.push(radice);
		while (!stack.isEmpty()) {
			Nodo_m_ario nodo = stack.pop();
			if (nodo.isRadice()) {
				stack.push(new Nodo_m_ario(null, nodo.getChiave(), nodo.getGrado()));
				for (int i = nodo.getGrado()-1; i >= 0; i--) {
					if (nodo.getFigli()[i] != null) {
						stack.push(nodo.getFigli()[i]);
					}
				}
			} else {
				System.out.print(nodo.getChiave() + " ");
			}
		}
	}
	
	/**
	 * Metodo per effettuare la visita simmetrica dell'albero.
	 */
	public void visitaSimmetrica() {
		visitaSimmetrica(radice);
	}
	
	/**
	 * Metodo iterativo per effettuare la visita simmetrica dell'albero.
	 */
	public void visitaSimmetricaIterativa() {
		Pila stack = new Pila();
		stack.push(radice);
		while (!stack.isEmpty()) {
			Nodo_m_ario nodo = stack.pop();
			if (nodo.isRadice()) {
				for (int i = nodo.getGrado()-1; i >= (nodo.getGrado()/2); i--) {
					if (nodo.getFigli()[i] != null) {
						stack.push(nodo.getFigli()[i]);
					}
				}
				stack.push(new Nodo_m_ario(null, nodo.getChiave(), nodo.getGrado()));
				for (int i = nodo.getGrado()/2-1; i >= 0 ; i--) {
					if (nodo.getFigli()[i] != null) {
						stack.push(nodo.getFigli()[i]);
					}
				}
			} else {
				System.out.print(nodo.getChiave() + " ");
			}
		}
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
	 * Coda di Nodo_m_ario.
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
	
	/**
	 * TODO ...
	 * 
	 * @author Simone Cappabianca - Mat: 5423306
	 *
	 */
	private class Pila {
		
		// Fields
		
		/**
		 * TODO ...
		 */
		LinkedList<Nodo_m_ario> list;
		
		// Constructors
		
		/**
		 * TODO ...
		 */
		public Pila() {
			list = new LinkedList<Nodo_m_ario>();
		}
		
		// Methods
		
		public boolean isEmpty() {
			return list.isEmpty();
		}
		
		/**
		 * TODO ...
		 * 
		 * @return
		 */
		public Nodo_m_ario pop() {
			return list.pop();
		}
		
		/**
		 * TODO ...
		 * 
		 * @return
		 */
		public void push(Nodo_m_ario element) {
			list.push(element);
		}
	}
}
