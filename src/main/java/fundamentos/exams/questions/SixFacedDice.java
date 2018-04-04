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
public class SixFacedDice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getPosibilites(10);
    }
    
    
    public static double getPosibilites(int a) {
       int dado[] = {1,2,3,4,5,6};
       int sol_1 = 1;
       int sol_n = 1;
       
        for (int i = 0; i < dado.length; i++) {
            System.out.println("" + dado[i]);
        }
 
       return Math.pow(2, a);
    }
    
}
