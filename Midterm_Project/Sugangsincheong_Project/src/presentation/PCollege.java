package presentation;

import java.util.Scanner;

import controll.CCollege;
import valueObject.VCollege;
import valueObject.VUserCampus;
import valueObject.VUserCollege;

public class PCollege {

	public PCollege() {
		
	}

	public VUserCollege getCollegeInfo(VUserCampus vUserCampus, Scanner keyboard) {
		System.out.print("대학 코드: ");
		String collegeCode = keyboard.next();	
		
		VCollege vCollege = new VCollege();
		vCollege.setCollegeCode(collegeCode);
		
		CCollege cCollege = new CCollege();
		VUserCollege vUserCollege = cCollege.collegeInfo(vUserCampus, vCollege);
		
		if(vUserCollege == null) {
			System.out.println("잘못입력하셨습니다.");
		}
		
		return vUserCollege;
	}

}
