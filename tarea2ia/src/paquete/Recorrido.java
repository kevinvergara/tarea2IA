package paquete;

import java.util.ArrayList;
import java.util.Stack;

public class Recorrido {
    
    public String[][] buscarSolucion(int numColores,int numFilas,int numColumnas,ArrayList columnas,ArrayList filas){
        //iniciar matriz
        String [][] matriz = new String[numFilas][numColumnas];
        
        for(int i=0;i<numFilas;i++){
            for(int j=0;j<numColumnas;j++){
                matriz[i][j]=" ";
            }
        }
        //---------------
        
        
        Heuristica metodos = new Heuristica();
        
        //Stack pila = new Stack();//push ...pop
        
        //pintar cuando nodo vacios (color=z) sea igual cantidad de espacios vacios en la matriz
        
        
        int cambio=1;
        
        //while(cambio!=0){
            cambio=0;
            
            //primero filas
            
            for(int i = 0;i<numFilas;i++){
                
                //filas 
                System.out.println("procesando filas");
                ArrayListFila auxListFila = new ArrayListFila();
                auxListFila = (ArrayListFila)filas.get(i);
                
                for(int j=0;j<numColores;j++){
                    Color auxColor = new Color();
                    auxColor = auxListFila.getColor(j);
                    System.out.println("ncolor :"+auxColor.getNumero()+" nvacios: "+metodos.numVaciosFila(matriz, i));
                    if(auxColor.getNumero() == metodos.numVaciosFila(matriz, i)){
                        cambio=1;
                        System.out.println("fgasf: filas");
                        matriz = metodos.pintarFilaCompleta(matriz,auxColor.getColor(),i).clone();
                        metodos.imprimirMatriz(matriz);
                    }
                }
            }
            
            for(int i = 0;i<numColumnas;i++){
                //columnas
                System.out.println("procesando columnas");
                ArrayListColumna auxListColumna = new ArrayListColumna();
                auxListColumna = (ArrayListColumna)columnas.get(i);
                
                for(int j=0;j<numColores;j++){
                    Color auxColor = new Color();
                    auxColor = auxListColumna.getColor(j);
                    System.out.println("ncolor :"+auxColor.getNumero()+" nvacios: "+metodos.numVaciosColumnas(matriz, i));
                    if(auxColor.getNumero() == metodos.numVaciosColumnas(matriz, i)){
                        cambio = 1;
                        System.out.println("skdf: columnas");
                        matriz = metodos.pintarColumnaCompleta(matriz, auxColor.getColor(), i).clone();
                        metodos.imprimirMatriz(matriz);
                    }
                }
            
            }
            
            
        
        //}//fin while principal
        return matriz;
    }
}
