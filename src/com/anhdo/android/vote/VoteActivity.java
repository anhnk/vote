package com.anhdo.android.vote;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VoteActivity extends ActionBarActivity {
	private ArrayList<Choice> mChoices;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vote);
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.voteFragmentContainer);
		
		if (fragment == null) {
			fragment = new VoteFragment();
			fm.beginTransaction()
				.add(R.id.voteFragmentContainer, fragment)
				.commit();
		}
		
		mChoices = getIntent().getParcelableArrayListExtra("choice");
	}
	
	public void myClickHandler(View v) {
		LinearLayout vwParentRow = (LinearLayout)v.getParent();
		TextView child = (TextView)vwParentRow.getChildAt(0);
        
        for (Choice choice : mChoices) {
        	if (choice.getDescription() == child.getText()) {
        		choice.setVoteCount(choice.getVoteCount() + 1);
        	}
        }
	}
}
