package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo, mode;
    EditText etInput;
    Button bControl, exit, hardMode, easyMode;
    Random rand = new Random();
    int number = rand.nextInt(100) + 1;
    int maxValue = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        exit = findViewById(R.id.exit);
        hardMode = findViewById(R.id.hardMode);
        easyMode = findViewById(R.id.easyMode);
        mode = findViewById(R.id.mode);
        mode.setText(getString(R.string.easyMode));

    }

    public void onClick(View view) {


        View.OnClickListener clickListenerExit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        };

        exit.setOnClickListener(clickListenerExit);


        View.OnClickListener clickListenerHardMode = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = rand.nextInt(10000) + 1;
                maxValue = 10000;
                mode.setText(getString(R.string.mode));
            }
        };
        hardMode.setOnClickListener(clickListenerHardMode);

        View.OnClickListener clickListenerEasyMode = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = rand.nextInt(100) + 1;
                maxValue = 100;
                mode.setText(getString(R.string.easyMode));
            }
        };
        easyMode.setOnClickListener(clickListenerEasyMode);

        if (etInput.getText().toString().length()==0){
            tvInfo.setText(getString(R.string.suggestion));
        }
        else {
            int value = Integer.parseInt(etInput.getText().toString());
            if ((value < 1) || (value > maxValue)) {
                tvInfo.setText(getString(R.string.errorValue));
            }
            else if (value < number) {
                tvInfo.setText("Больше");
            }
            else if (value > number) {
                tvInfo.setText("Меньше");
            }
            else {
                tvInfo.setText("Ура! Угадал!");
            }

        }

    }

}

