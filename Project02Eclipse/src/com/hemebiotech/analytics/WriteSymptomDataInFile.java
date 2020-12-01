package com.hemebiotech.analytics;

import java.util.TreeMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

/**
 * Allow to export a map in a file
 *
 */

public class WriteSymptomDataInFile implements ISymptomWriter {
    private TreeMap<String, Long> collectionToWrite;

    /**
     *
     * @param mapToWrite sorted map to export
     */
    public WriteSymptomDataInFile(TreeMap<String, Long> mapToWrite){
        this.collectionToWrite= mapToWrite;
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
            for (Map.Entry<String, Long> entry : collectionToWrite.entrySet()){
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
