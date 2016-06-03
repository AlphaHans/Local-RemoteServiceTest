package com.example.remotebindertest.local.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class LocalService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new LocalCaculateBinder();
	}

	public static class LocalCaculateBinder extends Binder {
		public void add(int arg0, int arg1) {
			System.out.println("CaculateBinder = "
					+ String.valueOf(arg0 + arg1));
		}
	}
}