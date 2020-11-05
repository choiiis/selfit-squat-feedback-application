package com.example.selfitjava2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GoalMonthActivity extends Activity {
    private ImageView ivGoalCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_cal);

        ivGoalCal = (ImageView) findViewById(R.id.goal_cal_iv);

        ivGoalCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                Intent newIntent = new Intent(GoalMonthActivity.this, GoalDayActivity.class);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }
        });
    }
}

