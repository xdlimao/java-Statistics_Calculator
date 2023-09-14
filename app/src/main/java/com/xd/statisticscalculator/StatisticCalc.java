package com.xd.statisticscalculator;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticCalc {

    static ArrayList <Double> mValues = new ArrayList<>();
    static int status = 0;

    public void addNumber(EditText mNumber) {
        String inputText = mNumber.getText().toString().trim();

        if (!inputText.isEmpty()) {
            try {
                double number = Double.parseDouble(inputText);
                mValues.add(number);
                mNumber.getText().clear();
                status = 1;
            } catch (NumberFormatException e) {
                status = 2;
            }
        } else {
            status = 0;
        }
    }

    public void removeNumber(int count) {
            mValues.remove(count);
    }

    public double media (){
        int count = 0;
        double sum = 0;
        while(count < mValues.size()){
            sum = sum + mValues.get(count);
            count++;
        }
        return sum/mValues.size();
    }
    public double mediana (){
        if (mValues.size()%2 == 0){
            return (mValues.get((mValues.size() - 1)/2) + mValues.get(mValues.size()/2))/2;
        } else {
            int intconverted = (int) Math.ceil(mValues.size()/2);
            return mValues.get(intconverted);
        }
    }
    public int moda(){
        return 0;
    }
    public double variancia (){
        double media = media();
        int count = 0;
        double sum = 0;
        while(count < mValues.size()){
                sum = sum + Math.pow(mValues.get(count) - media, 2);
                count++;
        }
        return sum/mValues.size();
    }
    public double desviopadrao (){
        double variancia = variancia();
        return Math.sqrt(variancia);
    }
    public double desviomedio (){
        double media = media();
        int count = 0;
        double sum = 0;
        while(count < mValues.size()){
            sum = sum + Math.abs(mValues.get(count) - media);
            count++;
        }
        return sum/mValues.size();
    }
}
