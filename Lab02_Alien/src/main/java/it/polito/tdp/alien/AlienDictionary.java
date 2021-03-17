package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	private List<WordEnhanced> dizionario;

	public AlienDictionary() {
		super();
		this.dizionario = new LinkedList<>();
	}
	
	public WordEnhanced findWord(String alienWord) {
		for(WordEnhanced w: dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				return w;
			}
		}
		return null;
	}
	
	public List<String> generaLista(String[] array) {
		LinkedList<String> lista = new LinkedList<>();
		for(int i=1; i<array.length; i++) {
			lista.add(array[i]);
		}
		return lista;
	}
	
	public void addWord(String alienWord, List<String> translation) {
		WordEnhanced w = findWord(alienWord);
		if(w != null)
			w.setTranslation(translation);
		else {
			w = new WordEnhanced(alienWord, translation);
			dizionario.add(w);
		}
			
	}
	
	public List<String> translateWord(String alienWord) {
		WordEnhanced w = findWord(alienWord);
		if(w==null)
			return null;
		else
			return w.getTranslation();
	}
	
	public String printTranslation(List<String> lista) {
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
