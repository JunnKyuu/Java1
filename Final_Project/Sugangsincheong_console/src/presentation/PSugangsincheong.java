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
		int count = 0;
		
		while(bRunning) {
			if(count == 0) {
				System.out.println("---------------------------수강신청 시작--------------------------");
				System.out.println("**원하시는 강좌를 검색한 후 장바구니에 담거나 바로 수강신청을 해주세요.**");
				System.out.println("강좌검색: 0, 장바구니: 1, 수강신청: 2, 수강신청 종료: 9");
				System.out.print("입력: ");
				
				count = 1;
			} else {
				System.out.println("장바구니에 담거나 수강신청을 선택해주세요!");
				System.out.println("장바구니: 1, 수강신청: 2, 수강신청 종료: 9");
				System.out.print("입력: ");
				
				count = 0;
			}
			
			String sCode = keyboard.next();
			System.out.println("");
			
			int iCode = Integer.parseInt(sCode);
			switch(iCode) {
			case 0:
				System.out.println("---------------------------강좌선택 시작---------------------------");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;
			case 1:
				if(vLecture == null) {
					System.out.println("장바구니가 비어있습니다! 강좌를 선택해주세요!");
					break;
				}
				
				if(count == 0) {
					pMiridamgiBasket.add(vLecture);
					System.out.println("선택한 강좌가 장바구니에 담겼습니다!");
					System.out.println("\n");
				}
				
				System.out.println("---------------------------장바구니 목록---------------------------");
				pMiridamgiBasket.show();
				System.out.println("");
				break;
			case 2:				
				if(vLecture == null) {
					System.out.println("신청할 강좌가 없습니다! 다시 처음으로 돌아갑니다!");
					break;
				}
				
				System.out.println("장바구니 불러오기: 1, 강좌선택: 2");
				int sincheong = keyboard.nextInt();
				
				if(sincheong == 1) {
					System.out.println("장바구니에 담긴 강좌목록을 불러왔습니다!");
					pMiridamgiBasket.show();
					break;
				}
				
				if(sincheong == 2) {
					System.out.println("강좌선택을 해주세요!");
					System.out.println("");
					break;
				}
				
				break;
			case 9:
				bRunning = false;
				System.out.println("---------------------------수강신청 종료---------------------------");
				System.out.println("수강신청을 종료합니다.");
				break;
			default:
				break;
			}
		}
	}
}
