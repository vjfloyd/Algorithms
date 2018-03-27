/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos.exams.questions;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author vjrojasb
 */
public class Fibonnaci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 958224958
        //System.out.println("fibonnaci = " + fibonnaci(8181));3877337276612781506
        //System.out.println("1" + "\n/\\" );
        // System.out.println("fibonnaci = " + f(8181));
       
       
        
    }
    
    public static int fibonnaci(int n){
        if(n > -1){
            if(n == 0)
                return 0;
            if(n == 1)
                return 1;
            if(n > 1)
                return fibonnaci(n-1) + fibonnaci(n-2);
        }else{
            return -1;
        }
        return -1;
    }
    
    public static long f1(int n){
        long fib[] = new long[n+1];
        fib[0] =  0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
       return fib[n-1]+fib[n-2];
    }
    
    public static long f(int n){
        long sum1 = 0;
        long sum2 = 1;
        if( n == 0) 
            return 0;
        for (int i = 2; i < n; i++) {
            long c = sum1 + sum2;
             sum1 = sum2;
             sum2 = c;
              
        }
        return sum1 + sum2;
    }
    
    
 
    public static void addAll(){
        
    }
            
   
     
     
     
    
    
}
/*
958224958
2147483648
*/