/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.probleam.codefights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author vjrojasb
 */
public class FirstNotRepeatingCharacter_problem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FirstNotRepeatingCharacter_problem p = new FirstNotRepeatingCharacter_problem();
        p.firstNotRepeatingCharacter("victor");
    }
    
char  firstNotRepeatingCharacter(String s) {
    
    char cadena[] = s.toCharArray();
    int size = cadena.length;
    for (int i = 0; i < listArreglo(s).size(); i++) {
        System.out.println(" " + listArreglo(s).get(i));
    }           
//       For s = "aacabadc", the output should be
//       For s = "accccc", the output should be
//        firstNotRepeatingCharacter(s) = 'c' s = "abacabaabacaba"
    boolean continuar = true;
    int indice_a = 0;
    int indice = 1;
    Queue<String> queue = new PriorityQueue<>();
    List<String> lista = listArreglo(s);
    Set<String> setlist = new HashSet();
    boolean exist_some_repetead = false;
    boolean repetido_una_vez = false;
    boolean indice_a_repetido = false;
    while(!exist_some_repetead){
        if (lista.get(indice_a).equalsIgnoreCase(lista.get(indice))) {
            indice_a_repetido = true;
        }else{
            if(indice_a_repetido)
                setlist.remove(lista.get(indice_a));
                
            setlist.add(lista.get(indice_a));
            setlist.add(lista.get(indice));
            
        }
        indice++;
        if(indice == size){
            if(setlist.size()==1){
                return setlist.toArray()[0].toString().charAt(0);
            }
            lista.clear();
            lista = (List<String>) setlist;
            indice_a = 0;
            indice =  indice_a + 1;
            exist_some_repetead = false;
        }
    }
       
       return '_';
   }

    List<String> listArreglo(String s){
        List<String> lista = new ArrayList<>() ;
        for (int i = 0; i < s.length(); i++) {
            String dig = String.valueOf(s.charAt(i));
            lista.add(dig);
        }
        return lista;
    }
}