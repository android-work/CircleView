package com.ancroid.work.circleview;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawGeZiView circleImageView = findViewById(R.id.gezi);
        circleImageView.setGeZiBg(getResources().getColor(R.color.aaaa));
        circleImageView.setGeZiCount(30);
        circleImageView.setFillCount(10);

    }
}
