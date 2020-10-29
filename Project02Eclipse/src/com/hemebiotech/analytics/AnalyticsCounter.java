package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	private String readFilepath;
	private String writeFilepath;
	private List<String> allSymptoms = new ArrayList<String>();
	private Map<String, Integer> symptomsOccurs = new HashMap<String, Integer>();

	public AnalyticsCounter(String readFilepath, String writeFilepath) throws IOException {
		this.readFilepath = readFilepath;
		this.writeFilepath = writeFilepath;
	}

	public List<String> readSymptoms() {

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(readFilepath);
		allSymptoms = readSymptomDataFromFile.getSymptoms();
		return allSymptoms;

	}

	public Map<String, Integer> countSymptoms(List<String> allSymptoms) {

		symptomsOccurs.put(allSymptoms.get(0), 1);
		for (String symptom : allSymptoms) {
			if (symptomsOccurs.containsKey(symptom)) {
				int nbSymptom = symptomsOccurs.get(symptom);
				nbSymptom ++;
				symptomsOccurs.put(symptom, nbSymptom);
			} else {
				symptomsOccurs.put(symptom, 1);
			}
		}
		return symptomsOccurs;
	}

	public Set<Map.Entry<String,Integer>> sortSymptoms(Map<String,Integer> symptomsOccurs) {
		Map<String,Integer> symptomsWork  = new TreeMap<>(symptomsOccurs);
		Set<Map.Entry<String,Integer>> symptomsSorted = symptomsWork.entrySet();
		return symptomsSorted;
	}

	public void writeSymptomStats(Set<Map.Entry<String,Integer>> symptomsSorted) throws IOException {

		WriteSymptomStatsIntoFile writeSymptomStatsIntoFile = new WriteSymptomStatsIntoFile(writeFilepath);
		writeSymptomStatsIntoFile.writeSymptoms(symptomsSorted);
	}

}
