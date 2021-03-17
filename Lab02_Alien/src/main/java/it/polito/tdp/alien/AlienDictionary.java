package it.polito.tdp.alien;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class AlienDictionary {

	private Set<WordEnhanced> dizionario;

	public AlienDictionary() {
		super();
		this.dizionario = new HashSet<>();
	}
	
	public WordEnhanced findWord(AlienWord alienWord) {
		for(WordEnhanced w: dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				return w;
			}
		}
		return null;
	}
	
	public Set<String> generaLista(String[] array) {
		HashSet<String> lista = new LinkedHashSet<>();
		for(int i=1; i<array.length; i++) {
			lista.add(array[i]);
		}
		return lista;
	}
	
	public AlienWord generaParola(String alienWord) {
		AlienWord aw = new AlienWord(alienWord);
		WordEnhanced w = findWord(aw);
		if(w!=null)
			return w.getAlienWord();
		else
			return aw;
	}
	
	public void addWord(AlienWord alienWord, Set<String> translation) {
		WordEnhanced w = findWord(alienWord);
		if(w != null)
			w.setTranslation(translation);
		else {
			w = new WordEnhanced(alienWord, translation);
			dizionario.add(w);
		}
			
	}
	
	public Set<String> translateWord(AlienWord alienWord) {
		WordEnhanced w = findWord(alienWord);
		if(w==null)
			return null;
		else
			return w.getTranslation();
	}
	
	public String printTranslation(AlienWord aw) {
		WordEnhanced we = findWord(aw);
		String elenco = "";
		for(String s: we.getTranslation()) {
			elenco+=s+"\n";
		}
		
		return elenco;
	}
	
	public void reset() {
		this.dizionario.clear();
	}
	
}
