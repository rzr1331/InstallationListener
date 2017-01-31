package com.highwaycookie.installationlistener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by jb007 on 27-01-2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, InstallationListenerService.class));
        finish();
    }
}
