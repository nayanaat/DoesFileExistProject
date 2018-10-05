import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class RandomNumbers {
	
	public static SortedSet<Integer> RandomNumbers(Integer num){
		SortedSet<Integer> RandomSet = new TreeSet<>(); 
        Random randomNum = new Random();		
        int a;
        for(int i = 0; i<num; i++){
        	a = randomNum.nextInt(10000);
            System.out.println("Random number is : " + a);
            RandomSet.add(a);
            }
		return RandomSet;	
	}
}
