package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection {
	
	private CIndex cIndex;
	private CLecture cLecture;
	
	public PLectureSelection() {
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
	}
	
	private String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요.");
		
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for(VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName());
		}
				
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		return selectedFileName;
	}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요.");
		 
		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		for(VLecture vLecture: vLectureVector) {
			System.out.println(vLecture.getCode() 
					+ " " + vLecture.getName()
					+ " " + vLecture.getLecturer()
					+ " " + vLecture.getCredit()
					+ " " + vLecture.getTime()
					);
		}
				
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
		VLecture vLecture = vLectureVector.get(selectedIndex);
		return vLecture;
	}
	 
	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard) {
			String campusFileName = this.selectIndex("캠퍼스","root", keyboard);
			String collegeFileName = this.selectIndex("대학", campusFileName, keyboard);
			String departmentFileName = this.selectIndex("학과", collegeFileName, keyboard);
			
			VLecture vLecture = this.findLecture("강좌", departmentFileName, keyboard);
			
			return vLecture;
	}
}
