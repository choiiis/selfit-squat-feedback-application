package com.example.selfitjava2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
public class StartFeedbackActivity extends Activity {
    private ImageView feedbackImg1;
    private TextView feedbackMsg1;
    private ImageView feedbackImg2;
    private TextView feedbackMsg2;
    private ImageView feedbackImg3;
    private TextView feedbackMsg3;
    private ImageView feedbackImg4;
    private TextView feedbackMsg4;
    private ImageView feedbackImg5;
    private TextView feedbackMsg5;
    private Typeface typeface = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_feedback);

        feedbackImg1 = (ImageView) findViewById(R.id.feedback_img_1_iv);
        feedbackMsg1 = (TextView) findViewById(R.id.feedback_msg_1_tv);
        feedbackImg2 = (ImageView) findViewById(R.id.feedback_img_2_iv);
        feedbackMsg2 = (TextView) findViewById(R.id.feedback_msg_2_tv);
        feedbackImg3 = (ImageView) findViewById(R.id.feedback_img_3_iv);
        feedbackMsg3 = (TextView) findViewById(R.id.feedback_msg_3_tv);
        feedbackImg4 = (ImageView) findViewById(R.id.feedback_img_4_iv);
        feedbackMsg4 = (TextView) findViewById(R.id.feedback_msg_4_tv);
        feedbackImg5 = (ImageView) findViewById(R.id.feedback_img_5_iv);
        feedbackMsg5 = (TextView) findViewById(R.id.feedback_msg_5_tv);



        RcvMsgThread rcvMsgThread1 = new RcvMsgThread();
        rcvMsgThread1.start();
        try {
            rcvMsgThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rcvMsgThread1");
        String message1 = rcvMsgThread1.getClientMessage();
        feedbackMsg1.setText(message1);


        RcvImgThread rcvImgThread1 = new RcvImgThread();
        rcvImgThread1.start();
        try {
            rcvImgThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rcvImgThread1");
        Bitmap image1 = rcvImgThread1.getClientImage();
        feedbackImg1.setImageBitmap(image1);


        RcvMsgThread rcvMsgThread2 = new RcvMsgThread();
        rcvMsgThread2.start();
        try {
            rcvMsgThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rcvMsgThread2");
        String message2 = rcvMsgThread2.getClientMessage();
        feedbackMsg2.setText(message2);


        RcvImgThread rcvImgThread2 = new RcvImgThread();
        rcvImgThread2.start();
        try {
            rcvImgThread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("rcvImgThread2");
        Bitmap image2 = rcvImgThread2.getClientImage();
        feedbackImg2.setImageBitmap(image2);

        RcvMsgThread rcvMsgThread3 = new RcvMsgThread();
        rcvMsgThread3.start();
        try {
            rcvMsgThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rcvMsgThread3");
        String message3 = rcvMsgThread3.getClientMessage();
        feedbackMsg3.setText(message3);


        RcvImgThread rcvImgThread3 = new RcvImgThread();
        rcvImgThread3.start();
        try {
            rcvImgThread3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("rcvImgThread3");
        Bitmap image3 = rcvImgThread3.getClientImage();
        feedbackImg3.setImageBitmap(image3);


        RcvMsgThread rcvMsgThread4 = new RcvMsgThread();
        rcvMsgThread4.start();
        try {
            rcvMsgThread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rcvMsgThread4");
        String message4 = rcvMsgThread4.getClientMessage();
        feedbackMsg4.setText(message4);


        RcvImgThread rcvImgThread4 = new RcvImgThread();
        rcvImgThread4.start();
        try {
            rcvImgThread4.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("rcvImgThread4");
        Bitmap image4 = rcvImgThread4.getClientImage();
        feedbackImg4.setImageBitmap(image4);


        RcvMsgThread rcvMsgThread5 = new RcvMsgThread();
        rcvMsgThread5.start();
        try {
            rcvMsgThread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("rcvMsgThread5");
        String message5 = rcvMsgThread5.getClientMessage();
        feedbackMsg5.setText(message5);


        RcvImgThread rcvImgThread5 = new RcvImgThread();
        rcvImgThread5.start();
        try {
            rcvImgThread5.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("rcvImgThread5");
        Bitmap image5 = rcvImgThread5.getClientImage();
        feedbackImg5.setImageBitmap(image5);


    }

    class RcvMsgThread extends Thread {

        private String hostAdd;
        private int portNum;
        private String clientMessage;

        public RcvMsgThread() {
            this.hostAdd = "172.20.10.5";
            this.portNum = 57127;
            this.clientMessage = "";
        }


        public void run() {
            try {
                System.out.println("rcvMsg func IN");
                Socket socket = new Socket(hostAdd, portNum);
                System.out.println("SOCKET CONNECTED!!");
                String line = "";
                // 위의 세줄을 한줄로 표현
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 클라이언트로부터 메시지 입력받음
                while ((line = bufferedReader.readLine()) != null)
                    clientMessage = clientMessage + "\r\n" + line;

                System.out.println("----------received from server : " + clientMessage + "  ----------");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("*******SOCKET CONNECT ERROR************");
            }
        }


        public String getClientMessage() {
            System.out.println("getClientMessage message : " + this.clientMessage);
            return this.clientMessage;
        }
    }

    class RcvImgThread extends Thread {

        private String hostAdd;
        private int portNum;
        private Bitmap bitmap;

        public RcvImgThread() {
            this.hostAdd = "172.20.10.5";
            this.portNum = 57127;
            this.bitmap = null;
        }


        public void run() {
            System.out.println("RcvImg IN!!");
            try {
                Socket socket = new Socket(hostAdd, portNum);
                System.out.println("--------SOCKET CONNECTED!!---------");


                byte[] buf = new byte[1024];
                byte[] imageByte = new byte[1024 * 1024 * 32];
                int len, tmp = 0;

                InputStream is = socket.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);

                while(true){
                    if((len = bis.read(buf)) > 0){
                        System.arraycopy(buf, 0, imageByte, tmp, len);
                        tmp += len;
                        System.out.println(tmp);
                    }
                    else
                        break;
                }

                is.close();
                Bitmap tmpBitmap = BitmapFactory.decodeByteArray(imageByte, 0, tmp);
                bitmap = Bitmap.createScaledBitmap(tmpBitmap, 200, 240, true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public Bitmap getClientImage() {
            System.out.println("getClientImage IN");
            return this.bitmap;
        }
    }
}
