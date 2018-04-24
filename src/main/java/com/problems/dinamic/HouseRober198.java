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
        System.out.println("sum =  " + rob2(nums));
    }
    
    public static int rob(int[] nums) {
        int size = nums.length;
        if(size < 1)return 0; 
       
        int sp = nums[0];
        int si = size == 1 ? 0 : nums[1];
        int sm = 0;
        int j_i = 1;
        int j_p = 0; 
        int sv_i = 0;
        int sv_p = 0;
        boolean f_imp = false;
        boolean f_par = false;
        for (int i = 2; i < size; i++) {
             if(i%2 == 0){
                sp = sp + nums[i];
               
            }
            if(i%2 == 1){
                si = si + nums[i];
                
            }
            if(i-j_p >2) {
                if(i%2 == 1 && !f_par){
                   sv_i =  nums[j_p] + nums[i];
                   f_par = true;
                }else{
                    if(i%2 == 1){
                       sv_i = sv_i + nums[i];
                    }
                   
                }
                    
             }
            if(i-j_i >2) {
                if(i%2 == 0 && !f_imp){
                  sv_p = nums[j_i] + nums[i];
                  f_imp = true;
                }else{
                    if(i%2 == 1){
                        sv_p = sv_p + nums[i];
                    }
                }
                    
            }
             
        }
        return sv_i;
    }
    
    public boolean es_posible_sumar(int a, int b){
        if(a - b > 1)return true;
        return  false; 
    }

    public static int rob2(int[] nums){
        if(nums.length==0)return 0;
        int size = nums.length+1;
        int [][] dp = new int[size][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = nums[i-1] + dp[i-1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
         
    }
    
    

}
