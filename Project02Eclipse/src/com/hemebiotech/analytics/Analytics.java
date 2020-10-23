package com.hemebiotech.analytics;

public class Analytics {
    public static void main(String args[]) throws Exception {
        String filepath = "C:\\Users\\LEHEMBR\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(filepath);

        analyticsCounter.readSymptoms();
        analyticsCounter.countSymptoms();
//        analyticsCounter.sortSymptoms();
        analyticsCounter.writeSymptomStats();
    }
}
