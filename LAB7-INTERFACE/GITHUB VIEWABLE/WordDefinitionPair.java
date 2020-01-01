public class WordDefinitionPair {
	private String word;
	private String definition;
	
	public WordDefinitionPair(String word, String definition) {
		this.word = word;
		this.definition = definition;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		else if(obj == null || obj.getClass() != obj.getClass()) {
			return false;
		}
		WordDefinitionPair other = (WordDefinitionPair) obj;
		return 
			word.equals(other.getWord()) && 
			definition.equals(other.getDefinition());
	}
	
	@Override
	public String toString() {
		return word + " " + definition;
	}
}
