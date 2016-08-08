package com.amriteya.stylometry;

import java.util.ArrayList;

public class Author {

	
	private String name;
	
	private ArrayList<String> wordFrequency;
	
	private Double averageWordsPerSentence;
	
	private Double punctuationDensity;
	
	private Double averageLinesPerParagraph;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getWordFrequency() {
		return wordFrequency;
	}

	public void setWordFrequency(ArrayList<String> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	public Double getAverageWordsPerSentence() {
		return averageWordsPerSentence;
	}

	public void setAverageWordsPerSentence(Double averageWordsPerSentence) {
		this.averageWordsPerSentence = averageWordsPerSentence;
	}

	public Double getPunctuationDensity() {
		return punctuationDensity;
	}

	public void setPunctuationDensity(Double punctuationDensity) {
		this.punctuationDensity = punctuationDensity;
	}

	public Double getAverageLinesPerParagraph() {
		return averageLinesPerParagraph;
	}

	public void setAverageLinesPerParagraph(Double averageLinesPerParagraph) {
		this.averageLinesPerParagraph = averageLinesPerParagraph;
	}
	
	
	
}
