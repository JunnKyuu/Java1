
public class Main {

	public Main() {
		// Constructor
	}
	static int count = 0;
	private void run() {
		VLogin vLogin = new VLogin(); // 로그인을 위한 객체 생성 
		
		if(vLogin.login() == true) {
			// 로그인 성공
			System.out.println("--------------로그인 성공--------------");
			System.out.println("     반갑습니다, 로그인을 성공했습니다!");
			System.out.println("------------------------------------");
		} else {
			// 로그인 실패 
			count ++; // 틀린 횟수 증가 
			
			System.out.println("--------------로그인 실패--------------");
			System.out.println("학번을 다시 입력하세요.(5번 틀리면 종료됩니다.)");
			System.out.print("현재 틀린 횟수: ");
			System.out.println(count); // 틀린 횟수 출력 
			System.out.println("------------------------------------");
			
			if(count == 5) {
				// 학번을 5번 틀렸으면 종료 
				quit();
			}
			
			Main retryLogin = new Main();
			retryLogin.run(); // 로그인 다시 시도 
		} 
	}
	
	private void quit() {
		// 종료를 위한 함수
		System.out.println("학번을 5번 틀렸으므로 종료합니다.");
		System.out.println("------------------------------------");
		System.exit(0);
	}
	public static void main(String[] args) {
		// main 함수 
		Main main = new Main();
		main.run();		
	}
}
