package com.hemebiotech.analytics;

import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteSymptomDataInFile implements ISymptomWriter {
    private Map<String, Integer> collectionToWrite;

    public WriteSymptomDataInFile(Map<String, Integer> toWrite){
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
    public void WriteSymptoms(String filepath) throws Exception{
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
