package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Implementation to allow analysis
 *
 */
public class AnalyticsCounter implements IAnalyticsCounter{
	public AnalyticsCounter() {
	}

	/**
	 * Get an exhaustive and non ordered list of symptoms as parameter
	 * parse each element of this list to build an alphabetical ordered Map with symptom as key and occurrence as value without duplicate entry
	 *
	 * @param symptomsList listing of all Symptoms duplicates are possible/probable
	 * @return TreeMap with symptom as key and occurrence as value with no more duplicates
	 */

	@Override
	public TreeMap<String, Long> listOccurrenceBySymptoms(List<String> symptomsList) {
        TreeMap<String, Long> occurrenceBySymptoms = null;
		if (symptomsList != null) {
            occurrenceBySymptoms = new TreeMap<String,Long>(symptomsList.stream().collect(Collectors.groupingBy(symptom -> symptom, Collectors.counting())));
		}
		return occurrenceBySymptoms;
	}
}
