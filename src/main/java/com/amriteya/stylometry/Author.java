package com.amriteya.stylometry;

import java.util.List;

public class Author {

	private String name;
	
	private List<Book> books;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public String toString(){
		
		String returnValue = "";
		
		returnValue += (this.name+"\n");
		returnValue += "~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		
		for(Book b : this.books){
			
			returnValue += ("Name : "+b.getName()+"\n");
			returnValue +=("Avg Lines / Paragraph : "+b.getAverageLinesPerParagraph()+"\n");
			returnValue +=("Avg Words / Sentence : "+b.getAverageWordsPerSentence()+"\n");
			returnValue +=("Punctuation Density : "+b.getPunctuationDensity()+"\n");
//			returnValue +=("Top 10 Words : "+b.getWordFrequency()+"\n");
			
			returnValue +=("-----------------------------------"+"\n");
		}
		
		return returnValue;
	}
	
}
