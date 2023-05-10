package presentation;
import java.util.Scanner;
import java.util.Vector;

import controll.CIndex;
import controll.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class Psugangsincheong {
	private CIndex cIndex;
	private CLecture cLecture;
	
	public Psugangsincheong() {
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
	}
	
	private String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println("\n" + message + "코드를 입력하세요.");
		
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for(VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName());
		}
				
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0; 
		int idx = 0;
		
		for(VIndex vIndex: vIndexVector) { 
			if(vIndex.getCode() == iCode) {
				selectedIndex = idx;
				break;
			}
			idx++;
		}
	
		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		
		return selectedFileName;
	}
	
	private String selectLectureIndex(String message, String fileName, Scanner keyboard) {
		System.out.println("\n" + message + "코드를 입력하세요.");
		
		Vector<VLecture> vLectureIndexVector = cLecture.getVLectureIndexVector(fileName);
		for(VLecture vLecture: vLectureIndexVector) {
			System.out.println(vLecture.getCode() + " " + vLecture.getName()+ " " + vLecture.getProfessor() + " " + vLecture.getGrade() + "학점 " + vLecture.getTime());
		}
				
		String sCode = keyboard.next();
		int selectedIndex = 0; 
		int idx = 0;
		
		for(VLecture vLecture: vLectureIndexVector) { 
			if(vLecture.getCode() == sCode) {
				selectedIndex = idx;
				break;
			}
			idx++;
		}
	
//		String selectedFileName = vLectureIndexVector.get(selectedIndex).getFileName();
//		
//		return selectedFileName;
		return null;
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
			String campusFileName = this.selectIndex("캠퍼스","root", keyboard);
			String collegeFileName = this.selectIndex("대학", campusFileName, keyboard);
			String departmentFileName = this.selectIndex("학과", collegeFileName, keyboard);
			String lectureFileName = this.selectLectureIndex("강의", departmentFileName, keyboard);
	}
}
