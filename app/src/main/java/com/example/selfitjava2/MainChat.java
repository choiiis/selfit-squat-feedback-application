package com.example.selfitjava2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainChat extends Activity{

//    private EditText host, port, name;
//    private Button btn;
    private String hostv, namev;
    private ImageView startbtn, goalbtn, revbtn;
    private int portv;

    protected void onCreate(Bundle save) {
        super.onCreate(save);
        setContentView(R.layout.chat01);
//        host = (EditText)findViewById(R.id.chat_host);
//        port = (EditText)findViewById(R.id.chat_port);
//        name = (EditText)findViewById(R.id.chat_name);
//        btn = (Button)findViewById(R.id.chat_btn);

        startbtn = (ImageView)findViewById(R.id.start_btn);
        goalbtn = (ImageView)findViewById(R.id.goal_btn);
        revbtn = (ImageView)findViewById(R.id.rev_btn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                hostv = host.getText().toString().trim();
//                portv = Integer.parseInt(port.getText().toString().trim());
//                namev = name.getText().toString().trim();
                hostv = "192.168.1.75";
                portv = Integer.parseInt("57128");
                namev = "haemin";

//                Intent intent = new Intent(MainChat.this, ChatRoom.class);
                Intent intent = new Intent(MainChat.this, StartSelectActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("host", hostv);
                bundle.putString("name", namev);
                bundle.putInt("port", portv);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        goalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainChat.this, GoalMonthActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        revbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainChat.this, ReviewActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}