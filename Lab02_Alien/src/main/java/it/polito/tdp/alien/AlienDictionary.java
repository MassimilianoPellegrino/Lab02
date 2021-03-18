package it.polito.tdp.alien;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AlienDictionary {

	private Set<WordEnhanced> dizionario;

	public AlienDictionary() {
		super();
		this.dizionario = new HashSet<>();
	}
	
	public List<WordEnhanced> findWord(String alienWord) {
		List<WordEnhanced> set = new LinkedList<>();
		for(WordEnhanced w: dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				set.add(w);
			}
		}
		if(set.size()!=0)
			return set;
		else
			return null;
	}
	
	public Set<String> generaLista(String[] array) {
		Set<String> lista = new LinkedHashSet<>();
		for(int i=1; i<array.length; i++) {
			lista.add(array[i]);
		}
		return lista;
	}
	
	public void addWord(String alienWord, Set<String> translation) {
		WordEnhanced w;
		try{
			w = findWord(alienWord).get(0);
			w.setTranslation(translation);
		}catch(NullPointerException e) {
			AlienWord aw = new AlienWord(alienWord);
			w = new WordEnhanced(aw, translation);
			dizionario.add(w);
		}
		
			
	}
	
	/*public Set<String> translateWord(String alienWord) {
		WordEnhanced w = findWord(alienWord);
		if(w==null)
			return null;
		else
			return w.getTranslation();
	}*/
	
	public String printTranslation(String aw) {
		String trad= "";
		List<WordEnhanced> we = findWord(aw);
		for(WordEnhanced w: we)
			trad+=w.toString();
		
		return trad;
	}
	
	public void reset() {
		this.dizionario.clear();
	}
	
}
