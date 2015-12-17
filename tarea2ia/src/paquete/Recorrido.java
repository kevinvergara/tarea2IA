
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
              
        int cambio=1;
        
        while(cambio!=0){
            cambio=0;
            
            nodoActual.setCambio(0);
            nodoActual = (Nodo)heuristica.dosNoSeguidos(nodoActual);
            operadores.imprimirNodo(nodoActual);
            
            if(nodoActual.getCambio()==1){
                cambio=1;
            }
            
            nodoActual.setCambio(0);
            nodoActual = (Nodo)heuristica.colorIgualVacio(raiz);
            operadores.imprimirNodo(nodoActual);
        
            if(nodoActual.getCambio()==1){
                cambio=1;
            }
        }
        return nodoActual.getMatriz();    
    }
}
