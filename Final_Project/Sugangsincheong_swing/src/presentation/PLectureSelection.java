package presentation;

import java.awt.Dimension;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection extends JPanel {
	private CLecture cLecture;
	
	private class PSelection extends JTable {
		
		private CIndex cIndex;
		
		public PSelection(String titleName, String fileName) {
			String[] title = new String[1];
			title[0] = titleName;
			DefaultTableModel tableModel = new DefaultTableModel(title, 0);
			this.setModel(tableModel);
			
//			RowSelectionListener rowSelectionListener = new RowSelectionListener();
//			this.getSelectionModel().addListSelectionListener(rowSelectionListener);
			
			this.cIndex = new CIndex();
			Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
			for (VIndex vIndex: vIndexVector) {
				String[] row = new String[1];
				row[0] = vIndex.getName();
				tableModel.addRow(row);
			}
		}
		
		private class RowSelectionListener implements ListSelectionListener {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					int firstIndex = e.getFirstIndex(); 
					int lastIndex = e.getLastIndex(); 
					System.out.println("first-" + firstIndex);
					System.out.println("last-" + lastIndex);
				}
			}
		}
	}
	
	public PLectureSelection() {
		
//		캠퍼스 
		PSelection PCampus = new PSelection("캠퍼스", "root");
		JScrollPane scrollPane =  new JScrollPane(PCampus);
		scrollPane.setPreferredSize(new Dimension(200,300));
		this.add(scrollPane);
		
//		대학  
		PSelection PCollege = new PSelection("대학", "root");
		scrollPane =  new JScrollPane(PCollege);
		scrollPane.setPreferredSize(new Dimension(200,300));
		this.add(scrollPane);
		
//		학과  
		PSelection PDepartment = new PSelection("학과", "root");
		scrollPane =  new JScrollPane(PDepartment);
		scrollPane.setPreferredSize(new Dimension(200,300));
		this.add(scrollPane);
		
		this.cLecture = new CLecture();
	}
	
	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message + "코드를 입력하세요");
//		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
//
//		for (VIndex vIndex: vIndexVector) {
//			vIndex.show();
//		}

//		String sCode = keyboard.next();
//		int iCode = Integer.parseInt(sCode);
//		int selectedIndex = 0;
//		for (VIndex vIndex: vIndexVector) {
//			if(iCode == vIndex.getCode()) {
//				break;
//			}
//			selectedIndex++;
//		}
//		String selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		String selectedFileName = null;
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
		int selectedIndex = 0;
		for(VLecture vLecture: vLectureVector) {
			if(iCode == vLecture.getCode()) {
				break;
			}
			selectedIndex ++;
		}
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
