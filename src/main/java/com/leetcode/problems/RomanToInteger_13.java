/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vjrojasb
 */
public class RomanToInteger_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("suma="+romanToInt("D"));//XXXIV,IMMMM,MMMCCLXX,CCCXXXIX,MCMXCVI,CMLII
    }
    public static int romanToInt(String s) {
         Map<String, Integer> tabla = new HashMap<String, Integer>();
        tabla.put("I", 1);
        tabla.put("V", 5);
        tabla.put("X", 10);
        tabla.put("L", 50);
        tabla.put("C", 100);
        tabla.put("D", 500);
        tabla.put("M", 1000);
        for (Map.Entry<String, Integer> entrySet : tabla.entrySet()) {
            String key = entrySet.getKey();
            Integer value = entrySet.getValue();
        }
        s = s.replaceAll("\\s","");
        String[] arreglo = s.split("");    
        int tamano = s.length();
        int suma = 0;
        int sumando = 0;
        boolean flagTerminado = false;
        int tamanioArreglo = arreglo.length;
        if(tamanioArreglo==1){
            return tabla.get(arreglo[0]);
        }
        for (int i = 0; i < tamanioArreglo ; i++) {
           if(i+1 < arreglo.length){ 
               int posterior =  tabla.get(arreglo[i+1]);
               int anterior = tabla.get(arreglo[i]);//XII
                if(i >= 1){
                    if(sumando < posterior){
                        sumando = -1*sumando;
                    }else if(sumando >= posterior){
                        sumando = 1*sumando;
                    }
                   if(i+1 == tamanioArreglo-1){
                       suma = suma + sumando + posterior;
                       flagTerminado = true;
                    }else{
                        suma = suma + sumando;
                    }
                }
                int base = 0;
                if(i+1 < tamanioArreglo && !flagTerminado){
                   if(anterior < posterior){
                        base = -tabla.get(arreglo[i]);
                        sumando = tabla.get(arreglo[i+1]);
                    }else if(anterior >= posterior ){
                        sumando = tabla.get(arreglo[i+1]);
                        base = tabla.get(arreglo[i]);
                    }
                    if(tamanioArreglo==2 && i==0){
                      suma = base+ tabla.get(arreglo[i+1]);
                    }else if(i==0){
                        suma = base;
                    }
                }
            }
        }
        return suma;
    }
    
       

}
