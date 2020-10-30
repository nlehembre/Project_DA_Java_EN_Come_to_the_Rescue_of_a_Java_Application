package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteSymptomStatsIntoFile implements ISymptomWriter {

    private String filepath;

    /**
     *
     * @param filepath a full or partial path to file where each symtom is printed
     */
    public WriteSymptomStatsIntoFile (String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Set<Map.Entry<String, Integer>> symptomsSorted) {
        if (filepath != null) {
            try {
                FileWriter writer = new FileWriter (filepath);

                Iterator<Map.Entry<String,Integer>> iterator = symptomsSorted.iterator();

                while(iterator.hasNext()) {
                    Map.Entry<String,Integer> symptomSorted = iterator.next();
                    writer.write(symptomSorted.getKey() + " : " + symptomSorted.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
