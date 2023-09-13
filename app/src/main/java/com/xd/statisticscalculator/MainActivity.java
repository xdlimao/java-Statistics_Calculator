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

    String blankinput , added , notnumber, blankarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blankinput = this.getString(R.string.blankinput);
        added = this.getString(R.string.added);
        notnumber = this.getString(R.string.notnumber);
        blankarray = this.getString(R.string.blankarray);

        st = new StatisticCalc();
        mNumber = findViewById(R.id.editTextNumber);

        Button mAddButton = findViewById(R.id.addButton);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st.addNumber(mNumber);
                if (StatisticCalc.status == 0 ){
                    Toast.makeText(getApplicationContext(), blankinput, Toast.LENGTH_SHORT).show();
                }else if (StatisticCalc.status == 1){
                    Toast.makeText(getApplicationContext(), added, Toast.LENGTH_SHORT).show();
                }else if (StatisticCalc.status == 2){
                    Toast.makeText(getApplicationContext(), notnumber, Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button mFinishButton = findViewById(R.id.finishButton);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StatisticCalc.mValues.size() == 0) {
                    Toast.makeText(getApplicationContext(), blankarray, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}