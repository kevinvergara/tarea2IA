
package paquete;

import java.util.Stack;

public class DFS {
    private Stack pila = new Stack();
    
    public String [][] dfs(Nodo raiz){
        
        Heuristica heuristica = new Heuristica();
        Operadores operadores = new Operadores();
        Nodo nodoActual = new Nodo();
        
        
        raiz = (Nodo)heuristica.colorIgualVacio(raiz);
        
        System.out.println("resultado heuristica 1: ");
        operadores.imprimirMatriz(raiz.getMatriz());
        
        
        if(raiz!=null){
                pila.push(raiz);
            while(!pila.empty()){//mientras la pila no este vacia
                nodoActual = (Nodo)pila.pop();

                //aplicar primera heuristica de nuevo
                
                nodoActual = (Nodo)heuristica.colorIgualVacio(nodoActual);
              
                //-----
                int [] posicion = null;
                posicion = operadores.posicionVacia(nodoActual.getMatriz());
             
                //si posicion es null, quiere decir que encontro solucion
                if(posicion == null){
                    return nodoActual.getMatriz();
                }
                //----------
                
                


            }//fin while
        }//if raiz no existe
        
        return null;    
    }
}
