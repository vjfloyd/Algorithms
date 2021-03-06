/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedainformada;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import graficos.*;
/**
 *
 * @author pshiguih
 */
public class Greedy {
    
    //Leer valores heuristicos
    //valores_heuristicos.txt
    public static int[]leerValoresHeuristicos( String nombreArchivo ) throws FileNotFoundException {
        Scanner punteroArchivo = new Scanner( new FileReader( nombreArchivo ) );
        String linea="";
        int[] valores_heuristicos = new int[20];
        int i=0;
        
        while( punteroArchivo.hasNextInt() ){
            valores_heuristicos[i] = punteroArchivo.nextInt();
            i++;         
        }
        
        return valores_heuristicos;
    }
    
    //Leer archivo
    public static int[][] leerMapa( String nombreArchivo ) throws FileNotFoundException {
        Scanner punteroArchivo = new Scanner( new FileReader( nombreArchivo ) );
        String linea="";
        HashMap<String, Integer> mapaNombres = indices();
        
        int[][] mapa = new int[20][20];
        int i,j;
        //Inicializamos mapa
        for( i=0; i<20; i++ ){
            for( j=0; j<20; j++ ){
                mapa[i][j] = 0;
            }
        }
        
        //Actualizamos mapa desde archivo
        while( punteroArchivo.hasNextLine() ){
            linea = punteroArchivo.nextLine();
            String[] ciudades = linea.split(" ");
            Integer ciudadOrigen = mapaNombres.get(ciudades[0]);
            Integer ciudadDestino = mapaNombres.get(ciudades[1]);
            
            mapa[ciudadOrigen][ciudadDestino] = 1;
        }
        Punto punto =  new PuntoImpl();
        punto.getPunto(9);
        return mapa;
    }
    
