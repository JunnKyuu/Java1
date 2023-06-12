package presentation;

import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {	

	private PLectureSelection pLectureSelection; 
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBasket;
	private PLectureBasket pTempBasket;
	
	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBasket = new PLectureBasket();
		this.pTempBasket = new PLectureBasket();
	}
		
	public void run(VUserInfo vUserInfo, Scanner keyboard) {	
		VLecture vLecture = null;
		boolean bRunning = true;
		boolean start = true;
		
		while(bRunning) {
			
			if(start == true) {
				System.out.println("-------------------------수강신청 프로그램 시작------------------------");
				System.out.println("**원하시는 기능을 선택해주세요(처음 실행하셨다면 강좌검색부터 진행해주세요!)**");
				System.out.println("강좌검색: 0, 장바구니 메뉴: 1, 수강신청 메뉴: 2, 종료: 9");
				System.out.print("입력: ");
			}
			
			if(start == false){
				System.out.println("**선택한 강좌를 장바구니에 담거나 수강신청을 선택해주세요!**");
				System.out.println("장바구니 담기: 3, 바로 수강신청: 4, 종료: 9");
				System.out.print("입력: ");
			}
			
			String sCode = keyboard.next();
			System.out.println("");
			
			int iCode = Integer.parseInt(sCode);
			switch(iCode) {
			case 0:
				start = false;
				System.out.println("---------------------------강좌선택 시작---------------------------");
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;		
			case 1: 
				System.out.println("---------------------------장바구니 메뉴---------------------------");
				System.out.println("장바구니 목록 보기: 1, 장바구니 목록 초기화: 2, 종료: 9");
				System.out.print("입력: ");
				
				int miridamgiMenu = keyboard.nextInt();
				System.out.println("");
				
				if(miridamgiMenu == 1) {
					if(pMiridamgiBasket.isEmpty()) {
						System.out.println("**장바구니가 비어있습니다! 다시 처음으로 돌아갑니다!**");
						System.out.println("\n");
					} else {
						System.out.println("---------------------------장바구니 목록---------------------------");
						System.out.println("장바구니에 담은 강좌: ");
						pMiridamgiBasket.show();
						System.out.println("\n");
						
						System.out.println("**다시 처음으로 돌아갑니다!**");
						System.out.println("");
					}
				} 
				
				if(miridamgiMenu == 2) {
					System.out.println("**장바구니 목록이 초기화 되었습니다!**");
					pMiridamgiBasket.clear();
					pTempBasket.clear();
				}
				
				if(miridamgiMenu == 9) {
					bRunning = false;
					System.out.println("---------------------------수강신청 종료---------------------------");
					System.out.println("**수강신청을 종료합니다**");
				}
				
				break;				
			case 2:
				System.out.println("---------------------------수강신청 메뉴---------------------------");
				System.out.println("수강신청 목록: 1, 수강신청 목록 초기화: 2, 장바구니 불러오기: 3, 종료: 9");
				System.out.print("입력: ");
				
				int sincheongMenu = keyboard.nextInt();
				System.out.println("");
				
				if(sincheongMenu == 1) {
					if(pSincheongBasket.isEmpty()) {
						System.out.println("**신청하신 강좌가 없습니다! 다시 처음으로 돌아갑니다!**");
						System.out.println("\n");
					} else {
						System.out.println("---------------------------수강신청 목록---------------------------");
						System.out.println("수강신청한 강좌: ");
						pSincheongBasket.show();
						System.out.println("\n");
						
						System.out.println("**다시 처음으로 돌아갑니다!**");
						System.out.println("");
					}
				}
				
				if(sincheongMenu == 2) {
					System.out.println("**수강신청 목록이 초기화 되었습니다!**");
					System.out.println("");
					pSincheongBasket.clear();
				}
				
				if(sincheongMenu == 3) {
					System.out.println("---------------------------장바구니 목록---------------------------");
					pMiridamgiBasket.show();
					System.out.println("\n");
					
					System.out.println("**불러오신 장바구니 목록으로 수강신청을 하시겠습니까?**");
					System.out.println("신청O: 1, 신청X: 2");
					System.out.print("입력: ");
					int sincheongCheck = keyboard.nextInt();
					System.out.println("");
					
					if(sincheongCheck == 1) {
						System.out.println("**수강신청이 완료되었습니다!**");						
						System.out.println("수강신청한 강좌: ");
						pSincheongBasket = pTempBasket;
						pSincheongBasket.show();
						System.out.println("\n");
					}
					
					if(sincheongCheck == 2) {
						System.out.println("**다시 처음으로 돌아갑니다!**");
						System.out.println("");
					}
				}
				
				if(sincheongMenu == 9) {
					bRunning = false;
					System.out.println("---------------------------수강신청 종료---------------------------");
					System.out.println("**수강신청을 종료합니다**");
				}
				
				break;				
			case 3:
				if(vLecture == null) {
					System.out.println("**장바구니가 비어있습니다! 다시 처음으로 돌아갑니다!**");
				} else {
					pMiridamgiBasket.add(vLecture);
					pTempBasket.add(vLecture);
					
					start = true;
					System.out.println("**선택하신 강좌가 장바구니에 담겼습니다!**");
					System.out.println("");
					
					System.out.println("---------------------------장바구니 목록---------------------------");
					System.out.println("장바구니에 담은 강좌: ");
					pMiridamgiBasket.show();
					System.out.println("\n");
				}
				
				break;		
			case 4:
				start = true;
				System.out.println("**수강신청이 완료되었습니다!**");
				pSincheongBasket.add(vLecture);
				
				System.out.println("수강신청한 강좌: ");
				pSincheongBasket.show();
				System.out.println("\n");
				break;			
			case 9:
				bRunning = false;
				System.out.println("---------------------------수강신청 종료---------------------------");
				System.out.println("**수강신청을 종료합니다**");
				break;
			default:
				System.out.println("**올바른 번호를 선택해주세요! 프로그램을 다시 시작합니다!**");
				break;
			}
		}
	}
}
