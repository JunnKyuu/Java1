import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(); // 정수 입력 
		
		int length = (int)(Math.log10(num1) + 1); // 자릿수 구하기 

		char[] charArr = new char[length]; // 아스키코드가 들어갈 char 배열 
	
		for(int i = 0; i < length; i ++) {
			charArr[i] = (char)((num1 % 10) + '0'); // char 배열에 정수를 아스키코드로 바꿔서 넣기 
			num1 /= 10; // 입력받은 정수의 각 자리수를 계산 
		}
		
		for(int i = length - 1; i >= 0; i --) {
			// 배열을 거꾸로 출력 
			System.out.print(charArr[i]); 
		}
	}

}
