package it.polito.tdp.alien;

public class AlienWord {
	
	private String alienWord;
	
	public AlienWord(String alienWord) {
		super();
		this.alienWord = alienWord;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
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
		if(obj instanceof String) {
			if(obj.equals(this.getAlienWord()))
				return true;
			else if(((String) obj).length()!= this.getAlienWord().length())
				return false;
			else {
				String s = this.getAlienWord();
				int conta = 0;
				for(int i=0; i<((String) obj).length(); i++) {
					char co = ((String) obj).charAt(i);
					char cs = s.charAt(i);
					if(co!='?' && co!=cs)
						return false;
					if(co=='?')
						conta++;
				}
				if(conta==1)
					return true;
				else
					return false;
			}	
		}else
			return false;
		
	}		
}
