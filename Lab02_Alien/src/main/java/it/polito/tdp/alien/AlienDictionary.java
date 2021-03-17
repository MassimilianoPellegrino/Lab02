package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dizionario;

	public AlienDictionary(List<Word> dizionario) {
		super();
		this.dizionario = new LinkedList<>();
	}
	
	public Word findWord(String alienWord) {
		Word parola = null;
		for(Word w: dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				parola = w;
				break;
			}
		}
		return parola;
	}
	
	public void addWord(String alienWord, String translation) {
		Word w = findWord(alienWord);
		if(w != null)
			w.setTranslation(translation);
		else {
			w = new Word(alienWord, translation);
			dizionario.add(w);
		}
			
	}
	
	public String translateWord(String alienWord) {
		Word w = findWord(alienWord);
		if(w==null)
			return null;
		else
			return w.getTranslation();
	}
	
}
