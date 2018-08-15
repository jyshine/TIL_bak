package chapter01.test;

import chapter01.iterator.Book;
import chapter01.iterator.BookShelf;
import chapter01.iterator.Iterator;

public class TestIterator {
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Around the World in 80 Days"));
		bookShelf.appendBook(new Book("Bible"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("Daddy long legs"));
		
		Iterator it = bookShelf.iterator();
		
		while(it.hasNext()) {
			Book book = (Book) it.next();
			System.out.println(book.getName());
		}
		
	}
}
