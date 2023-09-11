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
    ArrayList<String> mValues = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNumber = findViewById(R.id.editTextNumber);
        mValues.add("Oi");

        Button mAddButton = findViewById(R.id.addButton);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                addNumber();
                Toast.makeText(getApplicationContext(), mValues.size() , Toast.LENGTH_SHORT).show();
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
    private void addNumber() {
        String inputText = mNumber.getText().toString().trim();

        if (!inputText.isEmpty()) {
            try {
                double number = Double.parseDouble(inputText);
//                mValues.add(number);
                Toast.makeText(this, "Added.", Toast.LENGTH_SHORT).show();
                mNumber.getText().clear(); // Clear editText
            } catch (NumberFormatException e) {
                Toast.makeText(this, "This isn't a number.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Empty.", Toast.LENGTH_SHORT).show();
        }
    }
}