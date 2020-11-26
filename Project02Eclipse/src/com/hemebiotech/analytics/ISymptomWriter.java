package com.hemebiotech.analytics;

/**
 * Anything that will save data from the symptoms list
 *
 */
public interface ISymptomWriter {

    /**
     * Open a buffer to write in a file
     * @param filepath path of the output file
     */
    void BuildSymptomsOutputFile (String filepath) throws Exception;
}
