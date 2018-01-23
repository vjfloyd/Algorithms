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
public class RemovedDuplicatesFromArray_26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int nums[] = new int[]{1 ,3};
        removeDuplicates(new int[]{1,1,2});
    }
    
    public static int removeDuplicates(int[] nums) {
        boolean fin  = true;
        int cont = 0;
        int indice = 0;
        int contRepetido = 0;
        int contNoRepetidos = 0;
        //Given nums = [1,1,2],
        int indiceSiguiente = 0;
        int indiceActual = 0;
                
        while (indiceActual<=nums.length) {            
            
            if (nums[indiceActual] == nums[indiceSiguiente] && indiceActual!=indiceSiguiente) {
                contRepetido++;
                indiceActual = indiceActual + 1;
                indiceSiguiente = indiceActual + 1;
            }else if(nums[indiceActual] != nums[indiceSiguiente]){
                indice++;
                indiceActual++;
            }else{
                indiceSiguiente =  indiceActual + 1;
            }
        }
        System.out.println("cont " + (nums.length-contRepetido));
        return 0;
        
    }
}
