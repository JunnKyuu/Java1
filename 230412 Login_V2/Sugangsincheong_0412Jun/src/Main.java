
public class Main {

	public Main() {
		
	}
	
	private void run() {
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		if(vUserInfo != null) {			
			Psugangsincheong psugangsincheong = new Psugangsincheong(vUserInfo);
			psugangsincheong.run();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();		
	}
}
