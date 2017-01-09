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
    
    Integer value;
    ListNode next;

    public ListNode() {
      ListNode actual = new ListNode();
      actual = null;
    }
    
    
    ListNode(int x){
        value = x;
    }
    
    public void addNodo(ListNode nuevoNodo){
       if(estaVacio(this)){
         ListNode nodoActual = new ListNode(value);
         nodoActual.next = null;
         
       }else{
          
         ListNode nuevo = new ListNode();
         nuevo.next = nuevoNodo;
         nuevo.value = nuevoNodo.value;
         
         nuevoNodo.next = null;
       }
    }
    
    public boolean estaVacio(ListNode listNode){
            while (listNode.next!=null) {
                return false;
            }
            return true;
    }
    
    public static void main(String[] args) {
        
        
        
    }

   
}
