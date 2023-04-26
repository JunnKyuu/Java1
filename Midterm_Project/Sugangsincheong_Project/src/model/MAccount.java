package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VCampus;
import valueObject.VLogin;
import valueObject.VUserCampus;
import valueObject.VUserInfo;

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
			
			String line = scanner.nextLine(); 
			String[] tokens = line.split(" "); 
			
			if(tokens[0].equals(vLogin.getUserId())) {
				if(tokens[1].equals(vLogin.getPassword())) {
					
					vUserInfo = new VUserInfo();
					vUserInfo.setName(tokens[2]);
					break;
				}
			}
		}
		scanner.close();
		
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
