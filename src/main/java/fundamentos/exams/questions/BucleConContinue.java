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
public class BucleConContinue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        while (true) {            
            i++;
            if(i<10)
                continue;
            i++;
            if(i==10)
                break;
        }
    }
    
}
