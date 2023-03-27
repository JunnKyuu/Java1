import java.io.IOException;

public class Calculator {
	private int readOperaor() throws IOException {
		// TODO Auto-generated method stub
		
		int code = System.in.read();
		System.in.read(); // linefeed가 들어감 근데 이것을 flush로 날려버려야한다! 
		return code;
	}
	
	private int readInt() throws IOException {
		final int LineFeed = 0x0a;
		
		int number = 0;
		int code = System.in.read();
		while(code >= '0' && code <= '9') {
			number = number * 10 + (code - '0');
			code = System.in.read();
		} // 숫자가 아닌 것을 걸러냄 , CR은 괜찮다 
		
		if(code == LineFeed) {
			code = System.in.read();
			// 정상 
			return number;
		} else {
			// exception 발생, 입력을 잘못했으니 익셉션을 던져버림 
			throw new IOException();
			// 그냥 오류를 날리니까 리턴할 것이 없다  
		}
	} 
	
	private int add() throws IOException {
		int number1 = readInt(); // 이것도 맘에 안들어서 readOperand도 만들자! 
		int number2 = readInt();
		int sum = number1 + number2;
		return sum;
	}
	
	private int multiply() throws IOException {
		int number1 = readInt();
		int number2 = readInt();
		int sum = number1 * number2;
		return sum;
	}
	
	public void run() {
		try {
			int result = 0;
			int code = readOperaor();
			// 연산자를 읽어야 계산하니까 연산자를 읽는 함수를 만든다. 
			
			if(code == '*') {
				result = multiply();
			}
			
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.exit(0);
		}
	}
}