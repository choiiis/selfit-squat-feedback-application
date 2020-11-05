package com.example.selfitjava2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartBRManualActivity extends Activity {
    private ImageView btnStartBtRw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_bent_row_manual);

        btnStartBtRw = (ImageView) findViewById(R.id.start_bent_row_start_btn);

        btnStartBtRw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                Intent newIntent = new Intent(StartBRManualActivity.this, StartBRWorkoutActivity.class);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }
        });
    }
}
