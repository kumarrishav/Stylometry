package com.amriteya.stylometry;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

	private static final String FILE_PATH_BASE = "src/resources/";
	private static final String BOOK_EXTENSION = ".txt";
	private static final String AUTHOR_NAME = "Tolstoy, Leo";
	
	public static void trainingModel(){
		
		Reader reader = new Reader();
		
		String[] books = new String[]{"warandpeace"};
		
		Book b = null;
		Trainer t = null;
		Author a = new Author();
		a.setName(AUTHOR_NAME);
		List<Book> listOfBooks = new ArrayList<Book>();
		for(String book : books){
			
			b =  reader.readAndUpdateBook(FILE_PATH_BASE+book+BOOK_EXTENSION, book);
			listOfBooks.add(b);
		
		}
		
		a.setBooks(listOfBooks);
		
	}
}
