
public class HelloWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Word and I love Java!!!!");
				
		// Test of Albero_m_ario
		System.out.println();
		System.out.println("Test Albero_m_ario");
		Albero_m_ario albero = new Albero_m_ario(3);
		System.out.println("Creazione albero");
		System.out.println("Numero di nodi: " + albero.getNumNodi());
		// Radice Livello 0
		albero.insRacide(1);
		// Livello 1
		albero.addNodo(1, 2, 0);
		albero.addNodo(1, 3, 1);
		albero.addNodo(1, 4, 2);
		// Livello 2
		albero.addNodo(2, 5, 0);
		albero.addNodo(2, 6, 1);
		albero.addNodo(4, 7, 0);
		albero.addNodo(4, 8, 2);
		// Livello 4
		albero.addNodo(5, 9, 1);
		albero.addNodo(5, 10, 2);
		albero.addNodo(7, 11, 0);
		albero.addNodo(7, 12, 1);
		// Livello 5
		albero.addNodo(12, 13, 1);
		
		
		System.out.print("Visita Anticipata: ");
		albero.visitaAnticipata();
		System.out.println("");
		System.out.print("Visita Posticipata: ");
		albero.visitaPosticipata();
		System.out.println("");
		System.out.print("Visita Simmetrica: ");
		albero.visitaSimmetrica();
		System.out.println("");
		System.out.print("Visita per Livelli: ");
		albero.visitaPerLivelli();
		System.out.println("");
		System.out.print("Numero di nodi:" + albero.getNumNodi());
		System.out.println("");
		System.out.print("Numero di livelli: " + albero.getAltezza());
		System.out.println("");
		System.out.println("Ricerca nodo per chiave ");
		Nodo_m_ario nodo = albero.findNodo(3);
		if (nodo != null) {
			System.out.println("Chiave: " + nodo.getChiave());
			if (nodo.getPadre() != null) {
				System.out.println("Padre: " + nodo.getPadre().getChiave());
			}
			System.out.println("Figli: " + nodo.getNunFigli());
			String dash = "";
			if (nodo.getNunFigli() > 0) {
				int pos = 0;
				for(Nodo_m_ario temp : nodo.getFigli()) {
					if (temp != null) {
						System.out.print(dash + pos + ":" + temp.getChiave());
						dash = " - ";
					}
					pos += 1;
				}
			}
		} else {
			System.out.println("Nodo non presente");
		}
		System.out.println("");
		System.out.print("Visita Anticipata: ");
		albero.visitaAnticipata();
	}
}
