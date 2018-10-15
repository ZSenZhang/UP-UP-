package com.example.apple.camera_face;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.apple.camera_face.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private long end; //闹钟停止的时间（ms）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, com.example.apple.camera_face.Camera2BasicFragment.newInstance())
                    .commit();
        }
/*        end = System.currentTimeMillis();
        Intent intent = new Intent();
//将想要传递的数据用putExtra封装在intent中
        intent.putExtra("end",end);
        setResult(1,intent);
        finish();*/
    }






    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

}
