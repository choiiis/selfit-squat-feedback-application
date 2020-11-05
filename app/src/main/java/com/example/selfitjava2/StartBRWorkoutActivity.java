package com.example.selfitjava2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;


public class StartBRWorkoutActivity extends AppCompatActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String TAG = "android_camera_example";
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //    private static final int CAMERA_FACING = Camera.CameraInfo.CAMERA_FACING_BACK; // Camera.CameraInfo.CAMERA_FACING_FRONT
    private static final int CAMERA_FACING = Camera.CameraInfo.CAMERA_FACING_FRONT;

    private SurfaceView surfaceView;
    private CameraPreview2 mCameraPreview;
    private View mLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 상태바를 안보이도록 합니다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 화면 켜진 상태를 유지합니다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.br_start_workout_activity);

        mLayout = findViewById(R.id.br_layout_main);
        surfaceView = findViewById(R.id.br_camera_preview_main);



        // 런타임 퍼미션 완료될때 까지 화면에서 보이지 않게 해야합니다.
        surfaceView.setVisibility(View.GONE);

        ImageView takePicBtn = findViewById(R.id.br_button_main_capture);

        final MediaPlayer sq1 = MediaPlayer.create(this, R.raw.squats1);
        final MediaPlayer sq2 = MediaPlayer.create(this, R.raw.squats2);
        final MediaPlayer sq3 = MediaPlayer.create(this, R.raw.squats3);
        final MediaPlayer sq4 = MediaPlayer.create(this, R.raw.squats4);
        final MediaPlayer sq5 = MediaPlayer.create(this, R.raw.squats5);

        takePicBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Timer timer = new Timer();


                TimerTask tt6 = new TimerTask() {
                    @Override
                    public void run() {
//                        sq1.start();
                    }
                };
                timer.schedule(tt6, 3000);

                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
//                        sq2.start();
                        mCameraPreview.takePicture();
                        System.out.println("take Picture!");
                    }
                };
                timer.schedule(tt, 8000);

                TimerTask tt2 = new TimerTask() {
                    @Override
                    public void run() {
//                        sq3.start();
                        mCameraPreview.takePicture();
                        System.out.println("take Picture2!");
                    }
                };
                timer.schedule(tt2, 13000);

                TimerTask tt3 = new TimerTask() {
                    @Override
                    public void run() {
//                        sq4.start();
                        mCameraPreview.takePicture();
                        System.out.println("take Picture3!");
                    }
                };
                timer.schedule(tt3, 17800);

                TimerTask tt4 = new TimerTask() {
                    @Override
                    public void run() {
//                        sq5.start();
                        mCameraPreview.takePicture();
                        System.out.println("take Picture4!");
                    }
                };
                timer.schedule(tt4, 22900);

                TimerTask tt5 = new TimerTask() {
                    @Override
                    public void run() {
                        mCameraPreview.takePicture();
                        System.out.println("take Picture5!");
                    }
                };
                timer.schedule(tt5, 27800);
            }
        });

        ImageView showResBtn = findViewById(R.id.br_button_show_result);
        showResBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartBRWorkoutActivity.this, StartFeedbackActivity.class);
                startActivity(intent);
            }
        });



        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

            int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            int writeExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


            if ( cameraPermission == PackageManager.PERMISSION_GRANTED
                    && writeExternalStoragePermission == PackageManager.PERMISSION_GRANTED) {
                startCamera();


            }else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {

                    Snackbar.make(mLayout, "이 앱을 실행하려면 카메라와 외부 저장소 접근 권한이 필요합니다.",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            ActivityCompat.requestPermissions( StartBRWorkoutActivity.this, REQUIRED_PERMISSIONS,
                                    PERMISSIONS_REQUEST_CODE);
                        }
                    }).show();


                } else {
                    // 2. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                    // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                    ActivityCompat.requestPermissions( this, REQUIRED_PERMISSIONS,
                            PERMISSIONS_REQUEST_CODE);
                }

            }

        } else {

            final Snackbar snackbar = Snackbar.make(mLayout, "디바이스가 카메라를 지원하지 않습니다.",
                    Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("확인", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }


    }



    void startCamera(){

        // Create the Preview view and set it as the content of this Activity.
        mCameraPreview = new CameraPreview2(this, this, CAMERA_FACING, surfaceView);

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grandResults) {

        if ( requestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            boolean check_result = true;

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }

            if ( check_result ) {

                startCamera();
            }
            else {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {

                    Snackbar.make(mLayout, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            finish();
                        }
                    }).show();

                }else {

                    Snackbar.make(mLayout, "설정(앱 정보)에서 퍼미션을 허용해야 합니다. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            finish();
                        }
                    }).show();
                }
            }

        }


    }


}
