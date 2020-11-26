package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Get an exhaustive and non ordered list of symptoms as parameter
 * parse each element of this list to build an alphabetical ordered Map with symptom as key and occurrence as value without duplicate entry
 *
 * @param symptomsList listing of all Symptoms duplicates are possible/probable
 * @return TreeMap with symptom as key and occurrence as value with no more duplicates
 */
public interface IAnalyticsCounter {
    TreeMap<String, Integer> listOccurrenceBySymptoms (List<String> symptomsList);
}
