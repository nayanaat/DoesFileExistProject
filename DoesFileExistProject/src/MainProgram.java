import java.io.IOException;
import java.util.Iterator;
import java.util.SortedSet;

public class MainProgram {
	
    static String filePathString = new String("/Users/YourFolder/Documents/SomeFile.txt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println("Return Value :");
	    
	    
		try {
			System.out.println("This file is " + filePathString + "  its existence is "+ FunctionLibrary.doesFileExist(filePathString) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FunctionLibrary.read(filePathString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SortedSet<Integer> t1 = FunctionLibrary.RandomNumbers1(500);
	    Iterator<Integer> itr = t1.iterator();
	    int i=0;
	    while (itr.hasNext() && i!=4) {
	    	i++;
	    	itr.next();
	    }
        System.out.println("the 5th number is "+ itr.next());		
	}	

}
