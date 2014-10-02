package com.anhdo.android.vote;

public class Choice {
	private String mDescription;
	private int mVoteCount;
	
	public Choice(String description, int voteCount) {
		mDescription = description;
		mVoteCount = voteCount;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setChoice(String description) {
		mDescription = description;
	}

	public int getVoteCount() {
		return mVoteCount;
	}

	public void setVoteCount(int voteCount) {
		mVoteCount = voteCount;
	}
}