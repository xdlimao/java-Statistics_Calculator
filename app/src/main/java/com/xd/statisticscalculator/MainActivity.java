package com.xd.statisticscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText mNumber;
    StatisticCalc st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        st = new StatisticCalc();
        mNumber = findViewById(R.id.editTextNumber);

        Button mAddButton = findViewById(R.id.addButton);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st.addNumber(mNumber);
                if (StatisticCalc.status == 0 ){
                    Toast.makeText(getApplicationContext(), "Null.", Toast.LENGTH_SHORT).show();
                }else if (StatisticCalc.status == 1){
                    Toast.makeText(getApplicationContext(), "Added.", Toast.LENGTH_SHORT).show();
                }else if (StatisticCalc.status == 2){
                    Toast.makeText(getApplicationContext(), "Not number.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button mFinishButton = findViewById(R.id.finishButton);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}