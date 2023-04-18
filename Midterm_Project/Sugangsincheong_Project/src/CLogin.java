
public class CLogin {

	public VUserInfo login(VLogin vLogin) {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.login(vLogin);
		
		return vUserInfo;
	}

}
