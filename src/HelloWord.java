
public class HelloWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Word and I love Java!!!!");
		
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
	}
}
