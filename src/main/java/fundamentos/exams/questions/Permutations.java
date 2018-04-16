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
public class Permutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String val = "ABC";
       // permutations(val);
        permutation("","ABCD");
    }
    
    public static void permutations(String arg){
        int k = arg.length();
        List<String> visited = new ArrayList();
        String current = arg;
        List<String> permuts = new ArrayList<>();
        permuts.add(current);
        //while(!permuts.isEmpty()){
            String tmp = ""+arg.charAt(0);
            int selected = 0;
            for (int j = 1; j <= k; j++) {
                String y = arg.charAt(j-1)+"";
                for (int i = j; i < k; i++) {
                    String x = y + arg.charAt(i)+  arg.substring(i+1, k);
                    System.out.println("per = " + x);
                }
            }
            
            
            //permutations(arg);
        //}
        
        
        
    }
    
    public static boolean acepted(){
        return true;
    }
    
    public static boolean rejected(){
        return true;
    }
    
//    public static void permutation(String str) { 
//    permutation("", str); 
//}

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
