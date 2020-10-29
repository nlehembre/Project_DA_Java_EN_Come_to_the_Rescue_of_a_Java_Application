package com.hemebiotech.analytics;


import java.io.FileWriter;
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
//		for (int i = 1; i < allSymptoms.size(); i++) {
//			String symptom = allSymptoms.get(i);
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

	public void writeSymptomStats(Map<String, Integer> symptomsOccurs) throws IOException {
		// next generate output
		FileWriter writer = new FileWriter (writeFilepath);

		Map<String,Integer> sortedMap  = new TreeMap<>(symptomsOccurs);

		Set<Map.Entry<String,Integer>> set = sortedMap.entrySet();
		Iterator<Map.Entry<String,Integer>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String,Integer> symptomSorted = iterator.next();
			writer.write(symptomSorted.getKey() + " : " + symptomSorted.getValue() + "\n");
		}

		writer.close();
	}

}
