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
public class DisenoClasesInterfaces {
    static Integer var01=0; 
    static int var02; 
    
     public static void main (String argv[]) { 
         System.out.println(A.x + " " + A.y);
         System.out.println(var01+var02);
         
         int x = 2;
         switch (x) { 
            case 2: System.out.println("2 "); break; 
            default: System.out.println("default "); break;
            case 3: System.out.println("3 "); break;
            case 4: System.out.println("4 "); break;
         
         } 
        }
     

    interface A { 
        int x=1; 
        int y = 20;
    }
    

}