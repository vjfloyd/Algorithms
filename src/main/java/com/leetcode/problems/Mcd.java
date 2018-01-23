/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.problems;

/**
 *
 * @author vjrojasb
 */
public class Mcd {

    public static int calcularMCD(int a, int b ){
        int mayor = Math.max(a, b);
        int maxDividendo = mayor/2;
        
        
        int maxDiva = a/2 +1;
        int maxDivb = b/2 + 1;
        
        int contDividendo = 2;
        int mcd = 1;
        
        while(contDividendo < maxDividendo){
            
            boolean boolA = a % contDividendo == 0 ? true : false; 
            boolean boolB = b % contDividendo == 0 ? true : false;
            
            if (boolA && boolB){
                while(boolA && boolB){
                    mcd = mcd * contDividendo;
                    a = a /  contDividendo;
                    b = b / contDividendo;
                    
                    boolA = a % contDividendo == 0 ? true : false; 
                    boolB = b % contDividendo == 0 ? true : false;
                }
            }else{
                contDividendo++;
                 boolA = a % contDividendo == 0 ? true : false; 
                 boolB = b % contDividendo == 0 ? true : false;
                while(boolA && boolB){
                    mcd = mcd * contDividendo;
                    a = a /  contDividendo;
                    b = b / contDividendo;
                    
                    boolA = a % contDividendo == 0 ? true : false; 
                    boolB = b % contDividendo == 0 ? true : false;
                }
            }
            contDividendo++;
        }
        
        
        return mcd;
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 11/2 + 1;
        System.out.println("MCD = " + calcularMCD(1,12));
    }
    
    
    
}
