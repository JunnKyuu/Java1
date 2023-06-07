package controll;

import model.MAccount;
import valueObject.VCampus;
import valueObject.VUserCampus;

public class CCampus {

	public VUserCampus campusInfo(VCampus vCampus) {
		MAccount mAccount = new MAccount();
		VUserCampus vUserCampus = mAccount.campus(vCampus);
		
		return vUserCampus;
	}
}
