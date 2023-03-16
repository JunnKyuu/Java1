import java.util.Scanner;
import java.util.Vector;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 목표 : 문자열을 입력받아 정수로 바꿔서 계산한 후 다시 문자열로 바꾸기!
		 * 
		 * 1. 문자열을 입력받는다.
		 * 2. 문자열을 뒤집어준다.
		 * 2. 문자열을 char 형태로 쪼갠다.
		 * 3. 쪼갠 아스키코드 값을 정수값으로 바꿔준다.
		 * 4. 쪼갠 값들을 합쳐서 원래 원했던 정수값으로 바꾼다.
		 * 5. 두 정수값을 더해서 합을 구한다.
		 * 6. 합을 다시 문자로 바꿔서 출력한다.
		 */
		
		String str1, str2; // 입력받을 문자열1, 문자열2
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력해주세요");
		
		str1 = sc.next();
		str2 = sc.next();
		// 문자열1, 문자열2를 입력받는다.
		
		StringBuffer sb1 = new StringBuffer(str1);
		StringBuffer sb2 = new StringBuffer(str2);
		
		String rstr1 = sb1.reverse().toString();
		String rstr2 = sb2.reverse().toString();
		// 문자열1, 문자열2를 뒤집어준다.
		
		char[] cArr1 = rstr1.toCharArray();
		char[] cArr2 = rstr2.toCharArray();
		// 문자열1, 문자열2를 char형태로 쪼갠다.
		
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		// 정수값을 저장할 벡터1, 벡터2
		
		for(char c : cArr1) {
			int num = (int)c - '0';
			v1.add(num);
		}
		
		for(char c : cArr2) {
			int num = (int)c - '0';
			v2.add(num);
		}
		// 쪼갠 아스키코드 값을 정수값으로 바꿔서 벡터에 각각 저장한다.
		
		int num1 = (int)v1.elementAt(0);
		int num2 = (int)v2.elementAt(0);
		int sum = 0;
		// 문자열1의 정수값, 문자열2의 정수값, 합
		
		for(int i = 1; i < v1.size(); i ++) {
			int ten = (int)Math.pow(10, i);
			int temp = ten * (int)v1.elementAt(i);
			
			num1 += temp;
		}
		// num1 구하기
		
		for(int i = 1; i < v2.size(); i ++) {
			int ten = (int)Math.pow(10, i);
			int temp = ten * (int)v2.elementAt(i);
			num2 += temp;
		}
		// num2 구하기
		
		sum = num1 + num2;
		// 합 구하기
		
		String result;
		result = String.valueOf(sum);
		// 합을 다시 문자로 바꾸기
		
		System.out.print("합 : ");
		System.out.println(result);
	}

}
