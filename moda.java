package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TesteModa {

	private Map valores = new HashMap();   
    
    public TesteModa() {}   
    
    public static void main(String[] args) {   
        
    	TesteModa moda = new TesteModa();   
           
        moda.adicionar(1);
        moda.adicionar(2);
        moda.adicionar(2);
        moda.adicionar(3);
        moda.adicionar(3);
        moda.adicionar(3);
        moda.adicionar(3);
        moda.adicionar(3);
        moda.adicionar(3);
        moda.adicionar(4);
        moda.adicionar(4);
        moda.adicionar(4);
        moda.adicionar(4);
        moda.adicionar(4);
        moda.adicionar(4);
           
        System.out.println(moda.getValores());   
           
        System.out.println("A moda é: " + moda.calcular());   
    }
    
    public void adicionar(int numero) {   
           
        Integer n = new Integer(numero);   
           
        if (valores.get(n) != null) {   
            valores.put(n, new Integer(((Integer)valores.get(n)).intValue() + 1));   
        }   
        else {   
            valores.put(n, new Integer(1));   
        }   
    }   
       
    public Map getValores() {   
        return valores;   
    }   
       
    public Set calcular() {   
           
        Integer maior = null;   
           
        Set resultado = new HashSet();   
           
        Iterator iterator = valores.keySet().iterator();   
        while (iterator.hasNext()) {   
               
            Integer valorAtualAnalisado = (Integer)iterator.next();   
               
            Integer vezesQAparece = (Integer)valores.get(valorAtualAnalisado);   
               
            if (maior == null) {   
                maior = vezesQAparece;   
            }   
               
            if (maior.compareTo(vezesQAparece) <= 0) {   
                maior = vezesQAparece;   
                resultado.add(valorAtualAnalisado);   
            }   
        }   
           
        iterator = resultado.iterator();   
           
        while (iterator.hasNext()) {   
               
            Integer numero = (Integer)iterator.next();   
    
            if (((Integer)valores.get(numero)).compareTo(maior) < 0) {   
                iterator.remove();    
            }   
        }   
           
        return resultado;   
    }   
       
       
	
}

