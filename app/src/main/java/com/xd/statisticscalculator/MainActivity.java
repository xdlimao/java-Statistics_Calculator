package com.xd.statisticscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    EditText mNumber;
    TextView mResults;
    StatisticCalc st;
    String blankinput, added, removed, notnumber, blankarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResults = findViewById(R.id.resultTextView);

        blankinput = this.getString(R.string.blankinput);
        added = this.getString(R.string.added);
        removed = this.getString(R.string.removed);
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
                    mResults.setText("" + mResults.getText() + StatisticCalc.mValues.get(count) + "; ");
                    count++;
                }else if (StatisticCalc.status == 2){
                    Toast.makeText(getApplicationContext(), notnumber, Toast.LENGTH_SHORT).show();
                    mNumber.getText().clear();
                }
            }
        });

        //OK do teclado
        mNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER)) {
                    st.addNumber(mNumber);
                    if (StatisticCalc.status == 0 ){
                        Toast.makeText(getApplicationContext(), blankinput, Toast.LENGTH_SHORT).show();
                    }else if (StatisticCalc.status == 1){
                        Toast.makeText(getApplicationContext(), added, Toast.LENGTH_SHORT).show();
                        mResults.setText("" + mResults.getText() + StatisticCalc.mValues.get(count) + "; ");
                        count++;
                    }else if (StatisticCalc.status == 2){
                        Toast.makeText(getApplicationContext(), notnumber, Toast.LENGTH_SHORT).show();
                        mNumber.getText().clear();
                    }
                    return true;
                } else {
                    return false;
                }
            }
        });
        Button mRemoveButton = findViewById(R.id.removeButton);
        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StatisticCalc.mValues.size() > 0){
                    String numberString = String.valueOf(StatisticCalc.mValues.get(count-1));
                    String arrayListString = mResults.getText().toString();
                    int numberLength = numberString.length() + 2; // Esses mais dois é para o "; "

                    // Não entendi ainda como funciona o endIndex do substring...
                    String newText = arrayListString.substring(0, arrayListString.length() - numberLength);

                    mResults.setText(newText);
                    st.removeNumber(count-1);
                    Toast.makeText(getApplicationContext(), removed, Toast.LENGTH_SHORT).show();
                    count = count - 1;

                } else {
                    Toast.makeText(getApplicationContext(), blankarray, Toast.LENGTH_SHORT).show();
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