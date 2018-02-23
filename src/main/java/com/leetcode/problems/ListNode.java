/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.problems;

import algoritmos.busqueda.bfs.Nodo;

/**
 *
 * @author vjrojasb
 */
public class ListNode {
    
     int val;
     ListNode next;
     ListNode(int x) { 
       val = x; 
     }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

      public static void main(String[] args) {
          ListNode node_a = new ListNode(1);
          ListNode node_b = new ListNode(9);
          node_a.next = node_b ;
          ListNode node_c = new ListNode(2);
          node_b.next = node_c;
          
          ListNode result = new ListNode(0);
          ListNode prev = result;
          
                  
          while ( node_a!=null) {
              System.out.println(node_a.val);
              node_a = node_a.next;
          }
          
      }

//   Input: 1->2->4, 1->3->4
//   Output: 1->1->2->3->4->4
//   [1,2,4]
//   [1,3,4]
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
         if (l1 == null && l2 == null) {
             return null;
         }
         if(l1 == null){
             return l2;
         }
         if(l2 == null){
             return l1;
         }
         
         ListNode result = new ListNode(0);
         ListNode temp = result;
         
         while (l1!=null && l2!=null) {             
             if(l1.val >= l2.val){
                 temp.next = l2;
                 l2 = l2.next;
             }else{
                 temp.next = l1;
                 l1 = l1.next;
             }
             temp.next = temp;
            
         }
         
         if(l1!=null){
             temp.next = l1;
         }
         if(l2!=null){
             temp.next = l2;
         }
         
         return result.next;
     }
     
 
}
