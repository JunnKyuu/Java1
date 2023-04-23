
public class VCampus {
	private String campusCode;
	private String campusName;
	
	public void setCampusCode(String campusCode) {
		this.campusCode = campusCode;
	}
	
	public void setCampusName(String campusCode) {
		this.campusCode = campusCode;
		char temp = campusCode.charAt(0);
		
		if(temp == '1') {
			campusName = "용인";
		} else {
			campusName = "서울";
		}
	}
	
	public String getCampusCode() {
		return campusCode;
	}
	
	public String getCampusName() {
		return campusName;
	}
}
