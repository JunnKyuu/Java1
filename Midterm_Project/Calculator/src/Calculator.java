import java.io.IOException;

public class Calculator {
	private int readOperator() throws IOException {
		System.out.println("+, -, *, / 중 하나의 연산자를 이용하여 prefix 형태로 입력하시오.(종료하려면 q를 입력)");
		System.out.print("입력: ");
		
		int code = System.in.read();
		
		while(!(code == '+' || code == '-' || code == '*' || code == '/')) {
			if(code == 'q') {
				System.out.println("q를 입력해서 종료합니다.");
				quit();
			} else {
				code = System.in.read();
			}
		}
		
		return code;
	}
	
	private int readInt() throws IOException {		
		int number = 0; // 계산할 정수 
		int exit = 0; // 탈출을 위한 정수 
		int code = System.in.read();
		
		while(true) {
			while(code >= '0' && code <= '9') {
				// 숫자를 입력받으면 계산을 함
				number = number * 10 + (code - '0');
				code = System.in.read();
			
				if(!(code>='0' && code <='9')) {
					exit = 1;
					// 숫자가 아닌게 들어옴
				} 
			}
			
			if(exit == 1) {
				// while문을 나감
				
				break;
			} else if (code == '+' || code == '-' || code == '*' || code == '/') {
				// 연산자가 들어오면 다시 숫자를 입력받음
				
				number = compute(code);
				break;
			}
			
			code=System.in.read();
		}
		return number;
	}
	
	private int compute(int code) throws IOException {
		// 계산하는 부분 
		
		int result = 0;
		int num1 = readInt(); 
		int num2 = readInt(); 
		
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
	
	public void quit() {
		System.exit(0);
		// 종료함수 
	}
	
	public void run() {
		try {
			int code = readOperator();
			
			while(code != 'q') {
				int result = compute(code);
				System.out.println("답: " + result);
				System.out.println("-------------------------------------------------------------------");
				code = readOperator();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
