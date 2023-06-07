package valueObject;

public class VUserMajor {
	private String majorCode;
	private String majorName;
	private String majorNameEng;
	
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	public void setMajorNameEng(String majorNameEng) {
		this.majorNameEng = majorNameEng;
	}
	
	public String getMajorCode() {
		return majorCode;
	}
	
	public String getMajorName() {
		return majorName;
	}
	
	public String getMajorNameEng() {
		return majorNameEng;
	}
}
