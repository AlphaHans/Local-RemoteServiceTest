package com.example.remotebindertest;

import com.example.remotebindertest.local.activity.LocalTestActivity;
import com.example.remotebindertest.remote.activity.RemoteTestActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ChoseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chose);
		findViewById(R.id.chose_btn_local).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent i = new Intent(ChoseActivity.this,
								LocalTestActivity.class);
						startActivity(i);
					}
				});
		findViewById(R.id.chose_btn_remote).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent i = new Intent(ChoseActivity.this,
								RemoteTestActivity.class);
						startActivity(i);
					}
				});
	}
}
