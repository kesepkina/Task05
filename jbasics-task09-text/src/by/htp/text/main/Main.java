package by.htp.text.main;

public class Main {

	public static void main(String[] args) {

		Text text1 = new Text();

		text1.addToTitle(new Word("Tongue-twisters").firstLetterToUpperCase()).addToTitle(new Word("for"))
				.addToTitle(new Word("you"));

		text1.addSentence(new Sentence().add(new Word("eddie").firstLetterToUpperCase()).add(new Word("edited"))
				.add(new Word("it")).add(new PunctuationMark(".")))
				.addSentence(new Sentence().add(new Word("willie's").firstLetterToUpperCase()).add(new Word("really"))
						.add(new Word("weary")).add(new PunctuationMark(".")))
				.addSentence(new Sentence().add(new Word("which").firstLetterToUpperCase()).add(new Word("witch"))
						.add(new Word("is")).add(new Word("which")).add(new PunctuationMark("?")))
				.addSentence(new Sentence().add(new Word("good").firstLetterToUpperCase()).add(new Word("blood"))
						.add(new PunctuationMark(",")).add(new Word("bad")).add(new Word("blood"))
						.add(new PunctuationMark(".")));

		System.out.println(text1.getTextWithTitle());

	}

}
