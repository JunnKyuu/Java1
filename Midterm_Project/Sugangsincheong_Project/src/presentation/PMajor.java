package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controll.CMajor;
import valueObject.VMajor;
import valueObject.VUserCollege;
import valueObject.VUserMajor;

public class PMajor {
	
	public PMajor() {
		
	}
	
	public VUserMajor getMajorInfo(VUserCollege vUserCollege, Scanner keyboard) {
		try {
			System.out.println("다음 전공 코드를 선택하세요.");
			
			String collegeNameEng = vUserCollege.getCollegeNameEng();
			
			Scanner majorFile = new Scanner(new File("./data/" + collegeNameEng + ".txt"));
			
			while(majorFile.hasNext()) {
				int majorCode = majorFile.nextInt();
				String majorName = majorFile.next();
				String majorNameEng = majorFile.next();
				
				System.out.println(majorCode + " " + majorName);
			}
			
			majorFile.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		System.out.print("전공 코드: ");
		String majorCode = keyboard.next();
		
		VMajor vMajor = new VMajor();
		vMajor.setMajorCode(majorCode); 
		
		CMajor cMajor = new CMajor();
		VUserMajor vUserMajor = cMajor.majorInfo(vUserCollege, vMajor);
		
		if(vUserMajor == null) {
			System.out.println("전공 코드를 잘못입력하셔서 종료합니다.");
		}
		
		return vUserMajor;
	}

}
