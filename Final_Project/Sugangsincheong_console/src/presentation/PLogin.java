package presentation;

import java.util.Scanner;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin {

	public VUserInfo login(Scanner keyboard){
		
		System.out.println("---------------------------로그인 시작---------------------------");
		System.out.println("**아이디를 입력해주세요**");
		String userId = keyboard.next();
		System.out.println("**비밀번호를 입력해주세요**");
		String password = keyboard.next();
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		if (vUserInfo == null) {
			System.out.println("**일치하는 정보가 없어서 로그인에 실패하였습니다!**");
			System.out.println("**수강신청 프로그램을 종료합니다**");
		}
		else {
			System.out.println("**로그인에 성공하였습니다**");
			System.out.println("**" + vUserInfo.getName() + "님 안녕하세요**");
			System.out.println("");
			System.out.println("");
		}
		return vUserInfo;
	}
}
