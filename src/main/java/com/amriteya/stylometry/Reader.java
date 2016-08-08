package com.amriteya.stylometry;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.emory.mathcs.nlp.common.util.IOUtils;
import edu.emory.mathcs.nlp.component.tokenizer.EnglishTokenizer;
import edu.emory.mathcs.nlp.component.tokenizer.Tokenizer;
import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class Reader {

	private static String PUNCTUATIONS = "[()’_?:!'\"“.,;{}]+";

	public Book readAndUpdateBook(String filePath, String bookName) {
		// TODO Auto-generated method stub

		BufferedReader br = IOUtils.createBufferedReader(filePath);
		List<Paragraph> paragraphList = new ArrayList<Paragraph>();
		try {

			String line;

			String paragraph = "";

			while ((line = br.readLine()) != null) {

				paragraph += line + " ";

				if (line.trim().isEmpty()) {
					paragraphList.add(processParagraph(paragraph));
					paragraph = "";
				}

			}

			paragraphList.add(processParagraph(paragraph));

		} catch (Exception e) {
			e.printStackTrace();
		}

		Book b = new Book();

		b.updateBookInfo(paragraphList);
		b.setName(bookName);
		return b;
	}

	private Paragraph processParagraph(String paragraph) {
		// TODO Auto-generated method stub
		Paragraph p = new Paragraph();

		Tokenizer tokenizer = new EnglishTokenizer();
		List<Token> list = tokenizer.tokenize(paragraph);

		// for(Token t: list)
		// System.out.println(t);
		p.setPunctuationFrequency(processPunctuationFrequency(list));
		p.setSentenceFrequency(processSentenceFrequency(list));
//		removePunctuations(list);
		p.setWordFrequency(processWordFrequence(list));
		//Paragraph.updateTopNWords(list);
		return p;
	}

	private Integer processWordFrequence(List<Token> list) {

		removePunctuations(list);

		return list.size();

	}

	private Integer processSentenceFrequency(List<Token> list) {
		// TODO Auto-generated method stub
		int SentenceCount = 0;
		for (Token t : list) {
			if (t.toString().equals(".") || t.toString().equals("!") || t.toString().equals("?")
					|| t.toString().equals(":") || t.toString().equals(";"))
				SentenceCount++;
		}
		return SentenceCount;

	}

	private void removePunctuations(List<Token> list) {
		// TODO Auto-generated method stub
		
		Iterator iter = list.iterator();
		
		while(iter.hasNext()){
			
				if(PUNCTUATIONS.contains(iter.next().toString())){
					iter.remove();
				}
		}

	}

	private Integer processPunctuationFrequency(List<Token> list) {
		// TODO Auto-generated method stub

		String pun = ".;:?-!";

		int counter = 0;

		for (Token t : list) {

			String temp = t.toString();
			char c = temp.charAt(0);

			// System.out.println(c);
			if ((temp.length() == 1) && ((pun.indexOf(c) >= 0))) {
				counter++;
			}
		}
		return counter;
	}

}
