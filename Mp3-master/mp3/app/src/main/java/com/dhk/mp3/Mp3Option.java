package com.dhk.mp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mp3Option extends AppCompatActivity {
    private Button btn1, btn2,btn3,btn4,btn5,btn6,btnOption;
    private TextView txtId;
    private boolean isCheck=false;
    private int uri=0;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp3_option);

        btn1 = findViewById(R.id.bai1);
        btn2 = findViewById(R.id.bai2);
        btn3 = findViewById(R.id.bai3);
        btn4 = findViewById(R.id.bai4);
        btn5 = findViewById(R.id.bai5);
        btn6 = findViewById(R.id.bai6);
        btnOption = findViewById(R.id.option);
        txtId = findViewById(R.id.idBai);

        setOnclickButtonBaiHat(btn1);
        setOnclickButtonBaiHat(btn2);
        setOnclickButtonBaiHat(btn3);
        setOnclickButtonBaiHat(btn4);
        setOnclickButtonBaiHat(btn5);
        setOnclickButtonBaiHat(btn6);

        setOnclickButtonOption();
    }

    private void setOnclickButtonOption(){
        btnOption.setOnClickListener(item->{
            if(isCheck){
                Intent intent = new Intent(Mp3Option.this, MainActivity.class);
                intent.putExtra("id",String.valueOf(txtId.getText()));
                intent.putExtra("name", name);
                intent.putExtra("path",String.valueOf(uri));
                startActivity(intent);
                finish();
            }
        });
    }

    private void setOnclickButtonBaiHat(Button btn){
        btn.setOnClickListener(item->{
            isCheck=true;
            String str =  btn.getText().toString();
            switch (str)
            {
                case "Bài 1":
                    txtId.setText("1");
                    uri= R.raw.aino;
                    name="Ái Nộ";
                    break;
                case "Bài 2":
                    txtId.setText("2");
                    uri= R.raw.cuoithoi;
                    name="Cưới thôi";
                    break;
                case "Bài 3":
                    txtId.setText("3");
                    uri= R.raw.duchocahaidasai;
                    name="Dù cho cả hai đã sai";
                    break;
                case "Bài 4":
                    txtId.setText("4");
                    uri= R.raw.lamvoanhduocchua;
                    name="Làm vợ anh được chưa";
                    break;
                case "Bài 5":
                    txtId.setText("5");
                    uri= R.raw.love08;
                    name="Love 08";
                    break;
                case "Bài 6":
                    txtId.setText("6");
                    uri= R.raw.lovecity;
                    name="Love city";
                    break;
                default: isCheck=false;
            }


        });
    }



}
