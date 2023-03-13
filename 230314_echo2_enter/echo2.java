package echo2;

import java.util.Scanner;

public class echo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		while(sc.hasNextLine()) {
			str = sc.nextLine();
			
			System.out.println(str);
		}
	}

}
