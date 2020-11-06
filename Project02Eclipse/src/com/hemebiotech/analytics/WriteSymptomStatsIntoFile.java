package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteSymptomStatsIntoFile implements ISymptomWriter {

    private String filepath;

    /**
     *
     * @param filepath a full or partial path to file where the list sorted of symptoms is printed : each symtom with occurrences
     */

    public WriteSymptomStatsIntoFile (String filepath) {
        this.filepath = filepath;
    }

    /**
     *
     * @param symptomsSorted the list of symptoms sorted (key = symptom ; value = occurrences)
     * @throws IOException : error while writing
     */
    @Override
    public void writeSymptoms(List<Map.Entry<String, Integer>> symptomsSorted) throws IOException {
        if (filepath != null) {
            try (FileWriter writer = new FileWriter (filepath)) {
                 for (Map.Entry<String, Integer> symptomSorted : symptomsSorted) {
                    writer.write(symptomSorted.getKey() + " : " + symptomSorted.getValue() + "\n");
                }
            }
        }
    }
}
