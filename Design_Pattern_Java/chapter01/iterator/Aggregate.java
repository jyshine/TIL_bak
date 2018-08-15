package chapter01.iterator;

public interface Aggregate {
	//합체에 대응하는 Iterator를 1개 작성하기 위한 것
	//집합체를 하나씩 나열하고, 검색하고, 조사하고 싶을 때에는 iterator 메소드를 사용해서
	//Iterator 인터페이스를 구현
	public abstract chapter01.iterator.Iterator iterator();
}
