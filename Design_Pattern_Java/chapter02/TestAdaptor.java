package chapter02.test;

import chapter02.adaptor.Print;
import chapter02.adaptor.PrintBanner;

public class TestAdaptor {
	public static void main(String[] args) {

		Print p = new PrintBanner("Hello! Adaptor Pattern");
		p.printWeak();
		p.printStrong();
		
		Print2 p2 = new PrintBanner2("Hello!");
		p2.printWeak();
		p2.printStrong();
	}
}
