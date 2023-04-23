import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MAccount {
	
	public VUserInfo login(VLogin vLogin) { 
		VUserInfo vUserInfo = null;
		
		File file = new File("./data/Account.txt");
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scanner.hasNext()) {
			// 끝까지 찾으면 종료
			
			String line = scanner.nextLine(); // 한 라인씩 읽어보자 - 아이디, 비밀번호, 이름 	
			String[] tokens = line.split(" "); // 빈 칸이 있으면 뜯어줌, 이거 제대로 되게 하는 것이 과제 
			
			if(tokens[0].equals(vLogin.getUserId())) {
				if(tokens[1].equals(vLogin.getPassword())) {
					// 아이디와 비밀번호가 다 같으면 찾은 것
					
					vUserInfo = new VUserInfo();
					vUserInfo.setName(tokens[2]);
					break;
				}
			}
		}
		
		return vUserInfo;
	}

	public VUserCampus campus(VCampus vCampus) {
		VUserCampus vUserCampus = null;
		
		File file = new File("./data/root.txt");
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scanner.hasNext()) {
			String code = scanner.nextLine(); 
			String[] tokens = code.split(" "); 
			
			if(tokens[0].equals(vCampus.getCampusCode())) {
				vUserCampus = new VUserCampus();
				vUserCampus.setCampusCode(tokens[0]);
				vUserCampus.setCampusName(vCampus.getCampusName());
				break;
			}
		}
		
		return vUserCampus;
	}
}
