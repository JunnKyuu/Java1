import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char ascNum1, ascNum2; // 입력받을 2개의 아스키코드  
		int ascNum1Value, ascNum2Value, sum = 0; // 입력받은 아스키코드의 실제값, 
		
		ascNum1 = sc.nextLine().charAt(0); 
		ascNum2 = sc.nextLine().charAt(0); 
		// 아스키코드 숫자를 입력받는다.
		
		ascNum1Value = (int)ascNum1 - '0'; 
		ascNum2Value = (int)ascNum2 - '0';
		// 입력받은 아스키코드의 실제
		
		sum = ascNum1Value + ascNum2Value;
		// 실제값으로 바꾸고 합을 구한다. 

		int tempNum1, tempNum2 = 0; // 몫과 나머지
		
		if(sum >= 10) {
			// 합이 10 이상일 때
			
			tempNum1 = sum / 10 + '0';
			tempNum2 = sum % 10 + '0';
			
			char tempChar1, tempChar2;
			tempChar1 = (char)tempNum1;
			tempChar2 = (char)tempNum2;
			
			System.out.print(tempChar1);
			System.out.print(tempChar2);
		} else {
			// 합이 10 미만일 때 
			
			int resultInt; 
			resultInt = sum + '0';
			
			char resultChar = (char)resultInt;
			System.out.print(resultChar);
		}
	}

}
