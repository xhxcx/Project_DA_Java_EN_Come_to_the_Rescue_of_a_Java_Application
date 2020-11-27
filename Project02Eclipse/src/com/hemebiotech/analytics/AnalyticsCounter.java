package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

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
	public TreeMap<String, Integer> listOccurrenceBySymptoms(List<String> symptomsList) {
		TreeMap<String, Integer> occurrenceBySymptoms = new TreeMap<String, Integer>();
		if (symptomsList != null) {
			for (String currentKey : symptomsList) {
				System.out.println(currentKey);
				if (!occurrenceBySymptoms.containsKey(currentKey)) {
					occurrenceBySymptoms.put(currentKey, 1);
				} else {
					int count = occurrenceBySymptoms.get(currentKey);
					count++;
					System.out.println(count);
					occurrenceBySymptoms.replace(currentKey, count);
				}
			}
		}
		return occurrenceBySymptoms;
	}
}
