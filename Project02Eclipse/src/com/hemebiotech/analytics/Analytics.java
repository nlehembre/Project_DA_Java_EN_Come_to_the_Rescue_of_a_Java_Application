package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Analytics {

    public static void main(String args[]) {
        String readFilepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
        String writeFilepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\result.out";

        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(readFilepath);
        ISymptomWriter iSymptomWriter = new WriteSymptomStatsIntoFile(writeFilepath);

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);

        List<String> symptoms;
        try {
            symptoms = analyticsCounter.readSymptoms();
        } catch (IOException e) {
            System.err.println("Error while reading the source of symptoms : " + e);
            return;
        }
        Map<String, Integer> symptomsOccurs = analyticsCounter.countSymptoms(symptoms);

        List<Map.Entry<String,Integer>> symptomsSorted = analyticsCounter.sortSymptoms(symptomsOccurs);

        try {
            analyticsCounter.writeSymptomStats(symptomsSorted);
        } catch (IOException e) {
            System.err.println("Error while writing the analytic list of symptoms : "+ e);
            ;
        }
    }
}
