package controll;

import java.util.Vector;

import model.MLecture;
import valueObject.VLecture;

public class CLecture {
	private MLecture mLecture;
	
	public CLecture() {
		this.mLecture = new MLecture();
	}
	
	public Vector<VLecture> getVLectureIndexVector(String fileName) {
		Vector<VLecture> vLectureIndexVector = this.mLecture.getVLectureIndexVector(fileName);
		return vLectureIndexVector;
	}

}
