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
        Tree  tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
       
        printTree(tree);
        
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
    
    public static void printTree(Tree treeNode) {
        
        Queue<Tree> tree = new LinkedList<Tree>();
        tree.add(treeNode);
        int level = 0;
        String str = "";
         Tree node = null;
        while (!tree.isEmpty()) {            
            if(level == 0 ){
                 node = tree.poll();
            }           
             if(node == null) return;
            else{
                if(level == 0){
                    str += node.value;
                }else{
                    for (int i = 0; i < level; i++) {
                        node = tree.poll();
                        str+= node.value;
                        node = tree.poll();
                        str+= node.value;
                    }
                    //str+="/\\";
                }
                tree.add(node.left);
                tree.add(node.right);
                addAll();
                level++;
            }
        }
        return;
    }
 
    public static void addAll(){
        
    }
            
            
    public static void printTree2(Tree treeNode) {
         Queue<Tree> tree = new LinkedList<Tree>();
        Queue<Integer> levels = new LinkedList<>();
        tree.add(treeNode);
        while (treeNode!=null) {             
            printTree(treeNode);
            
        }
     }
    
     
     
     
    
    static class Tree{
        public int value;
        public Tree left;
        public Tree right;
        public Tree(int v){
            value = v;
            left = right = null;
        }
    }
}
/*
958224958
2147483648
*/