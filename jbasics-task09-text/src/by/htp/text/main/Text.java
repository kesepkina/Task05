package by.htp.text.main;

import java.util.ArrayList;
import java.util.List;

public class Text {

	private List<PartOfSentence> title;
	private List<Sentence> text;

	public Text() {
		text = new ArrayList<Sentence>();
		title = new ArrayList<PartOfSentence>();
	}

	public Text(ArrayList<Sentence> text, ArrayList<PartOfSentence> title) {
		this.text = new ArrayList<Sentence>();
		this.text.addAll(text);
		this.title = new ArrayList<PartOfSentence>();
		this.title.addAll(title);
	}

	public List<Sentence> getText() {
		return text;
	}

	public void setText(List<Sentence> text) {
		this.text = text;
	}

	public void setText(int index, Sentence sentence) {
		text.add(index, sentence);
	}

	public List<PartOfSentence> getTitle() {
		return title;
	}

	public void setTitle(List<PartOfSentence> title) {
		this.title = title;
	}

	public Text addSentence(Sentence sentence) {
		text.add(sentence);
		return this;
	}
	
	public Text addToTitle(PartOfSentence part) {
		title.add(part);
		return this;
	}

	public String getFormattedText() {
		String formattedText = new String();
		for (Sentence sentence : text) {
			formattedText += sentence.getFormattedSentence();
		}

		return formattedText;
	}
	
	public String getFormattedTitle() {
		String title = new String();
		for (PartOfSentence part : this.title) {
			if (part instanceof PunctuationMark) {
				title = title.trim();
			}
			title += part.content() + " ";
		}
		
		return title.trim();
	}
	
	public String getTextWithTitle() {
		String text = new String();
		text += "                         \"" + this.getFormattedTitle() + "\"\n";
		text += this.getFormattedText();
		
		return text;
	}

}
