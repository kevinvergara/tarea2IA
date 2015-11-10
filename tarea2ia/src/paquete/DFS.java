
package paquete;

import java.util.Stack;

public class DFS {
    private Stack pila = new Stack();
    
    public String [][] dfs(Nodo raiz){
        
        Heuristica heuristica = new Heuristica();
        Operadores operadores = new Operadores();
        Nodo nodoActual = new Nodo();
        
        
        raiz = (Nodo)heuristica.colorIgualVacio(raiz);
        
        System.out.println("solucion: ");
        operadores.imprimirMatriz(raiz.getMatriz());
        /*
        
        
        if(raiz!=null){
                pila.push(null);
                pila.push((Nodo)raiz);
            while(!pila.empty()){//mientras la pila no este vacia
                nodoActual = (Nodo)pila.pop();







            }//fin while
        }//if raiz no existe
                */
        return null;    
    }
}
