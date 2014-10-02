package com.anhdo.android.vote;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ChoiceActivity extends ActionBarActivity {
	private EditText mChoiceEditText;
	private Button mAddButton;  

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
    }
    
    private void saveChoice() {
    	
    }
    
    private void showToast(int text) {
    	Toast.makeText(ChoiceActivity.this, text, Toast.LENGTH_SHORT).show();
    }
    
    private void clearEditText() {
    	mChoiceEditText.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.choice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
