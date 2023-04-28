package controll;

import model.MAccount;
import valueObject.VCollege;
import valueObject.VUserCampus;
import valueObject.VUserCollege;

public class CCollege {

	public VUserCollege collegeInfo(VUserCampus vUserCampus, VCollege vCollege) {
		MAccount mAccount = new MAccount();
		VUserCollege vUserCollege = mAccount.college(vUserCampus, vCollege);
		
		return vUserCollege;
	}

}
