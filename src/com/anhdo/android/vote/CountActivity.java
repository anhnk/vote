package com.anhdo.android.vote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

public class CountActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count);
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.CountFragmentContainer);
		
		if (fragment == null) {
			fragment = new CountFragment();
			fm.beginTransaction()
			    .add(R.id.CountFragmentContainer, fragment)
			    .commit();
		}
	}
}
