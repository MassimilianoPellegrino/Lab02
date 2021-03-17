package it.polito.tdp.alien;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordEnhanced {
	
	private String alienWord;
	private Set<String> translation;
	
	public WordEnhanced(String alienWord, Set<String> translation) {
		super();
		this.alienWord = alienWord;
		this.translation = new HashSet<>();
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public Set<String> getTranslation() {
		return translation;
	}

	public void setTranslation(Set<String> translation) {
		this.translation = translation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
}
