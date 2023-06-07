package presentation;
import java.util.Scanner;

import controll.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {
	
	public static void main(String[] args) {
		
	}

	public VUserInfo login(Scanner keyboard) {
		System.out.println("사용자 아이디와 비밀번호를 입력하세요."); 
		System.out.print("아이디: ");
		String userId = keyboard.next();
		System.out.print("비밀번호: ");
		String password = keyboard.next();
		System.out.println("");
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId); 
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		
		if(vUserInfo == null) {
			System.out.println("잘못입력하셨습니다.");
		} else {
//			System.out.println(vUserInfo.getName() + "님 안녕하세요.");
		}
		
		return vUserInfo;
	}

}
