package com.highwaycookie.installationlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jb007 on 27-01-2017.
 */


public class InstallationReceiver extends BroadcastReceiver {
    private final String TAG = "InstallationReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"onReceive with action : "+intent.getAction());

        switch(intent.getAction()){
            case Intent.ACTION_BOOT_COMPLETED:
                try{
                    Intent intentForService = new Intent(context.getApplicationContext(), InstallationListenerService.class);
                    context.startService(intentForService);
                }catch(Exception e){
                    Log.e(TAG,"Exception while starting the installation listener service : "+e.toString());
                    e.printStackTrace();
                }
                break;
            default:
                Intent launchSereneIntent = context.getPackageManager().getLaunchIntentForPackage("com.highwaycookie.serene");
                context.startActivity(launchSereneIntent);
                break;
        }

    }
}
