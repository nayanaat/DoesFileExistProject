import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class FunctionLibrary {
	

	public static boolean doesFileExist(String filePathString) throws IOException {
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory()) { 
		    return(true);
		} else {
			System.out.println("File does not exist or is a folder");
			throw new IOException();
		}
	}
	
	public static void read(String file) throws IOException{
	    File f = new File(file);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(f);

	    while(scanner.hasNext()){
	    	for (String tokens: scanner.nextLine().split(" – |, ",0)) {
	            System.out.println(tokens);
	    	}
	    }
	    

	}
	
	public static SortedSet<Integer> RandomNumbers1(Integer num){
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
