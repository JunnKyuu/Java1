import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PSugangsincheong {
	private VUserInfo vUserInfo;
	
	public PSugangsincheong(VUserInfo vUserInfo) {
		try {
		this.vUserInfo = vUserInfo;
		
		System.out.println("---------------로그인 성공---------------");
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
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	

	public void run() {		
		PCampus pCampus = new PCampus();
		VUserCampus vUserCampus = pCampus.getCampusInfo();
		
		if(vUserCampus != null) {	
			System.out.println("---------------캠퍼스 선택 성공---------------");
			System.out.println("안녕하세요 " + vUserInfo.getName() + "님!");
			
			PCollege pCollege = new PCollege(vUserCampus);
			pCollege.run();
		}
	}
}