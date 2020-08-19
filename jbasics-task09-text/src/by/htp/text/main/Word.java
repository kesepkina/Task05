package by.htp.text.main;

public class Word implements PartOfSentence {

	private String word;

	public Word(String word) {
		super();
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String content() {
		return word;
	}
	
	public Word firstLetterToUpperCase() {
		word.toLowerCase();
		
		String firstChar = word.charAt(0) + "";
		firstChar = firstChar.toUpperCase();
		
		word = firstChar + word.substring(1, word.length());
		return this;
	}

}
