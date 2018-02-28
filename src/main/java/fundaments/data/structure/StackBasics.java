/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundaments.data.structure;

import java.util.Stack;

/**
 *
 * @author vjrojasb
 */
public class StackBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Stack<Character> stack = new Stack();
        stack.push('a');
        stack.push('b');
        
        System.out.println(" x  = " + stack.pop());
    }
    
}
