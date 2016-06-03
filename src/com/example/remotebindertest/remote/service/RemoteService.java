package com.example.remotebindertest.remote.service;

import com.example.remotebindertest.aidl.RemoteCaculateBinder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class RemoteService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return mRemoteCaculateBinder;
	}

	public Binder mRemoteCaculateBinder = new RemoteCaculateBinder.Stub() {

		@Override
		public void add(int arg0, int arg1) throws RemoteException {
			System.out.println("RemoteCaculateBinder = "
					+ String.valueOf(arg0 + arg1));
		}
	};
}
