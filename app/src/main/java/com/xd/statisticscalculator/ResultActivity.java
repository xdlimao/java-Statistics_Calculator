package com.xd.statisticscalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ResultActivity extends AppCompatActivity {
//    List<Double> values = MainActivity.values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        startCalcs();

    }

    public void startCalcs(){
        String mediaString = this.getString(R.string.average);
        String medianaString = this.getString(R.string.median);
        String modaString = this.getString(R.string.fashion);
        String varianciaString = this.getString(R.string.variance);
        String desviomedioString = this.getString(R.string.mean_deviation);
        String desviopadraoString = this.getString(R.string.standard_deviation);


//        TextView mTextView1 = findViewById(R.id.textViewxd);
//        double resmedia = media(values);
//        mTextView1.setText(mediaString + resmedia);
//
//        TextView mTextView2 = findViewById(R.id.textView2);
//        double resmediana = mStatisticCalc.mediana(values);
//        mTextView2.setText(medianaString + resmediana);
//
//        TextView mTextView3 = findViewById(R.id.textView3);
//        List<Double> resmoda = mStatisticCalc.moda(values);
//        mTextView3.setText(modaString + resmoda);
//
//        TextView mTextView4 = findViewById(R.id.textView4);
//        double resvariancia = mStatisticCalc.variancia(values);
//        mTextView4.setText(varianciaString + resvariancia);
//
//        TextView mTextView5 = findViewById(R.id.textView5);
//        double resdmedio = mStatisticCalc.desviomedio(values);
//        mTextView5.setText(desviomedioString + resdmedio);
//
//        TextView mTextView6 = findViewById(R.id.textView5);
//        double resdpadrao = mStatisticCalc.desviopadrao(values);
//        mTextView6.setText(desviopadraoString + resdpadrao);
    }
    public double media (List<Double> lista){
        double sum = 0;
        for (int i = 0; i <= lista.size(); i++){
            sum = sum + lista.get(i);
        }
        return sum/lista.size();
    }
}
