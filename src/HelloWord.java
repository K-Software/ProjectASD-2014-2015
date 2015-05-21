
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
		System.out.print("Visita Anticipata Iterativa: ");
		albero.visitaAnticipataIterativa();
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

		// Inserisco una nuova radice
		albero.insNuovaRadice(0, 2);
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
		
		// Aggiungo il sottoalbero
		// Sottoalbero
		Albero_m_ario sottoAlbero = new Albero_m_ario(3);
		// Radice Livello 0
		sottoAlbero.insRacide(14);
		// Livello 1
		sottoAlbero.addNodo(14, 15, 0);
		sottoAlbero.addNodo(14, 16, 1);
		sottoAlbero.addNodo(14, 17, 2);
		// Livello 2
		sottoAlbero.addNodo(16, 18, 2);
		// Livello 3
		sottoAlbero.addNodo(18, 19, 0);
		albero.addSubAlbero(12, 2, sottoAlbero);
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
	}
}
