package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

public class MLecture {
	public Vector<VLecture> getVLectureIndexVector(String fileName) {
		Vector<VLecture> vLectureIndexVector = null;
		
		vLectureIndexVector = new Vector<VLecture>();
		try {
			Scanner file = new Scanner(new File("./data/" + fileName + ".txt"));
			while(file.hasNext()) {
				VLecture vLecture = new VLecture();
				vLecture.load(file);
				vLectureIndexVector.add(vLecture);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vLectureIndexVector;
	}

}
