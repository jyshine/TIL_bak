package chapter01.iterator;
// 요소를 하나씩 나열하면서 루프 변수와 같은 역할을 수행합니다
public interface Iterator {
	// '다음 요소'가 존재하는지를 조사하기 위한 hasNext 메소드
	public abstract boolean hasNext();
	// ‘다음 요소'를 얻기 위한 next 메소드
	public abstract Object next();
}
