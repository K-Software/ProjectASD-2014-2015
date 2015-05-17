
public class HelloWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Word and I love Java!!!!");
		
		// Test of Nodo_m_ario
		System.out.println("Test Nodo_m_ario");
		Nodo_m_ario nodo = new Nodo_m_ario(1, 7);
		System.out.println("Chiave: " + nodo.getChiave());
		System.out.println("Num figli:" + nodo.getNunFigli());
		
		Nodo_m_ario figlio = new Nodo_m_ario(2, 7);
		nodo.addFiglio(figlio, 5);
		
		System.out.println("Num figli:" + nodo.getNunFigli());
		String dash = "";
		if (nodo.getNunFigli() > 0) {
			int pos = 0;
			for(Nodo_m_ario temp : nodo.getFigli()) {
				if (temp != null) {
					System.out.print(dash + temp.getChiave() + ":" + pos);
					dash = " - ";
				}
				pos += 1;
			}
		}
		
		// Test of Albero_m_ario
		System.out.println();
		System.out.println("Test Albero_m_ario");
		Albero_m_ario albero = new Albero_m_ario(2);
		System.out.println("Numero di nodi: " + albero.getNumNodi());
		albero.insRacide(1);
		System.out.println("Numero di nodi: " + albero.getNumNodi());
		System.out.println("Radice: " + albero.getRadice().getChiave());
		System.out.println("Ins nodo: " + albero.addNodo(1, 2, 0));
		System.out.println("Numero di nodi: " + albero.getNumNodi());
		System.out.println("Ins nodo: " + albero.addNodo(1, 3, 1));
		System.out.println("Numero di nodi: " + albero.getNumNodi());
		System.out.print("Visita Anticipata: ");
		albero.visitaAnticipata();
		System.out.println("");
		System.out.print("Visita Posticipata: ");
		albero.visitaPosticipata();
		System.out.println("");
		System.out.print("Visita Simmetrica: ");
		albero.visitaSimmetrica();
	}
}
