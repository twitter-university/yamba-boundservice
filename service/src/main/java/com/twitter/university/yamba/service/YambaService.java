package com.twitter.university.yamba.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.marakana.android.yamba.clientlib.YambaClient;

public class YambaService extends Service {
    private IYambaServiceImpl iYambaServiceImpl;
    @Override
    public void onCreate() {
        super.onCreate();
        final YambaClient yambaClient = new YambaClient("student", "password");
        this.iYambaServiceImpl = new IYambaServiceImpl(yambaClient);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return this.iYambaServiceImpl;
    }
}
