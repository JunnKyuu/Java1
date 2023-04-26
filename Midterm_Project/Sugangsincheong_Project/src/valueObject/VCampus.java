package valueObject;

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
		} else if(temp == '2'){
			campusName = "서울";
		} else {
			System.out.println("잘못입력하셨으므로 종료합니다.");
			System.exit(0);
		}
	}
	
	public String getCampusCode() {
		return campusCode;
	}
	
	public String getCampusName() {
		return campusName;
	}
}
