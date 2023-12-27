package com.dhk.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOption, btnPlay,btnPause;
    private TextView txtIdBai,txtName,txtTime;
    private String name,stt,cur;
    private  int path,time=0;
    private MediaPlayer mediaPlayer;
    private boolean isCheck= false, isFlag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOption = findViewById(R.id.option1);
        btnPlay = findViewById(R.id.play);
        btnPause = findViewById(R.id.pause);

        txtName = findViewById(R.id.baiHat);
        txtIdBai = findViewById(R.id.idBai1);
        txtTime = findViewById(R.id.textTime);


        if(getIntent().getExtras() != null){
            isCheck=true;
            stt = getIntent().getExtras().get("id").toString();
            name = getIntent().getExtras().get("name").toString();
            cur= getIntent().getExtras().get("path").toString();
            path = Integer.parseInt(cur);

            System.out.println("stt: " + stt);
            // su ly time;
            mediaPlayer = MediaPlayer.create(this,path);
            time=mediaPlayer.getDuration()/1000;
            int minute = time/60;
            int sec = time%60;

            txtIdBai.setText(stt);
            txtName.setText(name);
            txtTime.setText(minute + " min, " + sec +"sec");
        }
        setOnclickButtonPause();
        setOnclickButtonPlay();
        setOnclickOption();


    }

    private void setOnclickOption(){
        btnOption.setOnClickListener(item->{
            // khi chon bai moi thi tat bai hien tai di
            if(isFlag){
                mediaPlayer.stop();
                isFlag=false;
                isCheck=false;
            }
            Intent intent = new Intent(MainActivity.this, Mp3Option.class);
            startActivity(intent);
            finish();
        });
    }

    private void setOnclickButtonPlay(){
        btnPlay.setOnClickListener(item->{
            if(isCheck && isFlag==false){
                mediaPlayer = MediaPlayer.create(this,path);
                mediaPlayer.start();
                isFlag=true;
            }
        });
    }

    private void setOnclickButtonPause(){
        btnPause.setOnClickListener(item->{
            if(isCheck && isFlag){
                mediaPlayer.stop();
                isFlag=false;
            }
        });
    }



}