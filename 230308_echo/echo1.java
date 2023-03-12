package echo;

import java.util.Scanner;

public class echo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("x를 입력하면 종료가 됩니다.");
		
		while(true) {
			str = scan.nextLine();
			
			if(str.equals("x")) {
				break;
			} else {
				System.out.println(str);
			}
		}
		
		System.out.println("x를 입력하여 종료합니다.");
	}
}
