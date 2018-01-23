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

    private ListNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    public static void addNodo(ListNode head, int value){
       if(estaVacio(head)){
         ListNode nodoActual = new ListNode(value);
         nodoActual.next = null;
         head = nodoActual;
       }else{
            ListNode nodoTmp = new ListNode(value);
           while (head==null) {               
               head = nodoTmp;
               head.next = null;
           }
           
       }
    }
    
    
    
    public static boolean estaVacio(ListNode listNode){
        ListNode actual =  null;
        int cont=0;
        while (listNode.next!=null) {
                actual = listNode.next;
                cont++;
            }
        if (cont>0) {
            return false;
        }
            return true;
    }
    
    public static void main(String[] args) {
        int valorInicial = 10;
        ListNode nodoInicial = new ListNode(valorInicial);
        addNodo(nodoInicial, 10);
        addNodo(nodoInicial,20);
        addNodo(nodoInicial,30);
        
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodoTmp = new ListNode();
        return nodoTmp;
    }
   
}
