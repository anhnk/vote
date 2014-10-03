package com.anhdo.android.vote;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VoteActivity extends ActionBarActivity {
	private ArrayList<Choice> mChoices;
	private Button mCountButton;
	
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
		
		mCountButton = (Button)findViewById(R.id.count_vote_button);
        mCountButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(VoteActivity.this, CountActivity.class);
				i.putParcelableArrayListExtra("vote", mChoices);
				startActivity(i);
			}
		});
	}
	
	public void myClickHandler(View v) {
		LinearLayout vwParentRow = (LinearLayout)v.getParent();
		TextView child = (TextView)vwParentRow.getChildAt(0);
        
        for (Choice choice : mChoices) {
        	if (choice.getDescription() == child.getText()) {
        		choice.setVoteCount(choice.getVoteCount() + 1);
        	}
        }
        
        Toast.makeText(VoteActivity.this,
        			   R.string.thanks_vote_toast,
        			   Toast.LENGTH_SHORT).show();
	}
}
