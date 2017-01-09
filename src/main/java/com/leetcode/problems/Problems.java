/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vjrojasb
 */
public class Problems {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int valor = -2147483648;
        //int valor = -8463847412;
        //System.out.println( "reverse  " + reverse(valor));
        //char[] a = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o',' ', 'r', 'l', 'd'};
        //System.out.println(new String(a));
        //System.out.println( "palidrome  " + isPalindrome(valor));
         //System.err.println("->" +recuperarUltimaCadena(""));
         //char[] arreglo = convertirEnArrayLaUltimaCadena("");
         
         System.out.println( " cadena  " +     CountAndSay(4));
    }
    // a[ 1 9 10 2 4 ]
    public int[] twoSum(int[] nums, int target) {
        int retorno[] = new int[2];
                
        for(int i=0 ; i < nums.length; i++){
            for (int j = i + 1 ; j < nums.length  ; j++) {
                    if(target == nums[i] + nums[j]){
                        retorno[0] =  nums[i];
                        retorno[i] = nums[j];
                        return retorno;
                    }
            }
        }
        return retorno;
    }
    
    public static int reverse(int x) {
        // 123=  321
        // 100 = 001
        // -239 = -932
        if(x > Integer.MAX_VALUE){
            return 0;
        }
        Integer numeroInteger = x ;
        String numberString = numeroInteger.toString();
        //String init = 
        int valorInicial = 0;
        char[] arregloInicial = numberString.toCharArray();
        char[] arregloRetorno = numberString.toCharArray() ; // = new char[];
        for (int i = arregloInicial.length-1, j=0 ; i >= 0 ;i--,j++) {
           if(arregloInicial[valorInicial] == '-'){
                if(arregloInicial[j] == '-' && j==0){
                   arregloRetorno[j] = '-'; 
                }else if(j>0){
                   arregloRetorno[j] = arregloInicial[i+1];
                }
            }else{
                arregloRetorno[j] = arregloInicial[i]; //93
           }
        }
        //13000  -  00013
        //10010  -  01001
        int cont = 0;
        if(arregloRetorno[0]=='0'){
            for (int i = 0; i < arregloRetorno.length; i++) {
                if(arregloRetorno[i]=='0' && i == cont){
                    arregloRetorno[i] =  ' ';
                    cont++;
                }
            }
        }
        String numeroConvertido = new String(arregloRetorno);
        numeroConvertido = numeroConvertido.trim();
        try{
            Integer numeroRetorno = Integer.parseInt(numeroConvertido);
            return numeroRetorno.intValue();
         }catch(NumberFormatException ex){ // handle your exception
            return 0;
         }
     }
    
    public static boolean isPalindrome(int x) {
         Integer numeroInt = x;
         String numeroCadena = numeroInt.toString();
         char[] numeroInicial = numeroCadena.toCharArray();
         int indiceInicialDerecha = numeroInicial.length-1;
         int numeroDigito = numeroInicial.length;
         boolean espar = numeroDigito % 2 == 0; 
         
         if(numeroInicial.length == 1)
            return true;
         else if(numeroInicial[0] == '-'){
            return false; 
         }else {//1001 101 20902
             if(espar){
                 for(int i=0, j= indiceInicialDerecha ;i<numeroInicial.length/2 && j>=numeroInicial.length/2;i++,j--)
                    if(!(numeroInicial[i] == numeroInicial[j]))
                        return false;
             }else{
                 for(int i=0, j= indiceInicialDerecha ;i<numeroInicial.length/2 && j>numeroInicial.length/2;i++,j--)
                    if(!(numeroInicial[i] == numeroInicial[j]))
                        return false;
             }
         }
         return true;
      }

    
    
    public static char[] convertirEnCadena(String cadena){
        char[] retorno = cadena.toCharArray();
        return retorno;
    }
     //1 , 1 1 , 2 1 , 1 2 1 1 , 1 1 1 2 2 1
    public static String generarNuevaSecuencia(String secuenciaActual){
        int tamArrar = 1;
        char caracterAContar = '1';
        if(!secuenciaActual.equals("")){
            char[]  secuenciaArray = convertirEnArrayLaUltimaCadena(secuenciaActual);
            tamArrar = secuenciaArray.length;
            caracterAContar = secuenciaArray[0];
            int cont = 0;
        int iteraciones = 0;
        String contadorString = "";
        String caracterAContarString = ""+caracterAContar;
        String retorno = "";
        String secuencia = "";
        while(iteraciones < tamArrar){
                if( caracterAContar == secuenciaArray[iteraciones]){
                    cont++;
                     contadorString =  (new Integer(cont)).toString();
                     caracterAContarString = ""+caracterAContar;
                }else{
                    caracterAContarString = ""+ caracterAContar;
                    contadorString =  (new Integer(cont)).toString();
                    cont = 0;
                    caracterAContar = secuenciaArray[iteraciones];
                    iteraciones--;
                }
                if(secuenciaArray.length==1){
                        secuencia = contadorString + caracterAContarString;
                        retorno =  retorno + secuencia;
                }
                if((iteraciones<secuenciaArray.length-1) ){
                    if(!elCaracterSeRepiteMasDeUnaVez(caracterAContar, secuenciaArray,iteraciones)){
                        secuencia = contadorString  + caracterAContarString;
                        retorno =  retorno + secuencia;
                    }
                }else if(secuenciaArray.length > 1){
                    secuencia = contadorString  + caracterAContarString;
                    retorno =  retorno + secuencia;
                }
                iteraciones++;
            }
            return retorno;
        }else{
            return "1";
        }
    }
    
    
    public static boolean elCaracterSeRepiteMasDeUnaVez(char caracterAvalidar, char[] arreglo, int indiceInicio){
        return caracterAvalidar == arreglo[indiceInicio+1];
    }
    
    //1 , 1 1 , 2 1 , 1 2 1 1 , 1 1 1 2 2 1
    public static String CountAndSay(int n){
        String secuencia_i = "";
        String retorno = "";
        for (int i = 0; i < n ; i++) {
            
            
            secuencia_i = generarNuevaSecuencia(secuencia_i);
            if(n>1){
                retorno = retorno + secuencia_i + ",";
                secuencia_i = recuperarUltimaCadena(retorno);
            }else{
                return secuencia_i;
            }
            
        }
        return secuencia_i;
    }// 1, | 1, 1 1 ,
    

    public static String recuperarUltimaCadena(String cadenaRetorno){
        String cadena = cadenaRetorno.trim();
        String[] arregloRetorno = cadena.split(",");
        
        return arregloRetorno[arregloRetorno.length-1];
    }  
    
    public static char[] convertirEnArrayLaUltimaCadena(String cadena){
        String cadenaSinEspacio = cadena.trim();
        return cadenaSinEspacio.toCharArray();
    }
                    
    public static boolean siCadenaSeConcateno(String cadena){
        return cadena.contains(",");
    }
    
    public static String convertirIntEnString(int contadorCaracterRepetido){
        String contadorEnString = "";
        return  contadorEnString = (new Integer(contadorCaracterRepetido)).toString();
    }
    
    public static int revisaSiSonIgualesyCuenta(char[] arreglo){
        int cont=0;
        for (int i = 0; i < arreglo.length; i++) {// 1 1 5 1 1
           if(i < arreglo.length-1){
                if(arreglo[i] == arreglo[i+1]){
                    cont++;
                }else{
                    return cont==0 ? cont : cont+1;
                }
           }
        }
        return cont==0 ? cont : cont+1;
    }
    
    class caracterActual{
        
    }
    
     
    public static void ProbandoArregloIntAndInteger(){
        int[] numeros = new int[9];
        int[] num = {1,2,3};
        //numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9];
        for (int i = 0; i < num.length ; i++) {
            System.out.println("," + num[i]);
        }
        List<Integer> listaInt = null;//new ArrayList<>();
        List<Integer> listaLlena = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            listaLlena.add(i);
        }
        Integer[] numeros2 = new Integer[3];
        //int[] num = {1,2,3};
        Integer[] num2 = {2,2,1};
        listaInt = listaLlena;
        for (int i = 1; i < 10; i++) {
            //listaInt.add(i);
            System.out.println("x = " + listaInt.get(i-1));
        }
    }
    
    
    
    
}
