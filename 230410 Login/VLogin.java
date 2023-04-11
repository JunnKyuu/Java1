import java.util.Scanner;

public class VLogin {
	
	public static void main(String[] args) {

	}

	public boolean login() {
		Scanner scanner = new Scanner(System.in); // 키보드와 연결해서 받은 값을 변환
		
		System.out.println("학번을 입력하세요.");
		String userId = scanner.nextLine(); // userId에 입력받은 값 할당
		
		if(!((userId.length() == 8) && (userId.charAt(0) == '6'))) {
			// 수강신청 로그인을 하려면 학번을 입력해야한다.
			// 명지대학교 학번은 6으로 시작하고 8자리이다. 
			
			// 로그인 실패 
			return false;
		}
		
		scanner.close(); // 키보드를 다 썼으면 반환해준다.
		return true;
	}

}
