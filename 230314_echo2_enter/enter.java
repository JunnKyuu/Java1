package enter;

import java.util.Scanner;

public class enter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
	    String str = scanner.nextLine();
	    
	    if(str.isEmpty()) {
	    	System.out.println("ENTER");
	    } else {
	    	System.out.println(str);
	    }
	}

}
