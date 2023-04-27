package controll;

import model.MAccount;
import valueObject.VCollege;
import valueObject.VUserCollege;

public class CCollege {

	public VUserCollege collegeInfo(VCollege vCollege) {
		MAccount mAccount = new MAccount();
		VUserCollege vUserCollege = mAccount.college(vCollege);
		
		return vUserCollege;
	}

}
