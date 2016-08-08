package com.amriteya.stylometry;

public class TestClass {
	
	
	private static String FILE_PATH_BASE = "src/resources/";
	private static String BOOK_EXTENSION = ".txt";
	
	public static void main(String[] args){
		
		Reader reader = new Reader();
		
		String[] books = new String[]{"warandpeace"};
		
		Author a = null;
		Trainer t = null;
		for(String book : books){
			
			a =  reader.readAndUpdateBook(FILE_PATH_BASE+book+BOOK_EXTENSION);
			t.addAuthor(a);
		
		}
		
		
	}
}
