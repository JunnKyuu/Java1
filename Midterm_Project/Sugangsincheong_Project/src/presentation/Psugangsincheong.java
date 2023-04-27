package presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VUserCampus;
import valueObject.VUserInfo;

public class Psugangsincheong {
	private VUserInfo vUserInfo;
	
	public Psugangsincheong() {
	
	}	

	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		try {
				
			System.out.println("----------------로그인 성공----------------");
			System.out.println(vUserInfo.getName() + "님 안녕하세요.\n");
			System.out.println("캠퍼스 코드를 입력하세요.");
							
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
		
		PCampus pCampus = new PCampus();
		VUserCampus vUserCampus = pCampus.getCampusInfo(keyboard);
		
		if(vUserCampus != null) {
			System.out.println("");
			System.out.println("---------------캠퍼스 선택 성공---------------");
			System.out.println("안녕하세요 " + vUserInfo.getName() + "님!");
			
			PSelectCollege pSellectCollege = new PSelectCollege();
			pSellectCollege.run(vUserCampus, keyboard);
		}
	}

}
