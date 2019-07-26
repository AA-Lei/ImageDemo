package com.example.imagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image_viewByid;
    private TextView name_viewByid;
    private String[] name;
    private int[] imageid;
    private int i_num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //问
        //Log.d("init","ok");
        init();
    }

    private void init() {
        name = new String[]{"第一张","第二张","第三张","第四张"};
        imageid = new int[]{R.mipmap.bizhi01,R.mipmap.bizhi02,R.mipmap.bizhi03,R.mipmap.bizhi04};
        i_num = 0;
        Log.d("log",String.valueOf(name.length));

        image_viewByid = findViewById(R.id.imageshow);
        name_viewByid = findViewById(R.id.imagename);

        image_viewByid.setImageResource(imageid[i_num]);
        name_viewByid.setText(name[i_num]);

        findViewById(R.id.previous).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.previous:
                i_num--;
                if(i_num<0){
                    i_num = imageid.length;
                }
                break;
            case R.id.next:
                i_num++;
                if(i_num>=imageid.length){
                     i_num = 0;
                }
                break;
        }
        update();
    }

    private void update() {
        image_viewByid.setImageResource(imageid[i_num]);
        name_viewByid.setText(name[i_num]);
    }

}
