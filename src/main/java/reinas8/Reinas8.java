package reinas8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reinas8 {

    
    public static int numeroAtaquesDiagonalInferior( int[][] T, int R, int fila ){
        int numeroTotalAtaques = 0;        
        int j,i;
        
        //Columnas
        for( j=R+1,i=fila+1; j<8 && i<8; j++,i++ ){
            if( T[i][j] == 1 ){
                numeroTotalAtaques++;
            }
        }
        
        return numeroTotalAtaques;
    }
    
    public static int numeroAtaquesDiagonalSuperior( int[][] T, int R, int fila ){
        int numeroTotalAtaques = 0;        
        int j,i;
        
        //Columnas
        for( j=R+1,i=fila-1; j<8 && i>=0; j++,i-- ){
            if( T[i][j] == 1 ){
                numeroTotalAtaques++;
            }
        }        
        return numeroTotalAtaques;
    }
    
    public static int numeroAtaquesHorizontales( int[][] T, int R, int fila ){
        int numeroTotalAtaques = 0;        
        int j;
        
        for( j=R+1; j<8; j++ ){
            if( T[fila][j] == 1 ){
                numeroTotalAtaques++;
            }
        }        
        return numeroTotalAtaques;
    }
    
    public static int numeroTotalAtaques( int[][] T ){
        int[] posicionesReinas = { 4, 5, 6, 3, 4, 5, 6, 5 };
        
        int i,j;
        int H = 0;
        //Visitar cada columna donde hay una reina
        for( j = 0; j<8; j++ ){
            H = H + numeroAtaquesHorizontales( T, j, obtenerFila(T, j) );
            H = H + numeroAtaquesDiagonalInferior( T, j, obtenerFila(T, j) );
            H = H + numeroAtaquesDiagonalSuperior( T, j, obtenerFila(T, j) );            
        }
        
        return H;
    }    
    
    public static int obtenerFila( int[][] T, int reina ){
        int filaReina;
        for( int i=0; i<8; i++ ){
            if( T[i][reina] == 1 ){
                return i;
            }
        }
        return -1;
    }
    
    public static int[][] copiarMatriz( int[][] T ){
        int i,j;
        int[][] nuevaMatriz = new int[8][8];
        for( i=0; i<8; i++ ){
            for( j=0; j<8; j++ ){
                nuevaMatriz[i][j] = T[i][j];
            }
        }
        return nuevaMatriz;
    }
    
    public static List<int[][]> obtenerHijos( int[][] T, int reina ){
        List<int[][]> hijos = new ArrayList<int[][]>();
        
        int fila = obtenerFila( T, reina );
        T[fila][reina] = 0;
        
        for( int i = 0; i<8; i++ ){
            if( i != fila ){
                int[][] hijo_x = copiarMatriz( T );
                hijo_x[i][reina] = 1;
                
                hijos.add( hijo_x );
            }
        }
        
        T[fila][reina] = 1;
                
        return hijos;
    }
    
    public static List<int[][]> obtenerTablerosHijos( int[][] T ){
        List<int[][]> hijos = new ArrayList<int[][]>();
        int reina;
        
        for( reina=0; reina<8; reina++ ){
            List<int[][]> hijosReina = obtenerHijos(T, reina);
            hijos.addAll(hijosReina);
        }
        
        return hijos;
    }
    
    public static List<Integer> heuristicaHijos( List<int[][]> hijos ){
        List<Integer> heuristicas = new ArrayList<Integer>();
        
        for( int i = 0; i < hijos.size(); i++ ){
            int heuristicaHijo = numeroTotalAtaques( hijos.get(i) );            
            heuristicas.add( heuristicaHijo );
            /*
            System.out.println("Heuristica "+i+" = "+heuristicaHijo);
            reportarMatriz( hijos.get( i ) );
            */
        }
        return heuristicas;
    }
    
    
    
    public static int[][] HillClimbing( int[][] T ){
        boolean alcanzoMaximoLocal = false;
        
        Integer valorMinimo = Integer.MAX_VALUE;
        Integer posicionValorMinimo = -1;
        
        Integer heuristicaPadre = 0;
        
        while( alcanzoMaximoLocal == false ){
            heuristicaPadre = numeroTotalAtaques( T );
            /*
            System.out.println("**Heuristica padre = "+heuristicaPadre);
            reportarMatriz( T );
            System.out.println("++++++++++++++++++++++++++++++++++++");
            */
            List<int[][]> hijos = obtenerTablerosHijos( T );
            List<Integer> heuristicasHijos = heuristicaHijos( hijos );
            
            for( int i = 0; i<heuristicasHijos.size(); i++ ){
                if( valorMinimo > heuristicasHijos.get(i) ){
                    valorMinimo = heuristicasHijos.get(i);
                    posicionValorMinimo = i;
                    
                }
            }
            /*
            System.out.println("**Mejor Heuristica = "+valorMinimo);
            reportarMatriz( hijos.get( posicionValorMinimo ) );
            System.out.println("===========================================");
            */
            if( heuristicasHijos.size()>0 && valorMinimo!=0 && valorMinimo < heuristicaPadre ){
                T = hijos.get( posicionValorMinimo );                
            } else {
                alcanzoMaximoLocal = true;
            }
        }
        
        return T;
    }
    
    //Muestra en pantalla la matriz
    public static void reportarMatriz( int[][] T ){
        for( int i = 0; i<8; i++ ){
            for( int j = 0; j<8; j++ ){
                System.out.print(T[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
    
    public static double schedule( int MAX_tiempo, int tiempo ){
        double temperatura_MAX = 20.0;
        double temperatura_MIN = 0.0;
        
        double temperatura = 0.0;
        
        if( tiempo >= MAX_tiempo  ){
            return temperatura_MIN;
        } else {
            temperatura = temperatura_MAX - 
                    ((temperatura_MAX-temperatura_MIN) / (MAX_tiempo-1))*(tiempo-1);
        }
        
        return temperatura;
    }
    
    
    
    
    public static void SimulatedAnnealing( int[][] T ){
        int MAX_Tiempo = 4;
        int tiempo = 0;
        double temperatura = 0.0;
        
        /*
        0 -> Buscando solución
        1 -> Enfriado y solución encontrada
        -1 -> Enfriado y solución no encontrada
        */
        int alcanzaObjetivo = 0;
        
        for( tiempo = 1; tiempo <= MAX_Tiempo; tiempo++){
            temperatura = schedule( MAX_Tiempo, tiempo );
            
            if( temperatura == 0.0 ){
                System.out.println("Llegó a la mínima temperatura");
                alcanzaObjetivo = 1;
            } else {
                List<int[][]> hijos = obtenerTablerosHijos( T );
                
                //Clase que brinda numeros aleatorios
                Random r = new Random();
                int numeroAleatorio = r.nextInt( hijos.size() );
                
                int[][] next = hijos.get( numeroAleatorio );
                int E = ( numeroTotalAtaques( next ) - numeroTotalAtaques( T ) )*-1;
                if( E>0 ){
                    T = next;
                } else {
                    double probabilidad_SA = Math.exp( E/temperatura );
                    double probabilidad_actual = r.nextDouble();
                    
                    if( probabilidad_actual < probabilidad_SA ){
                        T = next;
                    }
                }
            }
        
        }
        
    }
    
    
    
    
    
    
    
    
    //Programa
    public static void main(String[] args) {
        int[][] tablero = {
            { 0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0 },
            { 0,0,0,0,0,0,0,0 },
            { 0,0,0,1,0,0,0,0 },
            { 1,0,0,0,1,0,0,0 },
            { 0,1,0,0,0,1,0,1 },    
            { 0,0,1,0,0,0,1,0 },    
            { 0,0,0,0,0,0,0,0 }
        };
        
        System.out.println("-----------------------------------------");
        System.out.println("Problema de 8 reinas usando Hill-Climbing");
        System.out.println("-----------------------------------------\n");
        //Estado Inicial
        int H = numeroTotalAtaques( tablero );
        System.out.println("Estado Inicial - Heurística = "+H);
        reportarMatriz( tablero );
        
        //Estado Final
        int[][] mejorPadre = HillClimbing( tablero );
        System.out.println("\nEstado Final - Heurística = "+numeroTotalAtaques( mejorPadre ));
        reportarMatriz( mejorPadre );
    }
}



















