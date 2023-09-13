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
                Collections.sort(mValues);
                mNumber.getText().clear();
                status = 1;
            } catch (NumberFormatException e) {
                status = 2;
            }
        } else {
            status = 0;
        }
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
//    public List<Double> moda (List<Double> lista){
//
//        // Crie um HashMap para armazenar a contagem de cada número
//        Map<Double, Integer> contagemNumeros = new HashMap<>();
//
//        // Percorra a lista de números e atualize o HashMap
//        for (double numero : lista) {
//            contagemNumeros.put(numero, contagemNumeros.getOrDefault(numero, 0) + 1);
//        }
//
//        // Encontre a maior contagem
//        int maxContagem = 0;
//        for (int contagem : contagemNumeros.values()) {
//            if (contagem > maxContagem) {
//                maxContagem = contagem;
//            }
//        }
//
//        // Construa a lista de modas
//        List<Double> modas = new ArrayList<>();
//        for (Map.Entry<Double, Integer> entry : contagemNumeros.entrySet()) {
//            if (entry.getValue() == maxContagem) {
//                modas.add(entry.getKey());
//            }
//        }
//
//        return modas;
//    }
//    public double variancia (List<Double> lista){
//            double media = media(lista);
//            double somaDosQuadradosDasDiferencas = 0;
//
//            for (double numero : lista) {
//                double diferenca = numero - media;
//                somaDosQuadradosDasDiferencas += diferenca * diferenca;
//            }
//
//            return somaDosQuadradosDasDiferencas / lista.size();
//    }
//    public double desviopadrao (List<Double> lista){
//        return Math.sqrt(variancia(lista));
//    }
//    public double desviomedio (List<Double> lista){
//        double media = media(lista);
//        double somaDosDesvios = 0;
//
//        for (double numero : lista) {
//            double diferenca = Math.abs(numero - media);
//            somaDosDesvios += diferenca;
//        }
//
//        return somaDosDesvios / lista.size();
//    }
}
