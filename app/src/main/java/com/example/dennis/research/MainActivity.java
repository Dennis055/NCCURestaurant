package com.example.dennis.research;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button draw,list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(Button)findViewById(R.id.list);
        draw=(Button)findViewById(R.id.draw);

        list.setOnClickListener(listener1);
        draw.setOnClickListener(listener2);
    }
    Button.OnClickListener listener1 =new Button.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Main1Activity.class);
            startActivity(intent);
        }
    };
    Button.OnClickListener listener2 =new Button.OnClickListener(){
        public void onClick(View v){
            Intent i = new Intent();
            i.setClass(MainActivity.this,Main2Activity.class);
            startActivity(i);
        }
    };
}
