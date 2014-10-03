package com.anhdo.android.vote;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ChoiceActivity extends ActionBarActivity {
	private EditText mChoiceEditText;
	private Button mAddButton;
	private Button mVoteButton;
	private Button mClearButton;
	private ArrayList<Choice> mChoices = new ArrayList<Choice>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        
        mChoiceEditText = (EditText)findViewById(R.id.choice);
        mAddButton = (Button)findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveChoice();
				showToast(R.string.choice_added_toast);
				clearEditText();
			}
		});
        
        mVoteButton = (Button)findViewById(R.id.vote_button);
        mVoteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(ChoiceActivity.this, VoteActivity.class);
				i.putParcelableArrayListExtra("choice", mChoices);
				startActivity(i);
			}
		});
        
        mClearButton = (Button)findViewById(R.id.clear_button);
        mClearButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mChoices.clear();
			}
		});
    }
    
    private void saveChoice() {
    	Choice choice = new Choice(mChoiceEditText.getText().toString(), 0);
    	mChoices.add(choice);
    }
    
    private void showToast(int text) {
    	Toast.makeText(ChoiceActivity.this, text, Toast.LENGTH_SHORT).show();
    }
    
    private void clearEditText() {
    	mChoiceEditText.setText("");
    }
}
