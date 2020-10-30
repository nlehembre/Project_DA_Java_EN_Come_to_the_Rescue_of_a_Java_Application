package com.hemebiotech.analytics;

import java.util.Map;
import java.util.Set;

/**
 * Anything that will write symptom stats into a destination
 * The important part is, the parameter is a set of key value already sorted
 *
 * The implementation needs to write each item of the list key - value
 * 
 */
public interface ISymptomWriter {

	/**
	 * if the list to be printed is empty, return nothing
	 * 
	 * @return nothing specific
	 */
	void writeSymptoms(Set<Map.Entry<String, Integer>> symptomsSorted);
}
