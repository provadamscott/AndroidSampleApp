package org.providence.webrtcandroid.sampleapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.widget.ImageButton;

public class ImageColorButton {
    protected ImageButton imageButton;
    protected Context context;

    public ImageColorButton(ImageButton imageButton, int color) {
        this.imageButton = imageButton;
        this.context = imageButton.getContext();
        DrawableCompat.setTint(imageButton.getDrawable(), ContextCompat.getColor(context, color));
    }

    public void setColor(int color) {
        DrawableCompat.setTint(imageButton.getDrawable(), ContextCompat.getColor(context, color));
    }

    public void setOnClickListener(final Runnable onClick) {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.run();
            }
        });
    }
}
