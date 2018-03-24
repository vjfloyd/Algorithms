/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examens.java.fundamentals;

/**
 *
 * @author vjrojasb
 */
public class Preguntas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double x = Math.pow(2.0, 2.0);
        System.out.println(" " + x);
           
        //ClasesConMetodosEstaticos obj = new ClasesConMetodosEstaticos();
        ClasesConMetodosEstaticos.getMenor();
        ClasesConMetodosEstaticos.getMayor();
        ClasesConMetodosEstaticos.getFloat();
    
        if(x>5){
            System.out.println("5");
        }else if(x < 10){
             System.out.println("10 ");
        }else if(x < 6){
            System.out.println(" 6 ");
        }else if( x < 5)
         System.out.println(" 5 ");
        }
    
    
    
}
