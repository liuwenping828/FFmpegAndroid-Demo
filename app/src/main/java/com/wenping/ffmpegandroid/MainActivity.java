package com.wenping.ffmpegandroid;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideo = findViewById(R.id.video);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, 100);
        }
    }


    public void play(View view) {
        final String dir = Environment.getExternalStorageDirectory() + File.separator + "DCIM/Camera";
        final String path = dir + File.separator + "VID_20210226_151547.mp4";
//        Toast.makeText(this, path, Toast.LENGTH_LONG).show();
        if (new File(path).exists()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    PlayerNative.play(path, mVideo.getHolder().getSurface());
                }
            });
        } else {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_LONG).show();
//            System.out.println("文件不存在");
        }
    }

    public void stop(View view) {
        PlayerNative.stop();
    }
}
