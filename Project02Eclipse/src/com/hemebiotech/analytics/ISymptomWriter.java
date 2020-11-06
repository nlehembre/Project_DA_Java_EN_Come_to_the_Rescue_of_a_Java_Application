package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will write symptom stats into a destination
 * The important part is, the parameter is a list of key value already sorted
 *
 * The implementation needs to write each item of the list key - value
 * 
 */
public interface ISymptomWriter {

	/**
	 *
	 * @param symptomsSorted the list of symptoms sorted (key = symptom ; value = occurrences)
	 * @throws IOException : error while writing
	 */
	void writeSymptoms(List<Map.Entry<String, Integer>> symptomsSorted) throws IOException;
}
