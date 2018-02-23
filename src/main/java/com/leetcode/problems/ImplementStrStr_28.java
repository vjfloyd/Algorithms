/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.INTERNAL;

/**
 *
 * @author vjrojasb
 */
public class ImplementStrStr_28 {
    
    public static void main(String[] args) {
         
        String val = "";
        System.out.println("size " + val.length());
         System.out.println("strStr = " + strStr("aabaaabaaac","aabaaac"));
    }
     
    public static int strStr(String haystack, String needle) {
        int sizeHaystack = haystack.length();
        int sizeNeedle = needle.length();
        if(sizeHaystack == sizeNeedle){
            if(haystack.contentEquals(needle)){
                return 0;
            }else if(needle.equalsIgnoreCase("")){
                return 0;
            }
        }
        if(sizeNeedle > sizeHaystack ){
            return -1;
        }
        if(sizeHaystack==0 || sizeNeedle==0){
            return 0;
        }
       char[] arrayHaystack = haystack.toCharArray();
       char[] arrayNeedle = needle.toCharArray();
        int repetido = 0;
        int contador=0;
        int indiceHaystack = 0;
        int indiceNeedle = 0;
        boolean  reiniciarBusqueda = false;
        int lastIndice = 0;
       List<Integer> listaRepeditos = new ArrayList<>();
        while(contador < sizeHaystack){
            if(reiniciarBusqueda){
                indiceHaystack = lastIndice + 1;
                reiniciarBusqueda = false;
            }
            if(arrayHaystack[indiceHaystack] == arrayNeedle[indiceNeedle]){
                repetido++;
                listaRepeditos.add(indiceHaystack);
                indiceHaystack += 1;
                indiceNeedle +=1;
            }else{
                repetido = 0;
                indiceHaystack += 1;
                indiceNeedle = 0;
                if(indiceHaystack == sizeHaystack){
                    return -1;
                }
                if(!listaRepeditos.isEmpty()){
                    lastIndice = listaRepeditos.get(0);
                    contador = lastIndice;
                    reiniciarBusqueda = true;
                }
                listaRepeditos.clear();
            }
            contador++;
            if(repetido==sizeNeedle){
                return listaRepeditos.get(0);
            }else if(indiceNeedle > sizeNeedle-1){
                return -1;
            }
        }
        if(repetido < sizeNeedle){
            return -1;
        }
        return listaRepeditos.get(0);
    }
}
