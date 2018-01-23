/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos.exams.questions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vjrojasb
 */
public class ArreglosPropiedades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str1= new String("hola"); 
        String str2= new String("hola");
        String str3= "hola";
        String str4= "hola"; 
        System.err.println(str1.equals(str2) );
        System.out.println((str1==str2) + " "); 
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));
        
        
       int[] arreglo = new int[10];
        for (int i = 0; i < 10; i++) {
            
        }
        List<Integer> lista = new ArrayList<Integer>();
        
        int numero[] = {1, 2, 3, 4, 5};
        for (int num : numero) {
            System.out.println(" " + num);
        }
        
        
    }
    
}
