package controll;

import java.util.Scanner;

import model.MAccount;
import valueObject.VMajor;
import valueObject.VUserCollege;
import valueObject.VUserMajor;

public class CMajor {

	public VUserMajor majorInfo(VUserCollege vUserCollege, VMajor vMajor) {
		MAccount mAccount = new MAccount();
		VUserMajor vUserMajor = mAccount.major(vUserCollege, vMajor);
		
		return vUserMajor;
	}

}
