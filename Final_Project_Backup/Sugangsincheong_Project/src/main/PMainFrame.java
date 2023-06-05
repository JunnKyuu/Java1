package main;
import java.util.Scanner;

import javax.swing.JFrame;

import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;

public class PMainFrame extends JFrame {
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong pSugangsincheong;
	
	//constructor
	public PMainFrame() {
		//속성 초기화
		this.setSize(400, 600);
		//자식 부품으로 추가
		
		pSugangsincheong = new PSugangsincheong();
		this.add(pSugangsincheong); //자식으로 등록하는 것
	}
	
	private void run() {
		keyboard = new Scanner(System.in);
		pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login(keyboard);
		
		if ( vUserInfo != null) {
			pSugangsincheong = new PSugangsincheong();
			pSugangsincheong.run(vUserInfo, keyboard);
		}
		
		keyboard.close();
	}

	public static void main(String[] args) {
//		PMain mainFrame = new PMain();
//		mainFrame.setVisible(true);
		
		PMainFrame mainFrame = new PMainFrame();
		mainFrame.setVisible(true);
	}
}
