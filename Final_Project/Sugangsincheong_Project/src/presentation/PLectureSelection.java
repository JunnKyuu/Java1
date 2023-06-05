package presentation;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection extends JPanel {
	private CIndex cIndex;
	private CLecture cLecture;
	
	private class PSelection extends JTable {
		public PSelection(String[][] contents, String[] title) {
			super(contents, title);
		}
	}
	
	public PLectureSelection() {
		String[] title = new String[1];
		String[][] contents = new String[1][2];
		
		PSelection PCampus = new PSelection(contents, title);
		JScrollPane scrollPane =  new JScrollPane(PCampus);
		this.add(scrollPane);
		
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
	}
	
	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요");
		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for (VIndex vIndex: vIndexVector) {
			vIndex.show();
		}
		
		String sCode = keyboard.next();		
		int iCode = Integer.parseInt(sCode);
		//iCode -> selectedIndex
		int selectedIndex = iCode - 1;
		
		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		return selectedFileName;
	}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요");
		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		for (VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		//iCode -> selectedIndex
		int selectedIndex = 0;
		VLecture vLecture = vLectureVector.get(selectedIndex);
		return vLecture;
	}
	
	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard) {		
			String campusFileName = this.findIndex("캠퍼스","root",keyboard );
			String collegeFileName = this.findIndex("대학",campusFileName,keyboard );
			String departmentFileName = this.findIndex("학과",collegeFileName,keyboard );
			
			VLecture vLecture = this.findLecture("강좌",departmentFileName,keyboard);
			return vLecture;
	}
	
}
