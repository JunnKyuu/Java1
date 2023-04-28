package presentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VUserCampus;
import valueObject.VUserCollege;

public class PSelectCollege {
	private VUserCampus vUserCampus;

	public PSelectCollege() {
		
	}

	public void run(VUserCampus vUserCampus, Scanner keyboard) {
		try {
			this.vUserCampus = vUserCampus;
			
			System.out.println(vUserCampus.getCampusName() + "캠퍼스 수강신청을 시작하겠습니다.\n");
			System.out.println("다음 대학의 코드를 선택하세요.");
			
			String tempCode = vUserCampus.getCampusCode();
			char tempC = tempCode.charAt(0);

			if(tempC == '1') {
				Scanner collegeFile = new Scanner(new File("./data/yongin.txt"));
				
				while(collegeFile.hasNext()) {
					int campusCode = collegeFile.nextInt();
					String campusName = collegeFile.next();
					String collegeName = collegeFile.next();
					
					System.out.println(campusCode + " " + campusName);
				}
				
				collegeFile.close();
			} else {
				Scanner collegeFile = new Scanner(new File("./data/seoul.txt"));
				
				while(collegeFile.hasNext()) {
					int campusCode = collegeFile.nextInt();
					String campusName = collegeFile.next();
					String collegeName = collegeFile.next();
					
					System.out.println(campusCode + " " + campusName);
				}
				
				collegeFile.close();
			}
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		PCollege pCollege = new PCollege();
		VUserCollege vUserCollege = pCollege.getCollegeInfo(vUserCampus, keyboard);
		
		if(vUserCollege != null) {
			System.out.println("");
			System.out.println("---------------대학 선택 성공---------------");
			System.out.println(vUserCollege.getCollegeName() + " 수강신청을 시작하겠습니다!");
		}
	}
}
