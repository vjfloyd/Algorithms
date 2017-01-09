/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author vjrojasb
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        Queue<String> cola = new LinkedList<>();
        
        cola.add("cola1");
        cola.add("cola2");
        cola.add("cola3");
        
        
        for (int i = 0; i < 3; i++) {
            System.out.println( cola.peek());
            cola.remove();
        }
        
        String ef  =  "123456780";
        String val =  "053765412";
        System.out.println(" length = " + val.length());
        int index;
        
        int ind = 0;
        int value = val.charAt(ind) - 48;
        if( value == 0){
            index = 8;
        }else{
            index = val.indexOf(value+48)+1;
        
        }
        int pos_val = value;
        int manhatan =  pos_val - index;
            if( manhatan < 0)
                manhatan*=-1;
            
        
        //int index = val.indexOf(value);
        
        //System.out.println(" Value " + (value-48));
        //System.out.println(" Index =  " + (index)) ;
        System.out.println("Diff = " +  manhatan); // 
        
        System.out.println("manhatan = " +  getManhattanPriority("12")); // 
        
        
        
        
    }
    
    
    public static int getManhattanPriority(String puzzle){
       String ef  = "123456780";
       String val = "053765412";
       System.out.println(" length = " + val.length());
       int index;
       int value;
        int pos_val;
         int manhatan  = 0;
       for (int i = 0; i < 8; i++) {
           value = val.charAt(i) - 48;
           if (value == 0) {
               index = 8;
           } else {
               index = val.indexOf(value + 48) + 1;

           }
           pos_val = value;
           manhatan = pos_val - index;
           if (manhatan < 0) {
               manhatan *= -1;
           }
           int a = i+1;
           System.out.println("man de " + val.charAt(i) + "= " + manhatan);
           manhatan += manhatan;
       }
       
       return manhatan;
       
   }
    
    
}
