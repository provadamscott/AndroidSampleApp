package org.providence.webrtcandroid.sampleapp;

import android.content.Context;
import android.view.Gravity;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by adam on 1/31/18.
 */

public class CustomToast {
    Toast toast;

    public CustomToast(Context context, String message) {
        toast = Toast.makeText(context,
                message,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 500);
    }

    public void show() {
        toast.show();
    }
}
