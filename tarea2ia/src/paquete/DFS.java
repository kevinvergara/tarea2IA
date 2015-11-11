
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
                posicion = operadores.posicionVacia(nodoActual);
             
                //si posicion es null, quiere decir que encontro matriz candidata a solucion, o que el camino
                //es incorrecto
                if(posicion == null){
                    FuncionObjetivo FO = new FuncionObjetivo();
                    if(FO.solucion(nodoActual)==true){
                        return nodoActual.getMatriz();
                    }
                }else{//crear nodos si el camino sera valido
                    
                    int [] coloresComunes = null;
                    coloresComunes = operadores.coloresComunes(nodoActual, posicion);

                    for(int i=0;i<coloresComunes.length;i++){
                        Nodo nuevoNodo = (Nodo)operadores.nuevoNodo(nodoActual, posicion, coloresComunes[i]);
                        nodoActual.addHijo(nuevoNodo);
                        pila.push((Nodo)nuevoNodo);
                    }
                }

            }//fin while
        }//if raiz no existe
        
        return null;    
    }
}
