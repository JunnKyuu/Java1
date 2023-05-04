package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VUserInfo;

public class Psugangsincheong {
	
	private class Index {
		private int code;
		private String name;
		private String fileName;
		
		public int getCode() {
			return code;
		}
		
		public void setCode(int code) {
			this.code = code;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getFileName() {
			return fileName;
		}
		
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	}
	
	private String nextIndex(String message, String fileName, Scanner keyboard) {
		try {
			System.out.println(message);
			Scanner file = new Scanner(new File(fileName));

			Vector<Index> indexVector = new Vector<Index>();
			while(file.hasNext()) {	
				Index index = new Index();
				index.setCode(file.nextInt());
				index.setName(file.next());
				index.setFileName(file.next());
				indexVector.add(index);
			
				System.out.println(index.getCode() + " " + index.getName());
			}
		
			file.close();
			
			String command = keyboard.next(); // 여기서 입력받은 코드를 인덱스로 저장.
			int selection = Integer.parseInt(command) - 1; 
			
			String selectedFileName = indexVector.get(selection).getFileName();
			return selectedFileName;

			} 	catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;  
			}
			
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
			System.out.println(vUserInfo.getName() + "님 안녕하세요.\n");
			String campusFileName = nextIndex("캠퍼스 코드를 선택하세요.","./data/root.txt", keyboard);
			String collegeFileName = nextIndex("대학 코드를 선택하세요.", "./data/" + campusFileName + ".txt", keyboard);
			System.out.println(collegeFileName);
//			String majorFileName = nextIndex("학과 코드를 선택하세요.", "./data/" + collegeFileName + ".txt", keyboard);

	}
}
