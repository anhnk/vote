package com.anhdo.android.vote;

import android.os.Parcel;
import android.os.Parcelable;

public class Choice implements Parcelable {
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mDescription);
		dest.writeInt(mVoteCount);
	}
	
	private void readFromParcel(Parcel in) {
		mDescription = in.readString();
		mVoteCount = in.readInt();
	}
	
	public Choice(Parcel in) {
		readFromParcel(in);
	}
	
	public static final Parcelable.Creator<Choice> CREATOR = new Parcelable.Creator<Choice>() {
		@Override
		public Choice createFromParcel(Parcel source) {
			return new Choice(source);
		}

		@Override
		public Choice[] newArray(int size) {
			return new Choice[size];
		}
	}; 
}