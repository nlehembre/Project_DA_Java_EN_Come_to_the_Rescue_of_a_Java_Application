package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	private final ISymptomReader iSymptomReader;
 	private final ISymptomWriter iSymptomWriter;

	/**
	 *
	 * @param iSymptomReader : for reading any source
	 * @param iSymptomWriter : for writing into any destination
	 */
	public AnalyticsCounter(ISymptomReader iSymptomReader, ISymptomWriter iSymptomWriter) {
		this.iSymptomReader = iSymptomReader;
		this.iSymptomWriter = iSymptomWriter;
	}

	/**
	 * readSymptoms : to get the list of symptoms from the source
	 * @return the list of symptoms with duplicates
	 * @throws IOException : error while reading
	 */
	public List<String> readSymptoms() throws IOException {
		List<String> allSymptoms = iSymptomReader.getSymptoms();
		return allSymptoms;
	}

	/**
	 * countSymptoms : to count occurrences for each symptom of the list
 	 * @param allSymptoms return from method readSymptoms
	 * @return the list of symptoms not sorted : key = symtom, value = occurrences of this symptom
	 */
	public Map<String, Integer> countSymptoms(List<String> allSymptoms) {
	    Map<String, Integer> symptomsOccurs = new HashMap<String, Integer>();
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

	/**
	 * sortSymptoms : to sort the list of symptoms (key = symptom ; value = occurrences)
	 * @param symptomsOccurs return from method countSymptoms
	 * @return the list of symptoms sorted (key = symptom ; value = occurrences)
	 */
	public List<Map.Entry<String,Integer>> sortSymptoms(Map<String,Integer> symptomsOccurs) {
		Map<String,Integer> symptomsSorted  = new TreeMap<>(symptomsOccurs);
		List<Map.Entry<String,Integer>> symptomsList = new ArrayList<>(symptomsSorted.entrySet());
		return symptomsList;
	}

	/**
	 * writeSymptomStats : to write th list sorted into any source
	 * @param symptomsSorted return from method sortSymptoms
	 * @throws IOException : error while writing
	 */
	public void writeSymptomStats(List<Map.Entry<String,Integer>> symptomsSorted) throws IOException {
		iSymptomWriter.writeSymptoms(symptomsSorted);
	}

}
