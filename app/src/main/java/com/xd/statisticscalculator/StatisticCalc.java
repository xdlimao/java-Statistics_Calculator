package com.xd.statisticscalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticCalc {
    public double media (List<Double> lista){
        double sum = 0;
        for (int i = 0; i <= lista.size(); i++){
            sum = sum + lista.get(i);
        }
        return sum/lista.size();
    }
//    public double mediana (List<Double> lista){
//        double mediana = 0;
//        if (lista.size()%2 == 0){
//           return (lista.get(lista.size()/2) + lista.get(1+lista.size()/2))/2;
//        } else {
//            int intconverted = (int) Math.ceil(lista.size()/2);
//            return lista.get(intconverted);
//        }
//    }
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
