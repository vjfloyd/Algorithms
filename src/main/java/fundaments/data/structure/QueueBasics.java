/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundaments.data.structure;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author vjrojasb
 */
public class QueueBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Character> queue = new PriorityQueue<>();
        queue.add('a');
        queue.add('c');
        
        char out = queue.poll();
        
        System.out.println("x = " + out);
    }
    
}
