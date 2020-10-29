package com.hemebiotech.analytics;

/**
 * Anything that will write symptom stats into a destination
 * The important part is, the return value from the operation, which is null ?
  *
 * The implementation just needs to write each item of the list
 * 
 */
public interface ISymptomWriter {

	/**
	 * if the list to be printed is empty, return nothing
	 * 
	 * @return nothing specific
	 */
}
