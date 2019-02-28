package com.example.dennis.research;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button draw;
    TextView v;
    String[] food ={"蝴蝶漾","阿里郎","四五大街","早餐店","My麵屋","湯饌","美香味","澤食堂","憩賢樓","東京小城","樂山","城市怪獸","大汗","四川","敏忠","波波恰恰","吃的小館","悅來","左撇子","subway","魚麵"};
    int dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        draw = (Button)findViewById(R.id.draw);
        v = (TextView) findViewById(R.id.v);
        draw.setOnClickListener(listener);
    }
    public Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {

            dec = (int)(Math.random()*20);
         String decs= food[dec];
            play(decs);
        }
    };
    public void play(String decs){
        v.setText(decs);
    }
}
