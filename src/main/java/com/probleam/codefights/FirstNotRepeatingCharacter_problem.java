/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.probleam.codefights;

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
    }
    
   char firstNotRepeatingCharacter(String s) {
    
       char cadena[] = s.toCharArray();
       int size = cadena.length;
       for (int i = 0; i < size; i++) {
           
       }
//       For s = "aacabad", the output should be
//        firstNotRepeatingCharacter(s) = 'c'.
       boolean continuar = true;
       int indice_a = 0;
       int indice_b = 1;
       int indice = 0;
       while (continuar) {           
           if(cadena[indice_a] == cadena[indice_b]){
               indice = indice_b + 1; 
           }
       }
       
       return '_';
   }

    
}
