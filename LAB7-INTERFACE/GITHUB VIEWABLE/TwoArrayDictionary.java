/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {
	
	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary
	
	String[] words;
	String[] definitions;
	
	public TwoArrayDictionary() {
		words = new String[MAX_CAPACITY];
		definitions = new String[MAX_CAPACITY];
	}
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	private int indexOfWord(String word) {
		boolean wordExists = false;
		int i = 0;
		while(!wordExists && i < count) {
			if(words[i].equals(word)) {
				wordExists = true;
			}
			i ++;
		}
		return wordExists ? i - 1 : -1;
	}

	@Override
	public String getDefinition(String word) 
			throws WordNotInDictionaryException {
		
		int indexOfWord = indexOfWord(word);
		if(indexOfWord < 0) {
			throw new WordNotInDictionaryException(word);
		}
		else {
			return definitions[indexOfWord];
		}
	}

	@Override
	public void insertEntry(String word, String definition) 
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		if(count == MAX_CAPACITY) {
			throw new DictionaryFullException("Maximum capacity is " + MAX_CAPACITY);
		}
		else {
			int indexOfWord = indexOfWord(word);
			if(indexOfWord >= 0) {
				throw new WordAlreadyExistsInDictionaryException(word);
			}
			else {
				words[count] = word;
				definitions[count] = definition;
				count ++;
			}
		}
	}

	@Override
	public String removeWord(String word)
		throws WordNotInDictionaryException {
		int indexOfWord = indexOfWord(word);
		if(indexOfWord < 0) {
			throw new WordNotInDictionaryException(word);
		}
		else {
			String defRemoved = definitions[indexOfWord];
			// shift all slots to the right of 'word' one position to the left
			for(int i = indexOfWord + 1; i < count; i ++) {
				words[i - 1] = words[i];
				definitions[i - 1] = definitions[i]; 
			}
			count --;
			words[count] = null;
			definitions[count] = null;
			return defRemoved;
		}
	}

	@Override
	public String[] getWords() {
		WordDefinitionPair[] entries = getEntries();
		String[] words = new String[entries.length];
		for(int i = 0; i < entries.length; i ++) {
			words[i] = entries[i].getWord();
		}
		return words;
	}

	@Override
	public String[] getDefinitions() {
		WordDefinitionPair[] entries = getEntries();
		String[] definitions = new String[entries.length];
		for(int i = 0; i < entries.length; i ++) {
			definitions[i] = entries[i].getDefinition();
		}
		return definitions;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] entries = new WordDefinitionPair[count];
		for(int i = 0; i < count; i ++) {
			entries[i] = new WordDefinitionPair(words[i], definitions[i]);
		}
		return entries;
	}
	
	@Override
	public String toString() {
		String s = "";
		WordDefinitionPair[] entries = getEntries();
		for(int i = 0; i < entries.length; i ++) {
			s += entries[i].toString();
			if(i < entries.length - 1) {
				s += "\n";
			}
		}
		return s;
	}
}
