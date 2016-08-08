package com.amriteya.stylometry;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class Paragraph {

	private TreeMap<String, Integer> topNWords;
	
	private Integer wordFrequency;
	
	private Integer punctuationFrequency;
	
	private Integer sentenceFrequency;

	public Integer getWordFrequency() {
		return wordFrequency;
	}

	public void setWordFrequency(Integer wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	public Integer getPunctuationFrequency() {
		return punctuationFrequency;
	}

	public void setPunctuationFrequency(Integer punctuationFrequency) {
		this.punctuationFrequency = punctuationFrequency;
	}

	public Integer getSentenceFrequency() {
		return sentenceFrequency;
	}

	public void setSentenceFrequency(Integer sentenceFrequency) {
		this.sentenceFrequency = sentenceFrequency;
	}

	public void updateTopNWords(List<Token> tokens) {
		// TODO Auto-generated method stub
		topNWords = new TreeMap<String, Integer>();
		for (Token token : tokens) {
			if(StopWords.isStopword(token.toString()))
				continue;
			if (topNWords.containsKey(token.toString()))
				topNWords.put(token.toString(), topNWords.get(token.toString()) + 1);
			else
				topNWords.put(token.toString(), 1);
		}
		
	}

	public TreeMap<String, Integer> getTopNWords() {
		return topNWords;
	}

	public void setTopNWords(TreeMap<String, Integer> topNWords) {
		this.topNWords = topNWords;
	}

	public Map getMap() {
		// TODO Auto-generated method stub
		return topNWords;
	}
	
	
}
