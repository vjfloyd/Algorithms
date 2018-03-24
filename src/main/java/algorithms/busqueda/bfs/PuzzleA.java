package algorithms.busqueda.bfs;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author vjrojasb
 */
public class PuzzleA {

    ArrayList<String> lista = new ArrayList<String>();
   private String estado_inicial = "201475863";
   private static String estado_final = "123456780";
   private String estado_actual;
   private String estado_anterior;
   private String estado_siguiente;
   private Boolean visitado;
   private static List<String> nodosVisitados = new ArrayList<String>();
   private static List<String> nodosHijos =  new ArrayList<String>();
   private static int INF = 1000000;
  
   
   public static  List<String> expandirNodos(String puzzle){
        //012345678 
        //201475863
        String mov;
        int indice = puzzle.indexOf("0");
        if( indice != 0 && indice != 3 && indice != 6  ){
            mov = puzzle.substring(0, indice - 1) + "0" + puzzle.charAt(indice-1) + puzzle.substring(indice+1);
            nodosHijos.add(mov);
        }
        if( indice != 2 && indice != 5 && indice != 8){
            mov = puzzle.substring(0, indice) + puzzle.charAt(indice + 1) + "0"+ puzzle.substring(indice + 2);
            nodosHijos.add(mov);
        }
        if( indice > 2 ){           
            mov = puzzle.substring(0, indice-3) + puzzle.charAt(indice) + puzzle.substring(indice-2, indice)+ puzzle.charAt(indice-3)+ puzzle.substring(indice +1);
            nodosHijos.add(mov);    
        }        
        if( indice < 6) {
            mov = puzzle.substring(0, indice )+ puzzle.charAt(indice+3)+ puzzle.substring(indice+1, indice+3)+ puzzle.charAt(indice) + puzzle.substring(indice+4);
            nodosHijos.add(mov);
        }     
        return nodosHijos;
   }
   
   
   public int getManhattanPriority(String puzzle){
       String ef = "123456780";
       System.out.println(" length = " + puzzle.length());
       int index;
       int value;
       int pos_val;
       int manhatan  = 0;
       for (int i = 0; i < 8; i++) {
           value = puzzle.charAt(i) - 48;
           if (value == 0) {
               index = 8;
           } else {
               index = puzzle.indexOf(value + 48) + 1;

           }
           pos_val = value;
           manhatan = pos_val - index;
           if (manhatan < 0) {
               manhatan *= -1;
           }
           manhatan += manhatan;
       }
       
       return manhatan;
       
   }
   
   public static boolean discovered(String w){
       for (int i = 0; i <  nodosVisitados.size() ; i++) {
           if (w.equals(nodosVisitados.get(i))) {
               return true;
           }
       }
       return false;
   } 
   
    public Boolean esta_en_lista(String estado){
        Boolean visitado = false;
        for (String l : lista) {
            if ( l.equals(estado)) {
                return !visitado;
            }
        }
        return visitado;
    }
 
    public void bfs(Nodo root){
       Queue<String> cola = new LinkedList<>();
       nodosHijos = expandirNodos(estado_inicial);
       Nodo nodo =  new Nodo();
       List<Nodo> listaNodos = new ArrayList<>();
        for (String nodosHijo : nodosHijos) {
            nodo.distancia =  INF;
            nodo.padre = null;
            nodo.valor = nodosHijo;
            listaNodos.add(nodo);
        }
       root.distancia = 0;
       cola.add(root.getValor());
       
       while(!cola.isEmpty()){
           Nodo actual = new Nodo();
           actual.setValor( cola.peek());
           for (Nodo listaNodo : listaNodos) {
               if (listaNodo.getDistancia() == INF) {
                   listaNodo.setDistancia(actual.distancia + 1);
                   listaNodo.setPadre(actual);
                   cola.add(listaNodo.getValor());
               }
           }
           
           
           
       }
    }
    
    public void bfsA(Nodo root){
        Nodo estado_actual =  new Nodo();
        root.distancia = 0;
        root.padre = null;
        root.valor = estado_inicial;
        
        if(estado_final.equals(estado_actual.getValor())){
            return;
        }
    }
 
    
    public void imprimir(String v){
        System.out.println(v);
    }
            
            
    public static void main(String[] args) {
       
       // LinkedQueue<String> q = new LinkedQueue<String>();
        //Nodo nodo = 
       //bfs(estado_i)
        
    }
}
    
    
    
    
