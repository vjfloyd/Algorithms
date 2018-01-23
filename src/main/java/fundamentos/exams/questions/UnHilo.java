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
class UnHilo extends Thread { 
    public UnHilo(Runnable runnable){ 
        super(runnable); 
        System.out.println("Running..."); 
    }
    public static void main (String argv[]) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        UnHilo test = new UnHilo(r); 
        test.start();
    } 
}