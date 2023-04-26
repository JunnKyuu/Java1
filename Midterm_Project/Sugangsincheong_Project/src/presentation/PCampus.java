package presentation;
import java.util.Scanner;

import controll.CCampus;
import valueObject.VCampus;
import valueObject.VUserCampus;

public class PCampus {

	public VUserCampus getCampusInfo() {
		Scanner scanner = new Scanner(System.in); 
		String userCampusCode = scanner.next();
		
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
