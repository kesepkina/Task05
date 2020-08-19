package by.htp.text.main;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

	private List<PartOfSentence> sentence;

	public Sentence() {
		sentence = new ArrayList<PartOfSentence>();
	}

	public Sentence(List<PartOfSentence> sentence) {
		this.sentence = new ArrayList<PartOfSentence>();
		this.sentence.addAll(sentence);
	}

	public List<PartOfSentence> getSentence() {
		return sentence;
	}

	public void setSentence(List<PartOfSentence> sentence) {
		this.sentence = sentence;
	}

	public void setSentence(int index, PartOfSentence part) {
		sentence.add(index, part);
	}

	public Sentence add(PartOfSentence part) {
		sentence.add(part);
		return this;
	}

	public String getFormattedSentence() {
		String formattedSentence = new String();
		for (PartOfSentence word : this.sentence) {
			if (word instanceof PunctuationMark) {
				formattedSentence = formattedSentence.trim();
			}
			formattedSentence += word.content() + " ";
		}
		return formattedSentence;
	}

}
