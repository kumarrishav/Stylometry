package com.amriteya.stylometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Book {

	private static final int N = 5;
	
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

	public void updateBookInfo(List<Paragraph> paragraphList) {
		// TODO Auto-generated method stub

		int totatWords = 0;
		int totalSentences = 0;
		int totalPunctuations = 0;
		for (Paragraph p : paragraphList) {

			totatWords += p.getWordFrequency();
			totalSentences += p.getSentenceFrequency();
			totalPunctuations += p.getPunctuationFrequency();
		}
		double d = (double)totalSentences / paragraphList.size();
		this.setAverageLinesPerParagraph(d);

		double d2 = (double)totatWords / totalSentences;
		this.setAverageWordsPerSentence(d2);

		double d3 = (double) totalPunctuations / totatWords;
		this.setPunctuationDensity(d3);

//		wordFrequency = wordFrequencyFromParagraph();
//		this.setWordFrequency(wordFrequency);

	}

//	private ArrayList<String> wordFrequencyFromParagraph() {
//		// TODO Auto-generated method stub
//		
//		return getMaxFreqWords();
//	}
//
//	private static ArrayList<String> getMaxFreqWords() {
//		// TODO Auto-generated method stub
//
//		ArrayList<String> returnList = new ArrayList<String>();
//
//		Set<Entry<String, Integer>> set = Paragraph.getStaticMap().entrySet();
//		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
//		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//				return (o2.getValue()).compareTo(o1.getValue());
//			}
//		});
//		// IS_SORTED = true;
//
//		for (Map.Entry<String, Integer> entry : list) {
//			returnList.add(entry.getKey());
//		}
//		return limitNWords(returnList, N);
//	}
//	
//	private static ArrayList<String> limitNWords(ArrayList<String> returnList, int N) {
//		// TODO Auto-generated method stub
//
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < N; i++)
//			list.add(returnList.get(i));
//		return list;
//	}

}
