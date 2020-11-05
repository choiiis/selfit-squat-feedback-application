package com.example.selfitjava2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.Socket;

public class ReviewActivity extends Activity {
    private ImageView reviewPic1;
    private ImageView reviewPic2;
    private ImageView reviewPic3;
    private ImageView reviewPic4;
    private ImageView reviewPic5;
    private ImageView reviewPic6;
    private ImageView reviewPic7;
    private ImageView reviewPic8;
    private ImageView reviewPic9;
    private ImageView reviewPic10;
    private ImageView reviewPic11;
    private ImageView reviewPic12;
    private ImageView reviewPic13;
    private ImageView reviewPic14;
    private ImageView reviewPic15;
    private ImageView reviewPic16;
    private ImageView reviewPic17;
    private ImageView reviewPic18;
    private ImageView reviewPic19;
    private ImageView reviewPic20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_main);

        reviewPic1 = (ImageView) findViewById(R.id.review_pic_1);
        reviewPic2 = (ImageView) findViewById(R.id.review_pic_2);
        reviewPic3 = (ImageView) findViewById(R.id.review_pic_3);
        reviewPic4 = (ImageView) findViewById(R.id.review_pic_4);
        reviewPic5 = (ImageView) findViewById(R.id.review_pic_5);
        reviewPic6 = (ImageView) findViewById(R.id.review_pic_6);
        reviewPic7 = (ImageView) findViewById(R.id.review_pic_7);
        reviewPic8 = (ImageView) findViewById(R.id.review_pic_8);
        reviewPic9 = (ImageView) findViewById(R.id.review_pic_9);
        reviewPic10 = (ImageView) findViewById(R.id.review_pic_10);
        reviewPic11 = (ImageView) findViewById(R.id.review_pic_11);
        reviewPic12 = (ImageView) findViewById(R.id.review_pic_12);
        reviewPic13 = (ImageView) findViewById(R.id.review_pic_13);
        reviewPic14 = (ImageView) findViewById(R.id.review_pic_14);
        reviewPic15 = (ImageView) findViewById(R.id.review_pic_15);
        reviewPic16 = (ImageView) findViewById(R.id.review_pic_16);
        reviewPic17 = (ImageView) findViewById(R.id.review_pic_17);
        reviewPic18 = (ImageView) findViewById(R.id.review_pic_18);
        reviewPic19 = (ImageView) findViewById(R.id.review_pic_19);
        reviewPic20 = (ImageView) findViewById(R.id.review_pic_20);



//        File file = new File("/.jpg");
        Drawable drawable1 = getResources().getDrawable(R.drawable.pic1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.pic2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.pic3);
        Drawable drawable4 = getResources().getDrawable(R.drawable.pic4);
        Drawable drawable5 = getResources().getDrawable(R.drawable.pic5);
        Drawable drawable6 = getResources().getDrawable(R.drawable.pic6);
        Drawable drawable7 = getResources().getDrawable(R.drawable.pic7);
        Drawable drawable8 = getResources().getDrawable(R.drawable.pic8);
        Drawable drawable9 = getResources().getDrawable(R.drawable.pic9);
        Drawable drawable10 = getResources().getDrawable(R.drawable.pic10);
        Drawable drawable11 = getResources().getDrawable(R.drawable.pic11);
        Drawable drawable12 = getResources().getDrawable(R.drawable.pic12);
        Drawable drawable13 = getResources().getDrawable(R.drawable.pic13);
        Drawable drawable14 = getResources().getDrawable(R.drawable.pic14);
        Drawable drawable15 = getResources().getDrawable(R.drawable.pic15);
        Drawable drawable16 = getResources().getDrawable(R.drawable.pic16);
        Drawable drawable17 = getResources().getDrawable(R.drawable.pic17);
        Drawable drawable18 = getResources().getDrawable(R.drawable.pic18);
        Drawable drawable19 = getResources().getDrawable(R.drawable.pic19);
        Drawable drawable20 = getResources().getDrawable(R.drawable.pic20);

        reviewPic1.setImageDrawable(drawable1);
        reviewPic2.setImageDrawable(drawable2);
        reviewPic3.setImageDrawable(drawable3);
        reviewPic4.setImageDrawable(drawable4);
        reviewPic5.setImageDrawable(drawable5);
        reviewPic6.setImageDrawable(drawable6);
        reviewPic7.setImageDrawable(drawable7);
        reviewPic8.setImageDrawable(drawable8);
        reviewPic9.setImageDrawable(drawable9);
        reviewPic10.setImageDrawable(drawable10);
        reviewPic11.setImageDrawable(drawable11);
        reviewPic12.setImageDrawable(drawable12);
        reviewPic13.setImageDrawable(drawable13);
        reviewPic14.setImageDrawable(drawable14);
        reviewPic15.setImageDrawable(drawable15);
        reviewPic16.setImageDrawable(drawable16);
        reviewPic17.setImageDrawable(drawable17);
        reviewPic18.setImageDrawable(drawable18);
        reviewPic19.setImageDrawable(drawable19);
        reviewPic20.setImageDrawable(drawable20);



//        if(file.exists()){
//            System.out.println("IN");
//            Bitmap bitmap1 = BitmapFactory.decodeFile(file.getAbsolutePath());
//            reviewPic1.setImageBitmap(bitmap1);
//        }

//        reviewPic1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                Bundle bundle = intent.getExtras();
//                Intent newIntent = new Intent(ReviewActivity.this, StartWorkoutActivity.class);
//                newIntent.putExtras(bundle);
//                startActivity(newIntent);
//            }
//        });
    }
}
