package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analytics {
    public static void main(String args[]) throws Exception {
        String readFilepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
        String writeFilepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\result.out";

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(readFilepath, writeFilepath);

        List<String> symptoms = analyticsCounter.readSymptoms();

        Map<String, Integer> symptomsOccurs = analyticsCounter.countSymptoms(symptoms);

        analyticsCounter.writeSymptomStats(symptomsOccurs);
    }
}
