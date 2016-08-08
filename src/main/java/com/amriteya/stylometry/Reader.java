package com.amriteya.stylometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.nlp.common.util.IOUtils;
import edu.emory.mathcs.nlp.common.util.Joiner;
import edu.emory.mathcs.nlp.component.tokenizer.EnglishTokenizer;
import edu.emory.mathcs.nlp.component.tokenizer.Tokenizer;
import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class Reader {
	
	
	private static String PUNCTUATIONS = "[()’_?:!'\"“.,;{}]+";

	public Book readAndUpdateBook(String filePath, String bookName) {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = IOUtils.createBufferedReader(filePath);
		List<Paragraph> paragraphList = new ArrayList<Paragraph>();
		try{
			
			String line;
			
			String paragraph = "";
			
			
			while((line= br.readLine()) != null){
				
				paragraph += line + " ";
				
				if(line.trim().isEmpty()){
					paragraphList.add(processParagraph(paragraph));
					paragraph = "";
				}
					
				
			}
			
			paragraphList.add(processParagraph(paragraph));
			
		}catch(Exception e){
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
		
//		for(Token t: list)
//			System.out.println(t);
		p.setPunctuationFrequency(processPunctuationFrequency(list));
		p.setSentenceFrequency(processSentenceFrequency(list));
		removePunctuations(list);
		p.setWordFrequency(processWordFrequence(list));
		Paragraph.updateTopNWords(list);
		return p;
	}
	
	private Integer processWordFrequence(List<Token> list) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer processSentenceFrequency(List<Token> list) {
		// TODO Auto-generated method stub
		return null;
	}

	private void removePunctuations(List<Token> list) {
		// TODO Auto-generated method stub
		
	}

	private Integer processPunctuationFrequency(List<Token> list) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public static void main(String[] args){
		Reader r = new Reader();
		
		Token t = new Token("hello");
		
//		r.readAndUpdateBook("src/resources/sample.txt");
	}
	
	
}