   //Mapa de Rumania
    public static int[][] obtenerMapaRumania(){
        //Mapa
        int[][] matrizAdyacencia = {
                        //Arad   Zerind  Timisoara  Oradea  Sibiu   Lugoj   Mehadia   Drobeta   Rimnicu    Craiova   Pitesti       Fagaras      Bucharest      Giurgiu    Urziceni      Vaslui       Hirsova   Eforie      Iasi   Neamt                                                                                                                                                                                                                                                                                   
        /*Arad-> */      { 0,        1,     1,        0,      1,     0,        0,        0,        0,         0,       0,              0,           0,          0,          0,              0,           0,       0,        0,        0  },                                                              
        /*Zerind->*/     { 1,        0,     0,        1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 },           
        /*Timisoara->*/  { 1,        0,     0,        0,     0,        1,0,0,0,0,0,0,0,0,0,0,0,0,0,0 },                        
        /*Oradea*/       { 0,        1,     0,        0,     1,        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        /*Sibiu*/        { 1,        0,      0,        1,     0,       0,      0,        0,        1,         0,        0,               1, 0,0,0,0,0,0,0,0},
        /*Lugoj*/        { 0,        0,     1,        0,     0,       0,       1, 0,0,0,0,0,0,0,0,0,0,0,0,0 },        
        /*Mehadia*/      { 0,       0,      0,        0,      0,      1,       0,       1 ,0,0,0,0,0,0,0,0,0,0,0 },
        /*Drobeta*/      { 0,      0,       0,        0,      0,      0,       1,        0,        0,          1, 0,0,0,0,0,0,0,0,0},
        /*Rimnicu*/      { 0,      0,       0,        0,      1,      0,       0,        0,         0,        1,         1,0,0,0,0,0,0,0,0},                                          
        /* Craiova */    { 0,      0,       0,        0,      0,      0,       0,        0,         1,        0,       1,0,0,0,0,0,0,0,0},                                          
        /*Pitesti*/      { 0,      0,       0,        0,      0,      0,       0,        0,         1,        1,         0,             0,           1,0,0,0,0,0,0},                                                              
        /*Fagaras*/      { 0,      0,       0,        0,      1,      0,       0,        0,         0,        0,         0,             0,           1,0,0,0,0,0,0},
        /*Bucharest*/    { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        1,             1,          0,           1,         1,              0,           0,       0,        0,        0  },                                                                                                                                                                                  
        /*Giurgiu*/      { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           1,           0,         0,              0,           0,       0,        0,        0  },                                                                                                                                                                                  
        /*Urziceni*/     { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           1,           0,         0,              1,           1,       0,        0,        0  },                                                                                                                                                                                  
        /*Vaslui*/       { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           0,           0,         1,              0,           0,       0,        1,        0  },                                                                                                                                                                                  
        /*Hirsova*/      { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           0,           0,         1,              0,           0,       1,        0,        0  },                                                                                                                                                                                  
        /*Eforie*/       { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           0,           0,         0,              0,           1,       0,        0,        0  },                                                                                                                                                                                  
        /*Iasi*/         { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           0,           0,         0,              1,           0,       0,        0,        1  },                                                                                                                                                                                  
        /*Neamt*/        { 0,      0,       0,        0,      0,      0,       0,        0,         0,        0,        0,             0,           0,           0,         0,              0,           0,       0,        1,        0 },                                                                                                                                                                                  
        };    
        return matrizAdyacencia;
    }
    
    
    public static List<Integer> obtenerCiudadesVecinas( int ciudad, int[][] mapa ){
        List<Integer> listaCiudadesVecinas = new ArrayList<Integer>();
        int j;
        
        for( j=0; j<mapa.length; j++ )  {
            if( mapa[ciudad][j] == 1 ){
                listaCiudadesVecinas.add( j );
            }
        }
        
        return listaCiudadesVecinas;
    }
    
    
    public static List<Integer> graphSearch( int ciudadOrigen, int ciudadObjetivo, int[][] mapa ){
       List<Integer> frontera = new ArrayList<Integer>();
       List<Integer> ciudadesVisitadas = new ArrayList<Integer>();
       
        //Añadimos la ciudad inicial
       frontera.add( ciudadOrigen );
       
       /*
         alcanzoObjetivo = 0   ->  No encuentra respuesta pero aun resta explorar soluciones
         alcanzoObjetivo = 1   ->  Encontro la solucion
         alcanzoObjetivo = -1   ->  No encontro la solucion
       
       */
       Integer alcanzoObjetivo = 0;
       Integer ciudadActual=-1;
       
       while( alcanzoObjetivo == 0 ){           
           if( frontera.isEmpty() ){
               alcanzoObjetivo = -1;
           } else {
               ciudadActual = frontera.get(0);
               frontera.remove(0);
               
               if( ciudadActual == ciudadObjetivo ){
                   alcanzoObjetivo = 1;
               } else if( !ciudadesVisitadas.contains(ciudadActual) ) {
                   ciudadesVisitadas.add( ciudadActual );
                   
                   if( !frontera.contains(ciudadActual) ){
                   
                        List<Integer> hijos = obtenerCiudadesVecinas( ciudadActual, mapa );

                        //Colocar los hijos en la frontera
                        for( Integer h : hijos ){
                            frontera.add(h);
                        }
                   }
                   
               }
           }
       }
       
       
       System.out.println("Estado:"+alcanzoObjetivo);
       
       System.out.println("Frontera");
       HashMap<Integer, String> nombresCiudades = nombres();
       for( Integer p:frontera ){
           System.out.println( nombresCiudades.get(p) );
       }
       
       return ciudadesVisitadas;
    }
    
    public static int indiceFronteraMejorCiudad( List<Integer> frontera, 
            int[] valores_heuristicos ){
        int indice = 0;
        int i;
        Integer menorValor = valores_heuristicos[ frontera.get(0) ];
        
        for( i=1; i<frontera.size(); i++ ){
            Integer ciudad = frontera.get(i);
            Integer valor_heuristico_ciudad = valores_heuristicos[ ciudad ];
            
            if( menorValor > valor_heuristico_ciudad ){
                menorValor = valor_heuristico_ciudad;
                indice = i;
            }
        }
        
        return indice;
    }
    
    
    public static List<Integer> greedyBFS( int ciudadOrigen, int ciudadObjetivo, 
            int[][] mapa, int[] valores_heuristicos ){
       List<Integer> frontera = new ArrayList<Integer>();
       List<Integer> ciudadesVisitadas = new ArrayList<Integer>();
       
        //Añadimos la ciudad inicial
       frontera.add( ciudadOrigen );
       
       
       HashMap<Integer, String> nombresCiudades = nombres();
       HashMap<String,Integer> indicesCiudades = indices();
       /*
         alcanzoObjetivo = 0   ->  No encuentra respuesta pero aun resta explorar soluciones
         alcanzoObjetivo = 1   ->  Encontro la solucion
         alcanzoObjetivo = -1   ->  No encontro la solucion
       
       */
       Integer alcanzoObjetivo = 0;
       Integer ciudadActual=-1;
       
       while( alcanzoObjetivo == 0 ){           
           if( frontera.isEmpty() ){
               alcanzoObjetivo = -1;
           } else {               
               int mejorIndice = indiceFronteraMejorCiudad( frontera, valores_heuristicos );
               //System.out.println("MejorInd:"+mejorIndice);
               int u=0;
               /*for( Integer y : frontera ){
                   System.out.println("F["+(u++)+"]:"+nombresCiudades.get(y)+" ("+y+")");
               }*/
               ciudadActual = frontera.get( mejorIndice );
               //System.out.println("Ciduad actual:"+nombresCiudades.get(ciudadActual));
               frontera.remove( mejorIndice );
               
               if( ciudadActual == ciudadObjetivo ){
                   alcanzoObjetivo = 1;
               } else if( !ciudadesVisitadas.contains(ciudadActual) ) {
                   ciudadesVisitadas.add( ciudadActual );
                   
                   if( !frontera.contains(ciudadActual) ){
                   
                        List<Integer> hijos = obtenerCiudadesVecinas( ciudadActual, mapa );

                        //Colocar los hijos en la frontera
                        for( Integer h : hijos ){
                            frontera.add(h);
                        }
                   }
                   
               }
           }
       }
       
       
       System.out.println("Estado:"+alcanzoObjetivo);
       
       System.out.println("Frontera");
       for( Integer p:frontera ){
           System.out.println( nombresCiudades.get(p) );
       }
       
       return ciudadesVisitadas;
    }
    
    
    public static HashMap<Integer,String> nombres(){
        HashMap<Integer, String> nombresCiudades = new HashMap<Integer,String>();
        nombresCiudades.put(0, "Arad");
        nombresCiudades.put(1, "Zerind");
        nombresCiudades.put(2, "Timisoara");
        nombresCiudades.put(3, "Oradea");
        nombresCiudades.put(4, "Sibiu");
        nombresCiudades.put(5, "Lugoj");
        nombresCiudades.put(6, "Mehadia");
        nombresCiudades.put(7, "Drobeta");
        nombresCiudades.put(8, "Rimnicu");
        nombresCiudades.put(9, "Craiova");
        nombresCiudades.put(10, "Pitesti");
        nombresCiudades.put(11, "Fagaras");
        nombresCiudades.put(12, "Bucharest");
        nombresCiudades.put(13, "Giurgiu");
        nombresCiudades.put(14, "Urziceni");
        nombresCiudades.put(15, "Vaslui");
        nombresCiudades.put(16, "Hirsova");
        nombresCiudades.put(17, "Eforie");
        nombresCiudades.put(18, "Iasi");
        nombresCiudades.put(19, "Neamt");
        return nombresCiudades;
    }
    
    public static HashMap<String,Integer> indices(){
        HashMap<String,Integer> nombresCiudades = new HashMap<String,Integer>();
        nombresCiudades.put("Arad",0);
        nombresCiudades.put("Zerind",1);
        nombresCiudades.put("Timisoara",2);
        nombresCiudades.put("Oradea",3);
        nombresCiudades.put("Sibiu",4);
        nombresCiudades.put("Lugoj",5);
        nombresCiudades.put( "Mehadia",6);
        nombresCiudades.put("Drobeta",7);
        nombresCiudades.put( "Rimnicu",8);
        nombresCiudades.put( "Craiova",9);
        nombresCiudades.put( "Pitesti",10);
        nombresCiudades.put("Fagaras",11);
        nombresCiudades.put( "Bucharest",12);
        nombresCiudades.put( "Giurgiu",13);
        nombresCiudades.put( "Urziceni",14);
        nombresCiudades.put( "Vaslui",15);
        nombresCiudades.put( "Hirsova",16);
        nombresCiudades.put("Eforie",17);
        nombresCiudades.put( "Iasi",18);
        nombresCiudades.put("Neamt",19);
        return nombresCiudades;
    }
    
    
    
    
   //Programa
    public static void main(String[] params) throws FileNotFoundException{
        
        //Nombre de arhcivo de ciudades
        String nombre_archivo_Mapa = "/CiudadesRumania.txt";
        int[][] mapaRumania =  leerMapa( nombre_archivo_Mapa );
        
        //Mapa de Rumania    
        //int[][] mapaRumania = obtenerMapaRumania();    //Mal hecho :(
        //La tabla de los valores se encuentra en la página 93 del libro
        
        String nombre_archivo_val_heu = "E:/valores_heuristicos.txt";
        int[] valores_heuristicos = leerValoresHeuristicos(nombre_archivo_val_heu);
        //int[] valores_heuristicos = { 366, 374, 329, 380, 253, 244, 241, 242, 193, 160, 176,0, 77, 80, 199, 151, 161, 226, 234  };
        
        System.out.println("Valores heuristicos:"+valores_heuristicos.length);
        int ciudad_origen = 0;
        int ciudad_objetivo = 12;
        HashMap<Integer, String> nombresCiudades = nombres();
        
        List<Integer> visitados = greedyBFS( ciudad_origen, 
                ciudad_objetivo, mapaRumania, valores_heuristicos );
        for( Integer c : visitados ){
            System.out.println("Visitó: "+nombresCiudades.get(c));
        }
    }
}







































