package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Homework {

	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<Integer>();
        l.add(8);
        l.add(9);
        l.add(131);
        l.add(10);
        l.add(9);
        l.add(10);
        l.add(2);
        l.add(8);
        l.add(15);
        
        getMinElement(l);
        getMinElement2(l);
	}

		//1. Way
		public static void getMinElement(List<Integer> list)  {
			Integer minElement = list.stream().distinct().reduce(Integer.MAX_VALUE, (t, u) -> t<u ? t : u);
			System.out.println(minElement);
		}
		//2. Way
		public static void getMinElement2(List<Integer> list) {
			Integer min = list.stream().distinct().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u)->u);
			System.out.println(min);
		}
}


