package presentation;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.VLecture;
import valueObject.VUserInfo;



public class PSugangsincheong extends JPanel {	
	
	private PLectureSelection pLectureSelection; 
	private PLectureBasket pMilidamgiBasket;
	private PLectureBasket pSincheongBasket;
	
	public PSugangsincheong() {
		this.setBackground(Color.WHITE);

		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS); // new BoxLayout(컨테이너, 축)
		this.setLayout(layoutManager);

		this.pLectureSelection = new PLectureSelection();
		this.pLectureSelection.setBackground(Color.BLUE);
		this.add(this.pLectureSelection);
		
		this.pMilidamgiBasket = new PLectureBasket();
		this.pMilidamgiBasket.setBackground(Color.WHITE);
		this.add(this.pMilidamgiBasket);
		
		this.pSincheongBasket = new PLectureBasket();
		this.pSincheongBasket.setBackground(Color.RED);
		this.add(this.pSincheongBasket);
	}
		
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
	    VLecture vLecture = null;
	    boolean pRunning = true;
	    
	    while (pRunning) {
	        System.out.println("강좌선택 0, 미리담기 1, 수강신청 2, 종료 9");
	        
	        String sCode = keyboard.next();
	        int iCode = Integer.parseInt(sCode);
	        
	        switch (iCode) {
	            case 0:
	                vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
	                break;
	            case 1:
	                pMilidamgiBasket.add(vLecture);
	                pMilidamgiBasket.show();
	                break;
	            case 2:
	                pMilidamgiBasket.add(vLecture);
	                pMilidamgiBasket.show();
	                break;
	            case 9:
	                pRunning = false;
	                System.out.println("시스템이 종료되었습니다.");
	                break;
	            default:
	                break;
	        }
	    }
	}
}