import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Psugangsincheong {
	private VUserInfo vUserInfo;
	
	public Psugangsincheong(VUserInfo vUserInfo) {
		try {
		this.vUserInfo = vUserInfo;
		
		// 강좌선택은 용인(1), 서울(2) 2 선택
		// 교양(11), ICT(12) 12선택
		// 111 융소, 112 데테 111선택  
		// --> 이런 것들은 데이터를 찾아가기 위한 index 파일 
				
		// 1111 절프A 09:00 ~ 10:15 월/수 최성운교수님/ 1305 ,,, 이런식 --- 이것은 진짜 데이터 파일  
				
		System.out.println(vUserInfo.getName() + "님 안녕하세요.");
		System.out.println("캠퍼스 코드를 선택하세요.");
		
		Scanner campusFile = new Scanner(new File("./data/root.txt"));

		while(campusFile.hasNext()) {
			int campusCode = campusFile.nextInt();
			String campusName = campusFile.next();
			String collegeName = campusFile.next();
			
			System.out.println(campusCode + " " + campusName);
		}
		
		campusFile.close();
		
		// 이게 되면 pcampus, pcollege new를 해서 화면의 트리구조를 만든다. 
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	public void run() {
		
	}

}
