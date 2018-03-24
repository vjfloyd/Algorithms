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
    static final int NO_OF_CHARS = 256;
    static char contador[] = new char[NO_OF_CHARS];
    
    public static void main(String[] args) {
        // TODO code application logic here
        FirstNotRepeatingCharacter_problem p = new FirstNotRepeatingCharacter_problem();
        
        System.out.println("resultado = " +  p.firstNotRepeatingCharacter("vvviicttoor"));
    }
    
    static void getCharCountArray(String str) 
     {
         for (int i = 0; i < str.length();  i++){
             contador[str.charAt(i)]++;
         }
     }
    
                
//       For s = "aacabadc", the output should be
//       For s = "accccc", the output should be
//        firstNotRepeatingCharacter(s) = 'c' s = "abacabaabacaba"
    char  firstNotRepeatingCharacter(String s) {
        getCharCountArray(s);
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if(contador[i] == 1){
                char retorno = (char)i;
                System.out.println("holi");
                return retorno;
            }
        }

           return '1';
       }

}