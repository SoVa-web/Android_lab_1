package com.example.lab1_suprun;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText task;
    private String val_type;
    private  String val_dif;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textView3);
        RadioGroup difficulty = findViewById(R.id.difficulty);
        RadioGroup type_task = findViewById(R.id.type);
        task = findViewById(R.id.editTextTextMultiLine2);

        type_task.setOnCheckedChangeListener((arg0, id) -> {
            switch(id) {
                case R.id.theoretical:
                    val_type = "Теоретичне";
                    break;
                case R.id.practice:
                    val_type = "Практичне";
                    break;
                default:
                    break;
            }
        });

        difficulty.setOnCheckedChangeListener((arg0, id) -> {
            switch(id) {
                case R.id.easy:
                    val_dif = "Легкий";
                    break;
                case R.id.average:
                    val_dif = "Середній";
                    break;
                case R.id.high:
                    val_dif = "Високий";
                    break;
                default:
                    break;
            }
        });


    }


    @SuppressLint("SetTextI18n")
    public void showResult(View view) {
        if (val_dif == null || val_type == null || TextUtils.isEmpty(task.getText())) {
            Toast empty_field = Toast.makeText(getApplicationContext(),
                    "Ви не ввели запитання або не здійснили вибір складності/типу завдання.",
                    Toast.LENGTH_SHORT);
            empty_field.setGravity(Gravity.CENTER, 0, 0);
            empty_field.show();
        } else {
            result.setText("Завдання:   " + task.getText() + "\nТип завдання: " + val_type + "\nРівень складності:  " + val_dif);
        }
    }
}