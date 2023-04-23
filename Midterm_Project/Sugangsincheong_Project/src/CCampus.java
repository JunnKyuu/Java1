
public class CCampus {

	public VUserCampus campusInfo(VCampus vCampus) {
		MAccount mAccount = new MAccount();
		VUserCampus vUserCampus = mAccount.campus(vCampus);
		
		return vUserCampus;
	}
}
