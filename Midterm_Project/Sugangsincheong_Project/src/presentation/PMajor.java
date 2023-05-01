package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VUserCollege;

public class PMajor {
	
	public PMajor() {
		
	}
	
	public void getMajorInfo(VUserCollege vUserCollege, Scanner keyboard) {
		try {
			
			System.out.println(vUserCollege.getCollegeName() + " 수강신청을 시작하겠습니다.\n");
			System.out.println("다음 전공학과의 코드를 선택하세요.");
			
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
	}

}
