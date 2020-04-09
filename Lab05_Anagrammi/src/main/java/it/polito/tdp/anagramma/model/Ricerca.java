package it.polito.tdp.anagramma.model;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagramma.DAO.AnagrammaDAO;

public class Ricerca {
	
	private List<String> soluzione ;

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso.
	 * @param parola parola da anagrammare
	 * @return elenco di tutti gli anagrammi della parola data
	 */
	public List<String>anagrammi(String parola){
		parola=parola.toUpperCase();
		this.soluzione=new ArrayList<>();
		List<Character> disponibili =new ArrayList<>();
		for(int i=0;i<parola.length();i++) {
			disponibili.add(parola.charAt(i));
		}
		
		cerca("",0,disponibili);
		
		
		return soluzione;
	}
	private void cerca(String parziale,int livello,List<Character>disponibili) {
		if(disponibili.size()==0) {//livello==parola.lenght
			//caso terminale
			this.soluzione.add(parziale);
		}
		//caso normale
		//provare ad aggiungere a 'parziale' tutti i caratteri presenti tra 
		// i 'disponibili'
		for(Character ch : disponibili) {
			String tentativo = parziale + ch;
			List<Character>rimanenti=new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			cerca(tentativo,livello+1,rimanenti);
		}
	}
	public boolean isCorretto(String anagramma) {
		AnagrammaDAO a=new AnagrammaDAO();
		return a.isCorretto(anagramma);
	}

}

/*
Dato di partenza: parola da anagrammare, di lunghezza N
Soluzione parziale: una parte dell'anagramma già costruito (i primi caratteri).
Livello: numero di lettere di cui è composta la soluzione parziale.
Soluzione finale: soluzione di lunghezza N -> caso terminale
Caso terminale: salvare la soluzione trovate
Generazione delle nuove soluzioni: provare a aggiungere una lettera, scegliendola
tra quelle che non sono ancora state utilizzate (nella soluzione parziale).
*/