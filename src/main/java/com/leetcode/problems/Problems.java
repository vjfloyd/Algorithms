/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
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
        ListNode lista = new ListNode(1);
        
        
        //int valor = -8463847412;
        //System.out.println( "reverse  " + reverse(valor));
        //char[] a = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o',' ', 'r', 'l', 'd'};
        //System.out.println(new String(a));
        //System.out.println( "palidrome  " + isPalindrome(valor));
         //System.err.println("->" +recuperarUltimaCadena(""));
         //char[] arreglo = convertirEnArrayLaUltimaCadena("");
         
         //System.out.println( " cadena  " +     CountAndSay(4));
         System.out.println("max INT value = " + Integer.MAX_VALUE );
         System.out.println("max INT value = " + Integer.MIN_VALUE );
         
         System.out.println("min FLOAT value = " + Float.MIN_VALUE );
         System.out.println("max FLOAT value = " + Float.MAX_VALUE );
         
         System.out.println("min DOUBLE value = " + Double.MIN_VALUE );
         System.out.println("max DOUBLE value = " + Double.MAX_VALUE );
         
         
         System.out.println("ATOI = " + myAtoi3(" 02 2 1"));
        
        String x = "  -0012a42";
        System.out.println(x.charAt(0));
        
        metodoBurbuja();
         
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
    
   /**
    * Casos de prueba " "
    */
    
     
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
    
    // str = " 02 2 1"
    // str =  "   +0 123"
    //        "  -0012a42"
    public static int myAtoi(String str) {
        char[] numeroArray = str.toCharArray();
        Double convertedNumber;
        
        int indiceArregloDeInt = 0;
        int contadorDeNulos = 0;
        int contadorNumeralInvalido = 0;
        int indicePrimerNumeroSignificativo = 0;
        boolean primerCaracterNoNuloEncontrado = true;
        int contadorCaracterNuloEncontrado = 0;
        char[] arregloInt = new char[str.length()] ;
        
        for (int i = 0; i < numeroArray.length; i++) {
            if(!esCaracterNuloEnBlanco(numeroArray[i])){
                contadorCaracterNuloEncontrado++;
                primerCaracterNoNuloEncontrado = true;
                if(esNumeralInValido(numeroArray[i]))
                    break;
                arregloInt[indiceArregloDeInt] =  numeroArray[i];
                indiceArregloDeInt++;
            }else{
                //"nnn2n n2 2"
                contadorDeNulos++;
            }
            if(contadorDeNulos>=0 && indiceArregloDeInt==1)
                    indicePrimerNumeroSignificativo = indiceArregloDeInt + contadorDeNulos -1;
               
            if(ingresoUnCaracterInvalidoEnLaPosicionAceptada(indicePrimerNumeroSignificativo,i,numeroArray[i]))
                return 0;
            
//            if(esNumeralInValido(numeroArray[i]))
//                break;
        }
        
        /**
         * Método que completa con Ceros el arregloInt 
         */        
        for (int i = 0; i <  contadorDeNulos; i++) {
            arregloInt[indiceArregloDeInt + i] = ' ';
        }
        
         String arregloEnString  = String.valueOf(arregloInt);
         arregloEnString = arregloEnString.trim();
     
        try {
            convertedNumber = Double.parseDouble(arregloEnString);
        } catch (NumberFormatException e) {
            return -1;
        }
        
        if(convertedNumber> Integer.MAX_VALUE )
            return Integer.MAX_VALUE;
        else if (convertedNumber < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return Integer.parseInt(arregloEnString);
            
//            return convertedNumber;
//        if(convertedNumber> Integer.MAX_VALUE ||  convertedNumber < Integer.MIN_VALUE)
//           convertedNumber = convertedNumber > Integer.MAX_VALUE ?  Integer.MAX_VALUE : ( convertedNumber < Integer.MIN_VALUE ? Integer.MIN_VALUE : convertedNumber);
//        
//        return new Integer(convertedNumber);
//        
   

    }
    // casos de prueba : " 0 1", " 1 2 9"
    public static boolean esCaracterNuloEnBlanco(char digito){
        if(digito == ' '  || digito == '\u0000'){
            return true;
        }
        return false;
    }
    
    //nnn8-
    public static boolean ingresoUnCaracterInvalidoEnLaPosicionAceptada(int posicionIniciNumSignificativo,int indiceActual, char caracter){
        if((caracter=='-' || caracter=='+') && indiceActual > posicionIniciNumSignificativo){// 1 = posicionCorreta
            return true;
        }
       return false;
    }
    
    public static boolean esNumeralInValido(char digito){
       // retorno = true;
        switch(digito){
            case '0' :  return false;
            case '1' : return false;
            case '2' : return false;
            case '3': return false;
            case '4': return false;
            case '5': return false;
            case '6': return false;
            case '7': return false;
            case '8': return false;
            case '9': return false;
            case '-' : return false;
            case ' ' : return false;
            case '+' : return false;
        }
        return true;
    }
 
    
    
    public static int myAtoiMachine(String str) {
	if (str == null || str.length() == 0)
		return 0;//
	str = str.trim();
	char firstChar = str.charAt(0);
	int sign = 1, start = 0, len = str.length();
	long sum = 0;
	if (firstChar == '+') {
		sign = 1;
		start++;
	} else if (firstChar == '-') {
		sign = -1;
		start++;
	}
	for (int i = start; i < len; i++) {
		if (!Character.isDigit(str.charAt(i)))
			return (int) sum * sign;
		sum = sum * 10 + str.charAt(i) - '0';
		if (sign == 1 && sum > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	}

	return (int) sum * sign;
}
    
    public static int myAtoi3(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(str.charAt(index) == ' ' && index < str.length())
        index ++;

    //3. Handle signs
    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
    
    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}


    public static void metodoBurbuja(){
        int arreglo[] = new int[]{60, 20, 40, 10, 80, 90, 30, 50, 70};
        int nuevo[] = new int[9];
        
        for (int i = 0; i  <  arreglo.length ; i++) {
            for (int j = i+1; j < arreglo.length; j++) {
                if(arreglo[i] > arreglo[j] ){
                    int tmp = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = tmp;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            System.out.print(" , " + arreglo[i]);
        }
        
        
    }
    

}
