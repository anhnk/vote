package com.anhdo.android.vote;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CountFragment extends ListFragment {
	private ArrayList<Choice> mChoices;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mChoices = getActivity().getIntent().getParcelableArrayListExtra("vote");
		CountAdapter adapter = new CountAdapter(mChoices);
		setListAdapter(adapter);
	}
	
	private class CountAdapter extends ArrayAdapter<Choice> {
		public CountAdapter(ArrayList<Choice> choices) {
			super(getActivity(), 0, choices);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
					.inflate(R.layout.fragment_count, null);
			}
			
			Choice choice = getItem(position);
			TextView choiceDescription = 
				(TextView)convertView.findViewById(R.id.choice);
			choiceDescription.setText(choice.getDescription());
			
			TextView choiceCount =
				(TextView)convertView.findViewById(R.id.count);
			choiceCount.setText(String.valueOf(choice.getVoteCount()) + " vote(s)");
			
			return convertView;
		}
	}
}
