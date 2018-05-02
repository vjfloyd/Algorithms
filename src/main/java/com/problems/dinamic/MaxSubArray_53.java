/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problems.dinamic;

import java.util.Stack;

/**
 *
 * @author vjrojasb
 */
public class MaxSubArray_53 {

    /**
     * @param args the command line arguments
     *  Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public static void main(String[] args) {
        //TODO code application logic here
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //[31,-41,59,26,-53,58,97,-93,-23,84]
        //int nums[] = {31,-41,59,26,-53,58,97,-93,-23,84};
        maxSubArray(nums);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("x =" + maxSubArrayOK(nums));
    }
    
    public static int maxSubArray(int[] nums) {
        int[] memoSum = new int[nums.length];
        int s = 0,mayor = -2147483647;
        for (int i = 0; i < nums.length; i++){
            s += nums[i]; 
            memoSum[i] = s;
            if(nums[i] > memoSum[i]){
                memoSum[i] = nums[i];
                s = memoSum[i];
            }
            if( i > 0){
                if(memoSum[i-1]>memoSum[i]){
                   if(memoSum[i-1] > mayor)
                    mayor = memoSum[i-1];
                }
            }
        }
        if (mayor > memoSum[memoSum.length-1] )
            return mayor;
        else
            return memoSum[memoSum.length-1];
        
    }
    
    public static int maxSubArrayOK(int[] nums) {
        int sum = 0, max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
    
}
