package com.xd.statisticscalculator;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
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
    public Map moda(){
        Map arrayValues = new HashMap();

        //Adicionar valores ao HashMap a partir do mValues e conta quantas vezes repetiu
        for (int i = 0; i < mValues.size(); i++){
            if(arrayValues.containsKey(mValues.get(i))){
                //Esse if é para fazer +1 no value do HashMap
                arrayValues.put(mValues.get(i), new Integer(((Integer)arrayValues.get(mValues.get(i))).intValue() + 1));
            } else {
                arrayValues.put(mValues.get(i), new Integer(1));
            }
        }

        //Comparador de tamanhos, caso acho os maior/maiores, adiciona em uma string
        //Pegar x e passar por todo o array, se o index dele for 0, ele é o maior de todos
        //Caso tenha dois ou mais com index 0, fazer a mesma coisa
        //Usar um array para armazenar esses valores e transformar em uma String.
        //Mas se caso o array inteiro for do mesmo tamanho do HashMap, ele é amodal
        //Ai ao invez de devolver um valor, escrever amodal
        //fazer também caso seja unimodal, bimodal e polimodal (opcional)

        //Under construction

        return arrayValues;
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