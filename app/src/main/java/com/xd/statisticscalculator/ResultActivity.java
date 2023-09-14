package com.xd.statisticscalculator;



import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;


public class ResultActivity extends AppCompatActivity {
    StatisticCalc stn;

    TextView mTextView1, mTextView2, mTextView3, mTextView4, mTextView5, mTextView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Collections.sort(StatisticCalc.mValues); //Deixa o array em ordem crescente


        stn = new StatisticCalc();

        mTextView1 = findViewById(R.id.textViewxd);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView3);
        mTextView4 = findViewById(R.id.textView4);
        mTextView5 = findViewById(R.id.textView5);
        mTextView6 = findViewById(R.id.textView6);

        Button mBackButton = findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                StatisticCalc.mValues.clear();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        startCalcs();

    }

    public void startCalcs() {

        String mediaString = this.getString(R.string.average);
        String medianaString = this.getString(R.string.median);
        String modaString = this.getString(R.string.fashion);
        String varianciaString = this.getString(R.string.variance);
        String desviomedioString = this.getString(R.string.mean_deviation);
        String desviopadraoString = this.getString(R.string.standard_deviation);

        mTextView1.setText(mediaString + " " + stn.media());

        mTextView2.setText(medianaString + " " + stn.mediana());

//        mTextView3.setText(modaString + resmoda);

        mTextView4.setText(varianciaString + " " + stn.variancia());

        mTextView5.setText(desviomedioString + " " + stn.desviomedio());

        mTextView6.setText(desviopadraoString + " " + stn.desviopadrao());
    }
}

