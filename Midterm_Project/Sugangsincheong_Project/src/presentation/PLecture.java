package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VUserLecture;
import valueObject.VUserMajor;

public class PLecture {
	private VUserLecture vUserLecture;
	
	public void run(VUserMajor vUserMajor, Scanner keyboard) {		
		vUserLecture = getLectureInfo(vUserMajor, keyboard);
		
	}

	private VUserLecture getLectureInfo(VUserMajor vUserMajor, Scanner keyboard) {
		try {
			System.out.println("다음 강의 코드를 선택하세요.");
			
			String majorNameEng = vUserMajor.getMajorNameEng();
			
			Scanner lectureFile = new Scanner(new File("./data/" + majorNameEng + ".txt"));
			
			while(lectureFile.hasNext()) {
				int lectureCode = lectureFile.nextInt();
				String lectureName = lectureFile.next();
				String lectureProfessorName = lectureFile.next();
				int lectureGrade = lectureFile.nextInt();
				String lectureTime= lectureFile.next();
				
				System.out.println(lectureCode + " " + lectureName + " " + lectureProfessorName + "교수님 " + lectureGrade + "학점 " + lectureTime);
			}
			
			lectureFile.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		return vUserLecture;
	}

}
