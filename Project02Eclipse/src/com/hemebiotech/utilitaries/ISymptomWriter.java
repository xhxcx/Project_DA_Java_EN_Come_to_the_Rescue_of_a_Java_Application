package com.hemebiotech.utilitaries;

/**
 * Anything that will save data from the symptoms list
 *
 */
public interface ISymptomWriter {

    /**
     * Open a buffer to write in a file
     * @param filepath path of the output file
     */
    void WriteSymptomsToFile (String filepath) throws Exception;
}
