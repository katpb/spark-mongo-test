package com.verifone.isd.vsms2.sys.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This in-memory sequence generator creates continuous sequence numbers from 1
 * to 9999. It rolls back to 1 after 9999. It can also maintain multiple
 * instances of itself for different purposes (instances are identified using 
 * the key 'name' passed to getInstance(String) method).
 */
public class SequenceGenerator implements ISequenceGenerator {
	private static final int SEQUENCE_MIN = 1;
	private static final int SEQUENCE_MAX = 9999;
	private static Map<String, SequenceGenerator> seqGenerators = null;
	private int seqNr;

	private SequenceGenerator() {
		this.seqNr = 0;
	}

	public static synchronized ISequenceGenerator getInstance(String name) {
		SequenceGenerator theInstance = null;
		if (seqGenerators == null) {
			seqGenerators = new ConcurrentHashMap<String, SequenceGenerator>();
		} else {
			theInstance = (SequenceGenerator) seqGenerators.get(name);
		}

		if (theInstance == null) {
			theInstance = new SequenceGenerator();
			seqGenerators.put(name, theInstance);
		}

		return theInstance;
	}

	@Override
	public synchronized long getNext() {
        ++this.seqNr;
        // Set seqNr to minimum, if its out of range.
        if (this.seqNr < SEQUENCE_MIN || this.seqNr > SEQUENCE_MAX) {
            this.seqNr = SEQUENCE_MIN;
        }
        return this.seqNr;
	}

	@Override
	public long getMinimum() {
		return SEQUENCE_MIN;
	}

	@Override
	public long getMaximum() {
		return SEQUENCE_MAX;
	}

	@Override
	public synchronized long getCurrent() {
		 return this.seqNr;
	}

}
