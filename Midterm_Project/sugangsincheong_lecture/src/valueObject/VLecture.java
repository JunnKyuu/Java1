package valueObject;

import java.util.Scanner;

public class VLecture {

	private String code;
	private String grade;
	
	private String name;
	private String professor;
	private String time;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void load(Scanner file) {
		this.setCode(file.next());
		this.setName(file.next());
		this.setProfessor(file.next());
		this.setGrade(file.next());
		this.setTime(file.next());
	}
}

