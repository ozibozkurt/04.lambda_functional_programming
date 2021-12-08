package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
//Oracle SQL Developer indirmem lazim
public class Ft03 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");
        
        printInUpperCases01(l);
        System.out.println();
        //printInUpperCases02(l);// String mutable oldugu icin orjinal veriyi degistirmek istemedik
        printElementsSortedByLength(l);
        System.out.println();
        printElementsReversedSortedByLength(l);
        System.out.println();printDistinctSortedByLastChar(l);
        System.out.println();
        printSortedByLengthThenSortedByInitial(l);
        System.out.println();
        //removeIfTheLengthIsGreaterThanFive(l);
        //System.out.println();
        //printRemoveIfStartingWithAEndingWithN01(l);
        //removeIfLengthBetween8And10EndingWithO(l);
        System.out.println(checkLengthToBeLessThanTwelve(l));
        System.out.println(checkNotToStartWithX(l));
        System.out.println(checkAnyoneEndsWithR(l));
	}
	
	//1) Create a method to print all list elements in uppercase
	//1st Way
	public static void printInUpperCases01(List<String> list) {
		list.stream().map(String::toUpperCase).forEach(Utils::printInTheSameLineWithSpace);	
	}
	
//	//2nd Way
//	public static void printInUpperCases02(List<String> list) {
//		list.replaceAll(String::toUpperCase);
//		System.out.println(list);
//	}
	
	//2) Create a method to print the elements after ordering according to their lengths
	public static void printElementsSortedByLength(List<String> list) {
		list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::printInTheSameLineWithSpace);
	}
	
	//3) Create a method to print the elements after ordering according to their lengths (In reverse order)
	public static void printElementsReversedSortedByLength(List<String> list) {
	list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::printInTheSameLineWithSpace);	
	}
	
	//4) Create a method to sort the distinct elements by using their last characters
	public static void printDistinctSortedByLastChar(List<String> list) {
		list.stream().distinct().sorted(Comparator.comparing(Utils::getLastChar)).forEach(Utils::printInTheSameLineWithSpace);	
	}
	
	//5) Create a method to sort the elements according to their lengths then according to their first character
	public static void printSortedByLengthThenSortedByInitial(List<String> list) {
		list.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.charAt(0))).
		forEach(Utils::printInTheSameLineWithSpace);	
	}
	
//	//6) Remove the elements if the length of the element is greater than 5
//	public static void removeIfTheLengthIsGreaterThanFive(List<String> list) {
//		list.removeIf(t->t.length()>5);
//		System.out.println(list);// Ali Ali Mark ====> list mutable o yuzdfen kapattik
//	}
	
	//7) Remove the elements if the element is starting with ‘A’, ‘a’ or ending with ‘N’, ‘n’   
    //1.Way:
//  public static void printRemoveIfStartingWithAEndingWithN01(List<String> list) {           
//      Predicate<String> checkCondition = t -> t.charAt(0)=='A'||t.charAt(0)=='a'||t.charAt(t.length()-1)=='N'||t.charAt(t.length()-1)=='n';              
//      list.removeIf(t-> checkCondition.test(t));       
//      System.out.println(list);       
//  }   
    //2.Way:
//  public static void printRemoveIfStartingWithAEndingWithN02(List<String> list) {   
//      Predicate<String> checkCondition = t -> t.startsWith("A")||t.startsWith("a")||t.endsWith("N")||t.endsWith("n");
//      list.removeIf(t->checkCondition.test(t));        
//      System.out.println(list);   
//  }
	
	//8) Remove the elements if the length is between 8 and 10 or ending with 'o'
    public static void removeIfLengthIsBetween8And10EndingWithO(List<String> list) {
        Predicate<String> checkCondition = t -> (t.length()>7 && t.length()<11) || t.endsWith("o");
        list.removeIf(t->checkCondition.test(t));
        System.out.println(list);
    }
	
  //9) Create a method to check if the lengths of all elements are less than 12
    public static boolean checkLengthToBeLessThanTwelve(List<String> list) {
    return list.stream().allMatch(t-> t.length()<12);	
    }
    
  //10) Create a method to check if the initial of any element is not ‘X’
    public static boolean checkNotToStartWithX(List<String> list) {
    	return list.stream().noneMatch(t->t.startsWith("X"));
    }
    
  //11) Create a method to check if at least one of the elements ending with “r”
    public static boolean checkAnyoneEndsWithR(List<String> list) {
    	return list.stream().anyMatch(t->t.endsWith("r"));
    }	
}
