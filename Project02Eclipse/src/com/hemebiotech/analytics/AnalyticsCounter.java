package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0

	public static void main(String args[]) throws Exception {
		// first get input
		List<String> allSymptoms = new ReadSymptomDataFromFile("C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt").GetSymptoms();

		Set<String> symptoms = new HashSet<>(allSymptoms);

		for (int i = 0; i < allSymptoms.size(); i++) {
			countSymptom(allSymptoms.get(i));
		}
		writeSymptomStats();
		return;

	}

	private static String countSymptom(String symptom) {

//		int i = 0;	// set i to 0
//		while (line != null) {
//			i++;	// increment i
//			System.out.println("symptom from file: " + line);
//			if (line.equals("headache")) {
//				headacheCount++;
//				System.out.println("number of headaches: " + headacheCount);
//			}
//			else if (line.equals("rash")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = reader.readLine();	// get another symptom
//		}
		return symptom;
	}

	private static void writeSymptomStats() throws IOException {
		// next generate output
		FileWriter writer = new FileWriter ("./result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

}
