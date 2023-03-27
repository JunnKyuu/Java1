import java.io.IOException;

public class Calculator {
	private int readOperator() throws IOException {
		// TODO Auto-generated method stub
		// 연산자를 판단하는 함수 
		int operator = System.in.read();
		System.in.read(); // LF가 들어가서 날려버린다. 
		
		return operator;
	}
	
	private int readInt() throws IOException {
		final int LineFeed = 0x0a;
		int code = System.in.read(); // 입력받기
		int number = 0;
		
		if(code == '+') {
			number += add();
		} else {
			while(code >= '0' && code <= '9') {
				number = number * 10 + (code - '0');
				code = System.in.read();
			} // 숫자가 아닌 것을 걸러냄 
			
			if(code == LineFeed) {
				// 정상일 때 
			} else {
				// exception 발생
				throw new IOException();  
			}
		}
		
		return number;
	} 
	
	private int add() throws IOException {
		// 덧셈 함수 
		int number1 = readInt();  
		int number2 = readInt();
		int value = number1 + number2;
		return value;
	}
	
	private int multiply() throws IOException {
		// 곱셈 함수 
		int number1 = readInt();
		int number2 = readInt();
		int value = number1 * number2;
		return value;
	}
	
	private int subtract() throws IOException {
		// 뺄셈 함수 
		int number1 = readInt();
		int number2 = readInt();
		int value = number1 - number2;
		return value;
	}
	
	private int divide() throws IOException {
		// 나눗셈 함수 
		int number1 = readInt();
		int number2 = readInt();
		int value = number1 / number2;
		return value;
	}
	
	public void run() {
		try {
			int result = 0;
			int code = readOperator();
			// 연산자를 읽어야 계산하니까 연산자를 읽는 함수를 만든다. 
			
			if(code == '+') {
				result = add();
				
				System.out.print("결과 : ");
				System.out.println(result);
			} else if(code == '-') {
				result = subtract();
				
				System.out.print("결과 : ");
				System.out.println(result);
			} else if(code == '*') {
				result = multiply();
				
				System.out.print("결과 : ");
				System.out.println(result);
			} else if(code == '/') {
				result = divide();
				
				System.out.print("결과 : ");
				System.out.println(result);
			} else {
				System.out.println("잘못된 연산자입니다.");
				System.out.println("연산자를 다시 입력해주세요.");
				
				Calculator c = new Calculator();
				c.run(); // 잘못된 연산자가 입력되면 다시 입력받기 	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}