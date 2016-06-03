package com.example.remotebindertest.remote.activity;

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
import com.example.remotebindertest.R.id;
import com.example.remotebindertest.R.layout;
import com.example.remotebindertest.aidl.RemoteCaculateBinder;
import com.example.remotebindertest.remote.service.RemoteService;

public class RemoteTestActivity extends Activity {
	private EditText mAddOne, mAddTwo;
	private Button mAdd;
	private ServiceConnection mServiceConnection;
	private RemoteCaculateBinder mRemoteCaculateBinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initService();
		mAddOne = (EditText) findViewById(R.id.main_et_one);
		mAddTwo = (EditText) findViewById(R.id.main_et_two);
		mAdd = (Button) findViewById(R.id.main_btn_add);
		mAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					mRemoteCaculateBinder.add(
							Integer.valueOf(mAddOne.getText().toString()),
							Integer.valueOf(mAddTwo.getText().toString()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
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
				mRemoteCaculateBinder = RemoteCaculateBinder.Stub.asInterface(service);
			}
		};
		Intent i = new Intent(this, RemoteService.class);
		bindService(i, mServiceConnection, BIND_AUTO_CREATE);
	}
}
