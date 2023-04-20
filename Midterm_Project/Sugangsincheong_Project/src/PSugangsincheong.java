import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PSugangsincheong {
	private VUserInfo vUserInfo;
	
	public PSugangsincheong(VUserInfo vUserInfo) {
		try {
		this.vUserInfo = vUserInfo;
				
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
