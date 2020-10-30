package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	private final ISymptomReader iSymptomReader;
 	private final ISymptomWriter iSymptomWriter;
	private List<String> allSymptoms = new ArrayList<String>();
	private Map<String, Integer> symptomsOccurs = new HashMap<String, Integer>();

	public AnalyticsCounter(ISymptomReader iSymptomReader, ISymptomWriter iSymptomWriter) throws IOException {
		this.iSymptomReader = iSymptomReader;
		this.iSymptomWriter = iSymptomWriter;
	}

	public List<String> readSymptoms() {
		allSymptoms = iSymptomReader.getSymptoms();
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
		iSymptomWriter.writeSymptoms(symptomsSorted);
	}

}
