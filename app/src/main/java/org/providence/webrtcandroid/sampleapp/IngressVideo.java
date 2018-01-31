package org.providence.webrtcandroid.sampleapp;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class IngressVideo {
    private FrameLayout layout;
    private Context context;

    public IngressVideo(FrameLayout layout) {
        this.layout = layout;
        this.context = layout.getContext();
    }

    public void addIngressVideoToLayout() {
        layout.setVisibility(View.INVISIBLE);
        ImageView image = new ImageView(context);
        image.setImageResource(R.drawable.picture);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        layout.addView(image);
    }
}
