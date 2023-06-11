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
	
	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println("**" + message + "코드를 입력하세요**");
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for (VIndex vIndex: vIndexVector) {
			System.out.println(vIndex.getCode() + " " + vIndex.getName() );
		}
		System.out.print("입력: ");
		
		String sCode = keyboard.next();	
		System.out.println("");
		String selectedFileName = null;
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
				
		for(VIndex vIndex: vIndexVector) {
			int temp = vIndex.getCode();
			
			if(iCode == temp) {
				break;
			}
			
			selectedIndex ++;
		}
		
		if(selectedIndex == vIndexVector.size()) {
			System.out.println("**잘못입력하였습니다! 다시 입력해주세요!**");
			selectedIndex = 0;
			selectedFileName=this.findIndex(message, fileName, keyboard);
		}else {
			selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		}
		return selectedFileName;
	}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println("**" + message + "코드를 입력하세요**");
		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		for (VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		System.out.print("입력: ");
		
		String sCode = keyboard.next();
		System.out.println("");
		int iCode = Integer.parseInt(sCode);
		int selectedIndex = 0;
		VLecture vLecture = null;
		
		for(VLecture vLecture1: vLectureVector) {
			int temp = vLecture1.getCode();
			
			if(iCode == temp) {
				break;
			}
			selectedIndex ++;
		}
		
		if(selectedIndex == vLectureVector.size()) {
			System.out.println("**잘못입력하였습니다! 다시 입력해주세요!**");
			selectedIndex = 0;
			vLecture=this.findLecture(message, fileName, keyboard);
		}else {
			vLecture = vLectureVector.get(selectedIndex);
		}
		return vLecture;
	}
	
	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard) {		
			String campusFileName = this.findIndex("캠퍼스", "root", keyboard );
			String collegeFileName = this.findIndex("대학", campusFileName, keyboard );
			String departmentFileName = this.findIndex("학과", collegeFileName, keyboard );
			
			VLecture vLecture = this.findLecture("강좌", departmentFileName, keyboard);
			return vLecture;
	}
	
}
