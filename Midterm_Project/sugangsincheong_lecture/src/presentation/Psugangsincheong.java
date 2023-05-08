package presentation;
import java.util.Scanner;
import java.util.Vector;

import controll.CIndex;
import valueObject.VIndex;
import valueObject.VUserInfo;

public class Psugangsincheong {
	private CIndex cIndex;
	
	public Psugangsincheong() {
		this.cIndex = new CIndex();
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
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
			String campusFileName = this.selectIndex("캠퍼스","root", keyboard);
			String collegeFileName = this.selectIndex("대학", campusFileName, keyboard);
			String departmentFileName = this.selectIndex("학과", collegeFileName, keyboard);
	}
}
