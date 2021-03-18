package it.polito.tdp.alien;

import java.util.Set;

public class WordEnhanced {
	
	private AlienWord alienWord;
	private Set<String> translation;
	
	public WordEnhanced(AlienWord alienWord, Set<String> translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public AlienWord getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(AlienWord alienWord) {
		this.alienWord = alienWord;
	}

	public Set<String> getTranslation() {
		return translation;
	}

	public void setTranslation(Set<String> translation) {
		this.translation = translation;
	}

	public String toString() {
		String elenco = this.getAlienWord()+":\n";
		for(String s: this.getTranslation()) {
			elenco+=" "+s+"\n";
		}
		return elenco;
	}
	
	
}
