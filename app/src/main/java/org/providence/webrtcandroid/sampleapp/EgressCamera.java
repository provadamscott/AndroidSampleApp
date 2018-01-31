package org.providence.webrtcandroid.sampleapp;

import android.hardware.Camera;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import static android.content.ContentValues.TAG;

public class EgressCamera {
    private Camera camera;

    public EgressCamera() {
        camera = null;
        try {
            releaseCamera();
            camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT); // attempt to get a Camera instance
            camera.setDisplayOrientation(90);
        }
        catch (Exception e){
            Log.d(TAG, "Error opening camera: " + e.getMessage());
        }
    }

    public Camera getCamera() {
        return camera;
    }

    private void releaseCamera() {
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }

    public void addCameraPreviewToLayout(CameraPreview preview, FrameLayout layout) {
        layout.addView(preview);
        layout.setForegroundGravity(Gravity.CENTER);
        layout.setVisibility(View.INVISIBLE);
        if(camera != null) {
            setLayoutAspectRatio(layout, getCameraAspectRatio());
        }
    }

    public double getCameraAspectRatio() {
        Camera.Size size = camera.getParameters().getPictureSize();
        int cameraHeight = size.height;
        int cameraWidth = size.width;
        return (double)cameraHeight / (double)cameraWidth;
    }

    public void setLayoutAspectRatio(FrameLayout layout, double aspectRatio) {
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = (int)(params.width / aspectRatio);
        layout.setLayoutParams(params);
    }
}
