import java.util.Scanner;

public class PCollegeCode {

	public VUserCollege getCollegeInfo() {
		VUserCollege vUserCollege = new VUserCollege();
		Scanner scanner = new Scanner(System.in); 
		String userCollegeCode = scanner.next();
		
		VCollegeCode vCollegeCode = new VCollegeCode();
		vCollegeCode.setCollegeCode(userCollegeCode); 
		vCollegeCode.setCollegeName(userCollegeCode);
		
		CCollegeCode cCollegeCode = new CCollegeCode();

		return vUserCollege;
	}

}
