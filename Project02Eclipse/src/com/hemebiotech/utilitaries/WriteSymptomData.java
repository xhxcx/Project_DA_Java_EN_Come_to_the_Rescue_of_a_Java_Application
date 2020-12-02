package com.hemebiotech.utilitaries;

import java.util.TreeMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

/**
 * Allow to export a map
 *
 */

public class WriteSymptomData implements ISymptomWriter {
    private TreeMap<String, Long> collectionToWrite;

    /**
     * Construct a writing objet from the map to export
     *
     * @param mapToWrite sorted map to export
     */
    public WriteSymptomData(TreeMap<String, Long> mapToWrite){
        this.collectionToWrite= mapToWrite;
    }

    /**
     * Export the map into a file
     *
     * Initialize a buffer then parse the map to write each line into the output file
     *
     * @param filepath path of the output file
     * @throws Exception and print step where error occurred
     *
     */
    @Override
    public void WriteSymptomsToFile(String filepath) throws Exception{

        try (BufferedWriter bufferWriteOutput = new BufferedWriter(new FileWriter(filepath))) {
            for (Map.Entry<String, Long> entry : collectionToWrite.entrySet()){
                bufferWriteOutput.write(entry.getKey() + " = " + entry.getValue());
                bufferWriteOutput.newLine();
            }
        } catch (Exception e) {
            System.err.println("An error occurred writing into the file " + filepath);
        }
    }
}
