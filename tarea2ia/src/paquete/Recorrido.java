
package paquete;

import java.util.Stack;

public class Recorrido {
    private Stack pila = new Stack();
     //private final Cola cola = new Cola();
    
    public String [][] recorrido(Nodo raiz){
        
        Heuristica heuristica = new Heuristica();
        Operadores operadores = new Operadores();
        Nodo nodoActual = new Nodo();
        
        raiz = (Nodo)heuristica.colorIgualVacio(raiz);
              
        operadores.imprimirNodo(raiz);
        
        if(raiz!=null){
                pila.push(raiz); 
            while(!pila.empty()){//mientras la pila no este vacia
                nodoActual = (Nodo)pila.pop();

                //aplicar primera heuristica de nuevo
                nodoActual = (Nodo)heuristica.colorIgualVacio(nodoActual);
                
                System.out.println("---nodo actual inicio---");
                operadores.imprimirNodo(nodoActual);
                System.out.println("---nodo actual final---");
                //-----
                
                int [] posicion = null;
                posicion = operadores.posicionVacia(nodoActual);
                
                System.out.println("nivel: "+nodoActual.getNivel());
                
                if(posicion != null) System.out.println("posicion nueva: "+posicion[0]+","+posicion[1]);
                //si posicion es null, quiere decir que encontro matriz candidata a solucion, o que el camino
                //es incorrecto
                if(posicion == null){
                    FuncionObjetivo FO = new FuncionObjetivo();
                    if(FO.solucion(nodoActual)==true){
                        return nodoActual.getMatriz();
                    }
                }else{//crear nodos si el camino sera valido

                    String [] coloresComunes = null;
                    coloresComunes = operadores.coloresComunes(nodoActual, posicion);
                    if(coloresComunes.length != 0){
                        for(int i=0;i<coloresComunes.length;i++){
                            Nodo nuevoNodo = (Nodo)operadores.nuevoNodo(new Nodo(nodoActual.getHijos(),nodoActual.getColumnas(),nodoActual.getFilas(),operadores.clonarMatriz(nodoActual.getMatriz()),nodoActual.getnColumnas(),nodoActual.getnFilas(),nodoActual.getnColores(),nodoActual.getNivel()), posicion, coloresComunes[i]);
                            //operadores.imprimirNodo(nuevoNodo);
                            nodoActual.addHijo(nuevoNodo);
                            pila.push((Nodo)nuevoNodo);
                        }
                    }
                }

            }//fin while
        }//if raiz no existe
        
        return null;    
    }
}
