package chapter01.iterator;
//BookShelf 클래스(리스트 1-4)는 서가를 나타내는 클래스입니다. 이 클래스를 집합체로
//다루기 위해 Aggregate 인터페이스를 구현하고 있습니다. 소스 안의 ‘implements
//Aggregate'가 Aggregate 인터페이스를 구현하고 있다는 것을 나타냅니다 또한,
//Aggregate 인터페이스에서 선언되어 있던 iterator 메소드가 기술되어 있는 것도 확인할
//수 있습니다.
public class BookShelf implements Aggregate{
	private Book[] books; // 접근제어자 private로 책을 담을 배열 생
	private int last;     // 
	
	public BookShelf(int maxSize) {
		this.books = new Book[maxSize];
	}
	
	public Book getBookAt(int index) {
		return books[index];
	}
	
	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}
	
	public int getLength() {
		return last;
	}

	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}
}
//이 서가는 book라 필드를 가지고 있습니다. 이 필드는 Book의 배열입니다. 이 배열의 크
//기(maxsize)는 처음에 BookShelf의 인스턴스를 만들 때 지정합니다. books 필드를 private
//로 한 이유는, 이 클래스 외부로부터 뜻하지 않게 변경되는 것을 방지하기 위해서입니다.
//iterator 메소드는 BookShelf 클래스에 대응하는 Iterator로서, BookShelflterator리는
//클래스의 인스턴스를 생성해서 그것을 반환합니다. 이 서가의 책을 하나씩 나열하고 싶을
//때는 iterator 메소드를 호출합니 다.