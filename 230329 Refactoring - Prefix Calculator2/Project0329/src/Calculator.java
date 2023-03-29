import java.io.IOException;

public class Calculator {
	private int readOperator() throws IOException {
		// TODO Auto-generated method stub
		// 연산자를 판단하는 함수 
		int operator = System.in.read();
		System.in.read(); // LF가 들어가서 날려버린다. (맥은 이것만)
		
		return operator;
	}
	
	private int readInt() throws IOException {
		// 계산하는 함수 
		final int LineFeed = 0x0a;
		
		int code = System.in.read();
		int number = 0;
		
		while(code >= '0' && code <= '9') {
			number = number * 10 + (code - '0');
			code = System.in.read();
		} // 숫자가 아닌 것을 걸러냄 
		
		if(code == LineFeed) {
			// 정상일 때
			return number;
		} else {
			// exception 발생
			throw new IOException();  
		}
	}
	
	private void quit() {
		System.exit(0);
	}
	
	private int compute(int code) throws IOException {
		// 계산하는 부분 
		int result = 0;
		int num1 = readInt(); // operand1
		int num2 = readInt(); // operand2
		
		if(code == '+') {
			result = num1 + num2;
		} else if(code == '-') {
			result = num1 - num2;
		} else if(code == '*') {
			result = num1 * num2;
		} else if(code == '/') {
			result = num1 / num2;
		} else {
			throw new IOException();
		}
		return result;
	}
	
	public void run() {
		try {
			int code = readOperator();
			while(code != 'q') {
				int result = compute(code);
				System.out.println(result);
				code = readOperator();
			}
			quit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}