package com.hemebiotech.analytics;

import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteSymptomData implements ISymptomWriter {
    private Map<String, Integer> collectionToWrite;

    public WriteSymptomData(Map<String, Integer> toWrite){
        this.collectionToWrite=toWrite;
    }

    /**
     * Initialize a buffer then parse the map to write each line into the output file
     *
     * @param filepath path of the output file
     * @throws Exception and print step where error occurred
     *
     */
    @Override
    public void BuildSymptomsOutputFile(String filepath) throws Exception{
        BufferedWriter bufferWriteOutput = null;
        try {
            FileWriter writer = new FileWriter (filepath);
            bufferWriteOutput = new BufferedWriter(writer);
            for (Map.Entry<String, Integer> entry : collectionToWrite.entrySet()){
                try {
                    bufferWriteOutput.write(entry.getKey() + " = " + entry.getValue());
                    bufferWriteOutput.newLine();
                }catch (Exception e){
                    System.out.println("An error occurred writing the line " + entry);
                }
            }
            bufferWriteOutput.flush();
            bufferWriteOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred on buffer initialization ");
        }
    }
}
