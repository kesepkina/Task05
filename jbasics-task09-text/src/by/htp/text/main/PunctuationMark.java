package by.htp.text.main;

public class PunctuationMark implements PartOfSentence {

	private String punctuation;

	public PunctuationMark(String punctuation) {
		this.punctuation = punctuation;
	}

	public String getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(String punctuation) {
		this.punctuation = punctuation;
	}

	@Override
	public String content() {
		return punctuation;
	}

}
