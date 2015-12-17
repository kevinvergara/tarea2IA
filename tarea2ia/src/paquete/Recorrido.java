
package paquete;

import java.io.IOException;
import java.util.Stack;

public class Recorrido {
    private Stack pila = new Stack();
     //private final Cola cola = new Cola();
    
    public String [][] recorrido(Nodo raiz) throws IOException{
        
        Heuristica heuristica = new Heuristica();
        Operadores operadores = new Operadores();
        Nodo nodoActual = new Nodo();
        nodoActual = (Nodo)raiz;
        //nodoActual = (Nodo)heuristica.colorIgualVacio(raiz);
              
        //operadores.imprimirNodo(nodoActual);
        
        nodoActual = (Nodo)heuristica.dosNoSeguidos(nodoActual);
        
        operadores.imprimirNodo(nodoActual);
        
        return nodoActual.getMatriz();    
    }
}
