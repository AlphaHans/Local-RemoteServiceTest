package com.example.remotebindertest.local.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.remotebindertest.R;
import com.example.remotebindertest.aidl.RemoteCaculateBinder.Stub;
import com.example.remotebindertest.local.service.LocalService;
import com.example.remotebindertest.local.service.LocalService.LocalCaculateBinder;
import com.example.remotebindertest.remote.service.RemoteService;

public class LocalTestActivity extends Activity {
	private EditText mAddOne, mAddTwo;
	private Button mAdd;
	private ServiceConnection mServiceConnection;
	private LocalService.LocalCaculateBinder mLocalCaculateBinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initService();
		initView();
	}

	private void initView() {
		mAddOne = (EditText) findViewById(R.id.main_et_one);
		mAddTwo = (EditText) findViewById(R.id.main_et_two);
		mAdd = (Button) findViewById(R.id.main_btn_add);
		mAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mLocalCaculateBinder.add(
						Integer.valueOf(mAddOne.getText().toString()),
						Integer.valueOf(mAddTwo.getText().toString()));
			}
		});
	}

	private void initService() {
		mServiceConnection = new ServiceConnection() {

			@Override
			public void onServiceDisconnected(ComponentName name) {
			}

			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				mLocalCaculateBinder = (LocalCaculateBinder) service;
			}
		};
		Intent i = new Intent(this, LocalService.class);
		bindService(i, mServiceConnection, BIND_AUTO_CREATE);
	}

}
