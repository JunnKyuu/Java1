import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			int number1 = 0;
			int code = System.in.read();
			
			while(code != '\n') {
				// mac은 enter입력시 CR은 안받는다. OS가 달라서
				
				number1 = number1 * 10 + (code - 0x30);
				code = System.in.read();
			}
			
			//System.out.println(number1);
			
			int number2 = 0;
			code = System.in.read();
			while(code != '\n') {
				number2 = number2 * 10 + (code - 0x30);
				code = System.in.read();
			}
			//System.out.println(number2);
			
			int sum = number1 + number2;
			System.out.println(sum);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
