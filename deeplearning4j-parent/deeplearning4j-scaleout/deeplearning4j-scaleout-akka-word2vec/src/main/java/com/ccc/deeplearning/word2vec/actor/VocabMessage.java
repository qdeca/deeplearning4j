package com.ccc.deeplearning.word2vec.actor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.ccc.deeplearning.berkeley.Counter;
import com.ccc.deeplearning.word2vec.VocabWord;
import com.ccc.deeplearning.word2vec.viterbi.Index;

public class VocabMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6474030463892664765L;
	private List<String> tokens;
	private AtomicLong changeTracker;
	
	public VocabMessage(List<String> tokens,AtomicLong changeTracker) {
		super();
		this.tokens = tokens;
		this.changeTracker = changeTracker;
	}
	
	



	public AtomicLong getChangeTracker() {
		return changeTracker;
	}





	public void setChangeTracker(AtomicLong changeTracker) {
		this.changeTracker = changeTracker;
	}


	
	public List<String> getTokens() {
		return tokens;
	}
	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
	
	
	
}
