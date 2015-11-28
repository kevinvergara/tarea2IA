
package paquete;

import java.util.Stack;

public class Recorrido {
    private Stack pila = new Stack();
     //private final Cola cola = new Cola();
    
    public String [][] recorrido(Nodo raiz){
        
        Heuristica heuristica = new Heuristica();
        Operadores operadores = new Operadores();
        Nodo nodoActual = new Nodo();
        
        nodoActual = (Nodo)heuristica.colorIgualVacio(raiz);
              
        operadores.imprimirNodo(nodoActual);
        
        return nodoActual.getMatriz();    
    }
}
