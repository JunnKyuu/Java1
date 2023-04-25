import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PSelectCollege {
	private VUserCampus vUserCampus;

	public PSelectCollege(VUserCampus vUserCampus) {
		try {
			this.vUserCampus = vUserCampus;
			
			System.out.println(vUserCampus.getCampusName() + "캠퍼스 수강신청을 시작하겠습니다. \n");
			System.out.println("다음 대학의 코드를 선택하세요.");
			
			String tempCode = vUserCampus.getCampusCode();
			char tempC = tempCode.charAt(0);

			if(tempC == '1') {
				Scanner collegeFile = new Scanner(new File("./data/yongin.txt"));
				
				while(collegeFile.hasNext()) {
					int campusCode = collegeFile.nextInt();
					String campusName = collegeFile.next();
					String collegeName = collegeFile.next();
					
					System.out.println(campusCode + " " + campusName);
				}
				
				collegeFile.close();
			} else {
				Scanner collegeFile = new Scanner(new File("./data/seoul.txt"));
				
				while(collegeFile.hasNext()) {
					int campusCode = collegeFile.nextInt();
					String campusName = collegeFile.next();
					String collegeName = collegeFile.next();
					
					System.out.println(campusCode + " " + campusName);
				}
				
				collegeFile.close();
			}
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		String userCode = sc.next();
		
		System.out.println("입력한 코드: " + userCode);
	}

}
