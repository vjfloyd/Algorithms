/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos.exams.questions;

/**
 *
 * @author vjrojasb
 */
public class Lampara {
    int contador1 = 2;
    static int contador2 = 1;
    
    public Lampara(){
        contador1 = 0;
        contador2++;
    }
    
    public void incremental1(){
        contador1++;
    }
    public void incremental2(){
        contador2++;
    }
    
    public static void incrementa(){
        //contador1++;
        contador2++;  
    }
    
    
}
