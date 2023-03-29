public class Main {
	
	public Main() {
		
	}

	public void run() {
		Calculator calculator = new Calculator();
		calculator.run();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		while(true) {
			System.out.println("사칙연산 반복 계산을 실행합니다. (종료하려면 q를 입력하세요.)");
			System.out.println("연산자(+, -, *, /)와 숫자 두 개를 순서대로 엔터를 이용해 차례대로 입력하세요.");
			main.run();
		}
	}
}
