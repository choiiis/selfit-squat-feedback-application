package com.example.selfitjava2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartManualActivity extends Activity {
    private ImageView btnStartSqSd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_squats_side_manual);

        btnStartSqSd = (ImageView) findViewById(R.id.start_squats_side_start_btn);

        btnStartSqSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                Intent newIntent = new Intent(StartManualActivity.this, StartWorkoutActivity.class);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }
        });
    }
}
