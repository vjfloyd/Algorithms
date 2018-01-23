/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos.exams.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
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
      
        List<String> lista = null;
               
         if(lista!=null && lista.isEmpty()){
             System.out.print("hola");
         }else{
             System.out.println("ok");
         }
         
        
        
        String str1= new String("hola"); 
        String str2= new String("hola");
        String str3= "hola";
        String str4= "hola"; 
        System.err.println(str1.equals(str2) );
        System.out.println((str1==str2) + " "); 
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));
        
        Queue<String> cola = new LinkedList<>();
        
        cola.add("cola1");
        cola.add("cola2");
        cola.add("cola3");
        
        Properties prop = new Properties();
        prop.getProperty("");
        
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
        
        if("hola" == "hola"){
            System.out.println("ok ok");
        }
        
        System.out.println("Diff = " +  7.0%2.0); // 
        
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
