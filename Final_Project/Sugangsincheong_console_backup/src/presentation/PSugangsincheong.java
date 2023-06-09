package presentation;

import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {	

	private PLectureSelection pLectureSelection; 
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBasket;
	
	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBasket = new PLectureBasket();
	}
		
	public void run(VUserInfo vUserInfo, Scanner keyboard) {	
		VLecture vLecture = null;
		boolean bRunning = true;
		
		while(bRunning) {
			System.out.println("강좌선택 0, 미리담기 1, 수강신청 2, 종료 9");
			System.out.print("입력: ");
			
			String sCode = keyboard.next();
			System.out.println("");
			int iCode = Integer.parseInt(sCode);
			
			switch(iCode) {
			case 0:
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;
			case 1:
				if(vLecture == null) {
					System.out.println("장바구니가 비어있습니다. 강좌를 담아주세요!");
					break;
				}
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.show();
			case 2:
				if(vLecture == null) {
					System.out.println("장바구니가 비어있습니다. 강좌를 담아주세요!");
					break;
				}
				pSincheongBasket.add(vLecture);
				pSincheongBasket.show();
				break;
			case 9:
				bRunning = false;
				System.out.println("수강신청을 종료합니다.");
				break;
			default:
				break;
			}
		}
	}
}
