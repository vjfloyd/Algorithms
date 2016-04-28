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
        
    }
    
}
