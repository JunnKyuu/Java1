import java.util.Scanner;
import java.util.Stack;

public class PrefixCalculator {
	public static int check(String str) {
		Stack<Integer> st = new Stack<>();
		// 값을 저장할 스택 
		
		for(int i = str.length() - 1; i >= 0; i-- ) {
			// 값을 저장하고 거꾸로 꺼내기 
			char c = str.charAt(i);
			
			if(isOperator(c)) {
				// 꺼낸 값이 연산자일 경우 
				int num1 = st.pop();
				int num2 = st.pop();
				int result = calculate(c, num1, num2);
				
				st.push(result);
				
			} else if(isOperand(c)) {
				// 꺼낸 값이 피연산자일 경우 
				int operand = Character.getNumericValue(c);
				st.push(operand);
			}
		}
		return st.pop();
		// 스택에서 결과값 꺼내기 
	}
	
	public static boolean isOperator(char c) {
		// 스택에서 꺼낸 값이 연산자일 경우 
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	
	public static boolean isOperand(char c) {
		// 스택에서 꺼낸 값이 피연산자일 경우
		return c >= '0' && c <= '9'; 
	}
	
	public static int calculate(char c, int num1, int num2) {
		// 계산을 위한 함수 
		int result = 0;
		
		if(c == '+') {
			result = add(num1, num2);
		} else if(c == '-') {
			result = subtract(num1, num2);
		} else if(c == '*') {
			result = multiply(num1, num2);
		} else {
			result = divide(num1, num2);
		} 
		
		return result;
	}
	
	private static int add(int num1, int num2) {
		// 덧셈 함수 
		int result = num1 + num2;
		return result;
	}
	
	private static int subtract(int num1, int num2) {
		// 뺄셈 함수 
		int result = num1 - num2;
		return result;
	}
	
	private static int multiply(int num1, int num2) {
		// 곱셈 함수 
		int result = num1 * num2;
		return result;
	}
	
	private static int divide(int num1, int num2) {
		// 나눗셈 함수 
		int result = num1 / num2;
		return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int result = check(str);
		System.out.println(result);
	}

}
