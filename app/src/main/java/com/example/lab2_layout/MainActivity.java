package com.example.lab2_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Ed_name;
    private TextView Hint,Username,winner,us,computer;
    private RadioButton RB0,RB1,RB2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ed_name = findViewById(R.id.Ed_name);
        Hint = findViewById(R.id.Hint);
        Username = findViewById(R.id.Username);
        winner = findViewById(R.id.winner);
        us = findViewById(R.id.us);
        computer = findViewById(R.id.computer);
        RB0 = findViewById(R.id.RB0);
        RB1 = findViewById(R.id.RB1);
        RB2 = findViewById(R.id.RB2);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {

                if(Ed_name.length() < 1){
                    Hint.setText("請輸入玩家姓名");
                } else {
                    Username.setText(String.format("名字\n%s",Ed_name.getText().toString()));
                    if(RB0.isChecked()){
                        us.setText("我方出拳\n剪刀");
                    } else if(RB1.isChecked()){
                        us.setText("我方出拳\n石頭");
                    }else{
                        us.setText("我方出拳\n抹布");
                    }

                    int random = (int) (Math.random() *3);

                    if(random == 0){
                        computer.setText("電腦出拳\n剪刀");
                    } else if(random == 1){
                        computer.setText("電腦出拳\n石頭");
                    }else {
                        computer.setText("電腦出拳\n抹布");
                    }

                    if((RB0.isChecked() && random ==2) || (RB1.isChecked() && random == 0) || (RB2.isChecked() && random == 1)){
                        winner.setText("勝利者\n"+ Ed_name.getText().toString());
                        Hint.setText("恭喜您獲勝了");
                    } else if ((RB0.isChecked() && random ==1) || (RB1.isChecked() && random == 2) || (RB2.isChecked() && random == 0)){
                        winner.setText("勝利者\n電腦");
                        Hint.setText("可惜，電腦獲勝了。");
                    }else{
                        winner.setText("勝利者\n平手");
                        Hint.setText("平局，再來一局吧。");
                    }

                }
        });

    }
}