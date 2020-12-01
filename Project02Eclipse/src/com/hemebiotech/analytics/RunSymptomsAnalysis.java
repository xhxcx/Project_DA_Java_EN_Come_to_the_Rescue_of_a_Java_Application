package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class RunSymptomsAnalysis {
    final static String outputFile = "result.out";

    /**
     *
     * Read from txt file a list of symptoms and list it in a non ordered list
     * Parse the list to create an ordered collection
     * Write the result in a file
     *
     * @param args no args here
     * @throws Exception if there is an error on buffers writing in the output file
     */

    public static void main(String[] args) throws Exception {
        // first get input into a list
        ReadSymptomDataFromFile myReader = new ReadSymptomDataFromFile("./Project02Eclipse/symptoms.txt");
        List<String> symptomsList = myReader.GetSymptoms();

        //Create collection with symptoms name as key and occurrence as value
        AnalyticsCounter mySymptomsCounter = new AnalyticsCounter();
        TreeMap<String, Long> occurrenceBySymptoms = mySymptomsCounter.listOccurrenceBySymptoms(symptomsList);

        // Generate output file from the collection
        WriteSymptomData myWriter = new WriteSymptomData(occurrenceBySymptoms);
        myWriter.WriteSymptomsToFile(outputFile);
    }
}
