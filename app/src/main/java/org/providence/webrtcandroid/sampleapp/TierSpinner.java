package org.providence.webrtcandroid.sampleapp;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class TierSpinner {
    private Spinner spinner;
    private Context context;

    public TierSpinner(Spinner spinner) {
        this.spinner = spinner;
        this.context = spinner.getContext();
        setupTierSpinner();
    }

    public void setupTierSpinner() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                tierSpinnerItemSelected(parent, pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinner.setSelection(0);
            }
        });
    }

    public void tierSpinnerItemSelected(AdapterView<?> parent, int pos) {
        // TODO: Set/change development tier
        TextView selectedView = (TextView)parent.getChildAt(0);
        selectedView.setTextColor(context.getResources().getColor(R.color.offWhite));
        selectedView.setTextSize(15);
        String[] tiers = context.getResources().getStringArray(R.array.tier_array);
        String tier = parent.getItemAtPosition(pos).toString();
        if(!tier.equals(tiers[0])) {
            new CustomToast(parent.getContext(), tier + " is unavailable.").show();
            spinner.setSelection(0);
        }
    }
}
