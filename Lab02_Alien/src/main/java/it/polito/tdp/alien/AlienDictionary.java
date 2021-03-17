package it.polito.tdp.alien;

import java.util.HashSet;
import java.util.Set;

public class AlienDictionary {

	private Set<WordEnhanced> dizionario;

	public AlienDictionary() {
		super();
		this.dizionario = new HashSet<>();
	}
	
	public WordEnhanced findWord(String alienWord) {
		for(WordEnhanced w: dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				return w;
			}
		}
		return null;
	}
	
	public Set<String> generaLista(String[] array) {
		HashSet<String> lista = new HashSet<>();
		for(int i=1; i<array.length; i++) {
			lista.add(array[i]);
		}
		return lista;
	}
	
	public void addWord(String alienWord, Set<String> translation) {
		WordEnhanced w = findWord(alienWord);
		if(w != null)
			w.setTranslation(translation);
		else {
			w = new WordEnhanced(alienWord, translation);
			dizionario.add(w);
		}
			
	}
	
	public Set<String> translateWord(String alienWord) {
		WordEnhanced w = findWord(alienWord);
		if(w==null)
			return null;
		else
			return w.getTranslation();
	}
	
	public String printTranslation(Set<String> lista) {
		String elenco = "";
		for(String s: lista) {
			elenco+=s+"\n";
		}
		
		return elenco;
	}
	
	public void reset() {
		this.dizionario.clear();
	}
	
}
