package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Analytics {
    public static void main(String args[]) throws Exception {
        String readFilepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
        String writeFilepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\result.out";

        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(readFilepath);
        ISymptomWriter iSymptomWriter = new WriteSymptomStatsIntoFile(writeFilepath);

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);

        List<String> symptoms = analyticsCounter.readSymptoms();

        Map<String, Integer> symptomsOccurs = analyticsCounter.countSymptoms(symptoms);

        Set<Map.Entry<String,Integer>> symptomsSorted = analyticsCounter.sortSymptoms(symptomsOccurs);

        analyticsCounter.writeSymptomStats(symptomsSorted);
    }
}
