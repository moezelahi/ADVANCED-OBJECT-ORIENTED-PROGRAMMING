/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {
	
	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;
	
	public OneArrayDictionary() {
		dict = new WordDefinitionPair[MAX_CAPACITY];
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
			if(dict[i].getWord().equals(word)) {
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
			return dict[indexOfWord].getDefinition();
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
				dict[count] = new WordDefinitionPair(word, definition);
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
			String defRemoved = dict[indexOfWord].getDefinition();
			// shift all slots to the right of 'word' one position to the left
			for(int i = indexOfWord + 1; i < count; i ++) {
				dict[i - 1] = dict[i]; 
			}
			count --;
			dict[count] = null;
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
			entries[i] = dict[i];
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
