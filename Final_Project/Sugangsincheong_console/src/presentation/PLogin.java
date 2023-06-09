package presentation;

import java.util.Scanner;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {

	public VUserInfo login(Scanner keyboard){
		
		System.out.println("사용자 이름을 입력해주세요.");
		String userId = keyboard.next();
		System.out.println("비밀번호를 입력해주세요.");
		String password = keyboard.next();
		System.out.println("");
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		if (vUserInfo == null) {
			System.out.println("----------로그인 실패----------");
			System.out.println("잘 못 입력하였습니다.");
		}
		else {
			System.out.println("----------로그인 성공----------");
			System.out.println(vUserInfo.getName() + "님 안녕하세요");
			System.out.println("");
		}
		return vUserInfo;
	}
}
