import java.io.IOException;

public class Main {
	
	public Main() {
		
	}

	public void run() {
		Calculator calculator = new Calculator();
		calculator.run();
	}
	
	public static void main(String[] args) {
		System.out.println("연산자(+, -, *, /)와 숫자 두 개를 순서대로 엔터를 이용해 입력하세요!");
		Main main = new Main();
		main.run();
	}
}
