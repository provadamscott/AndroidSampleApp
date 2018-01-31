package org.providence.webrtcandroid.sampleapp;

import android.view.View;
import android.widget.ImageButton;

public class ToggleImageColorButton extends ImageColorButton {
    private boolean enabled;

    public ToggleImageColorButton(ImageButton imageButton, int color, boolean enabled) {
        super(imageButton, color);
        this.enabled = enabled;
        if(enabled) {
            setColor(R.color.green);
        }
        else {
            setColor(R.color.red);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setOnClickListener(final Runnable onClick) {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.run();
                toggle();
            }
        });
    }

    public void toggle() {
        if(enabled) {
            setColor(R.color.red);
        }
        else {
            setColor(R.color.green);
        }
        enabled = !enabled;
    }
}
