/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problems.dinamic;

/**
 *
 * @author vjrojasb
 */
public class HouseRober198 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] nums = {3,200,500,1,1000,900,400};
        //int[] nums = {2,1,1,2};
        int [] nums = {4,1,2,7,5,3,1};
        System.out.println("sum =  " + rob(nums));
    }
    
    public static int rob(int[] nums) {
        int size = nums.length;
        if(size < 1)return 0; 
       
        int sp = nums[0];
        int si = size == 1 ? 0 : nums[1];
        int sm_p = 0, sm_i = 0;
        int sm = 0;
        int smt = 0;
        int j = 0;
        for (int i = 2; i < size; i++) {
             if(i%2 == 0){
                 sp = sp + nums[i];
                 if(i>4){
                    sm_p = sm_p + nums[i];
                    System.out.println("sm_p"+sm_p);
             
                 }
             }
             if(i%2 == 1){
                 si = si + nums[i];
                 if(i>4){
                    sm_i = sm_i + nums[i];
                    System.out.println("sm_i"+sm_i);
             
                 }
             }
             if(i-j >2) {
                 
                 smt = nums[j] + nums[i];
                 j++;
                 sm = smt > sm ? smt : sm;
                 if(i%2 == 0){
                    sm_p = sm;
                    sm_i = 0;
                 }
                 else{
                    sm_i = sm;
                    sm_p = 0;
                 }
                     
             }
        }
        if(sm > si &&  sm > sp)
            return sm;
        
        if(sp > si) 
             return sp;
        else    
            return si;
    }
    
    public boolean es_posible_sumar(int a, int b){
        if(a - b > 1)return true;
        return  false; 
            
    }
}
