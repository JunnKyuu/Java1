package presentation;
import java.util.Scanner;

import controll.CCampus;
import valueObject.VCampus;
import valueObject.VUserCampus;

public class PCampus {

	public PCampus() {
		
	}

	public VUserCampus getCampusInfo(Scanner keyboard) {
		System.out.print("캠퍼스 코드: ");
		String userCampusCode = keyboard.next();
		
		VCampus vCampus = new VCampus();
		vCampus.setCampusCode(userCampusCode); 
		vCampus.setCampusName(userCampusCode);
		
		CCampus cCampus = new CCampus();
		VUserCampus vUserCampus = cCampus.campusInfo(vCampus);
		
		if(vUserCampus == null) {
			System.out.println("잘못입력하셨습니다.");
		}
		
		return vUserCampus;
	}
}
