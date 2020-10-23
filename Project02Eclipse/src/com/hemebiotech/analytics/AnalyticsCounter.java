package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	String filepath = new String();
	List<String> allSymptoms = new ArrayList<String>();
	Map<String, Integer> symptomsOccurs = new HashMap<String, Integer>();

	public AnalyticsCounter(String filepath) throws IOException {
		this.filepath = filepath;
	}

	public List<String> readSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);
		allSymptoms = readSymptomDataFromFile.GetSymptoms();
		return allSymptoms;

	}

	public void countSymptoms() {

		symptomsOccurs.put(allSymptoms.get(0), 1);
		for (int i = 1; i < allSymptoms.size(); i++) {
			String symptom = allSymptoms.get(i);
			if (symptomsOccurs.containsKey(symptom)) {
				int nbSymptom = symptomsOccurs.get(symptom);
				nbSymptom ++;
				symptomsOccurs.put(symptom, nbSymptom);
			} else {
				symptomsOccurs.put(allSymptoms.get(i), 1);
			}
		}
	}

//	public void sortSymptoms() {
//
//		Map sortedMap = new TreeMap(symptomsOccurs);
//
//		Set set = sortedMap.entrySet();
//		Iterator iterator = set.iterator();
//		while(iterator.hasNext()) {
//			Map.Entry me = (Map.Entry)iterator.next();
//			System.out.print(me.getKey() + ": ");
//			System.out.println(me.getValue());
//		}
//	}

	public void writeSymptomStats() throws IOException {
		// next generate output
		FileWriter writer = new FileWriter ("./result.out");

		Map sortedMap = new TreeMap(symptomsOccurs);

		Set set = sortedMap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry symptomSorted = (Map.Entry)iterator.next();
			writer.write(symptomSorted.getKey() + " : " + symptomSorted.getValue() + "\n");
		}

		writer.close();
	}

}
