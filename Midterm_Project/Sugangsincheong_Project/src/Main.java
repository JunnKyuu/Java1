
public class Main {

	public Main() {
		
	}
	
	private void run() {
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		if(vUserInfo != null) {			
			PSugangsincheong pSugangsincheong = new PSugangsincheong(vUserInfo);
			pSugangsincheong.run();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();		
	}
}
