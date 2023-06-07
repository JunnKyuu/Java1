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
	
	public PMainFrame() {
		this.setSize(400, 600);

		pSugangsincheong = new PSugangsincheong();
		this.add(pSugangsincheong);
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
		PMainFrame mainFrame = new PMainFrame();
		mainFrame.setVisible(true);
	}
}
