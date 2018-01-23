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
        //romanToInt("CCC");
        //System.out.println("suma="+romanToInt("CCCXXXIX"));
        System.out.println("suma="+romanToInt("XVIII"));//XXXIV,IMMMM,MMMCCLXX,CCCXXXIX
        
    }
    public static int romanToInt(String s) {
        // i = 1  , IV = 4, V = 5, X = 10, L = 50 ,IC = 99, C =100, CCIC = 299,  D = 500, M = 1000 , 3999 = IMMMM
    
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
        //Entrada  XXX, XXXIX, IMMMM
       
        for (int i = 0; i < arreglo.length; i++) {
             System.out.println(arreglo[i]);
        }
        
        //Logica
        int tamano = s.length();
        int suma = 0;
        int resta = 0;
        String esResta = "";///XIX , CCCXXXIX,XXXIV, IMMM, CMI, MMMCMXCIX
        
        for (int i = 0; i < arreglo.length ; i++) {
            if( i==0 ){
                suma = tabla.get(arreglo[i]);
            }
            if(i <= arreglo.length-2 && arreglo[i].equalsIgnoreCase(arreglo[i+1])){
               int valor = tabla.get(arreglo[i+1]);
               suma = valor + suma;
               if(resta!=0){
                   suma = suma + tabla.get(arreglo[i]);
                   resta = 0;
               }
               
            }else{
                if(i <= arreglo.length-2){
                    
                    if(resta != 0){
                        if( tabla.get(arreglo[i+1]) > resta){
                            resta = -1*resta;
                        }
                        suma = suma + resta + tabla.get(arreglo[i+1]);
                        resta = 0;
                    }
                    if(resta!=0 && i+1 == arreglo.length-1){
                        suma = suma + resta;
                    }
                    int nposterior =  tabla.get(arreglo[i+1]);
                    int nanterior = tabla.get(arreglo[i]);//CCCXXXIX
                    if(nanterior < nposterior){
                        resta = -tabla.get(arreglo[i+1]);
                    }else if(nanterior > nposterior ){
                         resta = tabla.get(arreglo[i+1]);
                         if(arreglo.length==2){
                            suma = suma + resta;
                            resta = 0;
                         }
                         
                    }
                }
                
            }
        }
        
        //Salida
        
        return suma;
    }

}
