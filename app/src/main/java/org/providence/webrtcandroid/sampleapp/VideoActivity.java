package org.providence.webrtcandroid.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class VideoActivity extends AppCompatActivity {

    private TierSpinner tierSpinner;
    private EditText confEditText;
    private EgressCamera egressCamera;
    private CameraPreview egressPreview;
    private FrameLayout egressLayout;
    private IngressVideo ingressVideo;
    private FrameLayout ingressLayout;
    private TextView stateView;
    private ToggleImageColorButton cameraButton;
    private ToggleImageColorButton micButton;
    private ImageColorButton chatButton;
    private ToggleImageColorButton phoneButton;
    private boolean inCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        tierSpinner = new TierSpinner((Spinner) findViewById(R.id.tier_spinner));
        confEditText = findViewById(R.id.conf_edit_text);
        stateView = findViewById(R.id.state_text_view);
        cameraButton = new ToggleImageColorButton((ImageButton) findViewById(R.id.camera_button), R.color.green, true);
        micButton = new ToggleImageColorButton((ImageButton) findViewById(R.id.mic_button), R.color.green, true);
        chatButton = new ImageColorButton((ImageButton) findViewById(R.id.chat_button), R.color.yellow);
        phoneButton = new ToggleImageColorButton((ImageButton) findViewById(R.id.phone_button), R.color.green, true);
        ingressLayout = findViewById(R.id.ingress_layout);
        ingressVideo = new IngressVideo(ingressLayout);
        egressCamera = new EgressCamera();
        egressPreview = new CameraPreview(this, egressCamera.getCamera());
        egressLayout = findViewById(R.id.egress_layout);

        setupImageColorButtons();
        ingressVideo.addIngressVideoToLayout();
        egressCamera.addCameraPreviewToLayout(egressPreview, egressLayout);
    }

    public void setupImageColorButtons() {
        cameraButton.setOnClickListener(new Runnable() {
            @Override
            public void run() {
                if(inCall) {
                    if (cameraButton.isEnabled()) {
                        disableCamera();
                    } else {
                        enableCamera();
                    }
                }
            }
        });
        micButton.setOnClickListener(new Runnable() {
            @Override
            public void run() {
                // TODO: Turn off mic
            }
        });
        chatButton.setOnClickListener(new Runnable() {
            @Override
            public void run() {
                // TODO: Switch to chat mode
            }
        });
        phoneButton.setOnClickListener(new Runnable() {
            @Override
            public void run() {
                if(phoneButton.isEnabled()) {
                    startCall();
                }
                else {
                    endCall();
                }
            }
        });
    }

    public void enableCamera() {
        // TODO: Enable egress camera feed
        egressLayout.setVisibility(View.VISIBLE);
    }

    public void disableCamera() {
        // TODO: Disable egress camera feed
        egressLayout.setVisibility(View.INVISIBLE);
    }

    public void startCall() {
        // TODO: Start conference call
        inCall = true;
        String confId = confEditText.getText().toString();
        if(!confId.equals("")) {
            if (cameraButton.isEnabled()) {
                egressLayout.setVisibility(View.VISIBLE);
            } else {
                egressLayout.setVisibility(View.INVISIBLE);
            }
            ingressLayout.setVisibility(View.VISIBLE);
            stateView.setText(R.string.connected_text);
        }
        else {
            phoneButton.toggle();
            new CustomToast(getApplicationContext(), "Please enter a conference id").show();
        }
    }

    public void endCall() {
        // TODO: End conference call
        inCall = false;
        egressLayout.setVisibility(View.INVISIBLE);
        ingressLayout.setVisibility(View.INVISIBLE);
        stateView.setText(R.string.disconnected_text);
    }
}
