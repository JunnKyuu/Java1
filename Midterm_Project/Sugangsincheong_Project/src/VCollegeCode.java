
public class VCollegeCode {

	private String collegeCode;
	private String collegeName;
	
	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}
	
	public void setCollegeName(String collegeCode) {
		this.collegeCode = collegeCode;
		
		if(collegeCode == "10") {
			collegeName = "교양";
		} else if(collegeCode == "11"){
			collegeName = "공과대학";
		} else if(collegeCode == "12") {
			collegeName = "자연과학대학";
		} else if(collegeCode == "13") {
			collegeName = "예술체육대학";
		} else if(collegeCode == "14") {
			collegeName = "건축대학";
		} else if(collegeCode == "20") {
			collegeName = "교양";
		} else if(collegeCode == "21") {
			collegeName = "ICT융합대학 ";
		} else if(collegeCode == "22") {
			collegeName = "경영대학";
		} else if(collegeCode == "23") {
			collegeName = "사회과학대학";
		} else if(collegeCode == "24") {
			collegeName = "인문대학";
		} else if(collegeCode == "25") {
			collegeName = "법학대학";
		} else {
			System.out.println("잘못입력하셨으므로 종료합니다.");
			System.exit(0);
		}
	}
	
	public String getCollegeCode() {
		return collegeCode;
	}
	
	public String getCollegeName() {
		return collegeName;
	}

}
