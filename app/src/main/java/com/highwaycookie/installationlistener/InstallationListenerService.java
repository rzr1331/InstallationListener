package com.highwaycookie.installationlistener;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jb007 on 27-01-2017.
 */


public class InstallationListenerService extends Service {

    private final String TAG = "InstallationListenerService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_INSTALL");
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        registerReceiver(receiver,filter);

        Log.d(TAG,"onReceive action registered for broadcast action installation changes");

        return Service.START_STICKY;
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG,"onReceive action : "+intent.getAction());
            Intent launchSereneIntent = context.getPackageManager().getLaunchIntentForPackage("com.highwaycookie.serene");
            context.startActivity(launchSereneIntent);
        }
    };
}
