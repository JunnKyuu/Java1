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
		
		int number = 0;
		int code = System.in.read();
		
		while(code >= '0' && code <= '9') {
			number = number * 10 + (code - '0');
			code = System.in.read();
		} // 숫자가 아닌 것을 걸러냄 
		
		if(code == LineFeed) {
			// 정상일 때 
			return number;
		} else {
			// exception 발생
			// 그냥 오류를 날리니까 리턴할 것이 없다
			throw new IOException();  
		}
	} 
	
	private int add() throws IOException {
		// 덧셈 함수 
		int number1 = readInt(); // 이것도 맘에 안들어서 readOperand도 만들자! 
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
			} else if(code == '-') {
				result = subtract();
			} else if(code == '*') {
				result = multiply();
			} else {
				result = divide();
			}
			System.out.print("결과 : ");
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
}