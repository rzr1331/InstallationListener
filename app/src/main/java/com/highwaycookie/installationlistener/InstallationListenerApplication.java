package com.highwaycookie.installationlistener;

import android.app.Application;
import android.content.Intent;

/**
 * Created by jb007 on 27-01-2017.
 */

public class InstallationListenerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, InstallationListenerService.class));
    }
}
