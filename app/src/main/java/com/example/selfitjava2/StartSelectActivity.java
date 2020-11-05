package com.example.selfitjava2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartSelectActivity extends Activity{
    private ImageView ivStartSqSd;
    private ImageView ivStartBtRw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_select_activity);

        ivStartSqSd = (ImageView) findViewById(R.id.start_select_squats_side_iv);
        ivStartBtRw = (ImageView) findViewById(R.id.start_select_bent_row_iv);

        ivStartSqSd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                Intent newIntent = new Intent(StartSelectActivity.this, StartManualActivity.class);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }
        });

        ivStartBtRw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                Intent newIntent = new Intent(StartSelectActivity.this, StartBRManualActivity.class);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }
        });
    }
}
