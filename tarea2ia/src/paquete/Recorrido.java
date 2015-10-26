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
        
        Stack pila = new Stack();//push ...pop
        
        //pintar cuando nodo vacios (color=z) sea igual cantidad de espacios vacios en la matriz
        
        
        int cambio=1;
        
        while(cambio!=0){
            cambio=0;
            
            //primero filas
            
            for(int i = 0;i<numFilas;i++){
                
                ArrayListFila auxListFila = new ArrayListFila();
                auxListFila = (ArrayListFila)filas.get(i);
                
                for(int j=0;j<numColores;j++){
                    Color auxColor = new Color();
                    auxColor = auxListFila.getColor(i);
                    if(auxColor.getNumero() == auxListFila.getNumVacios()){
                        cambio=1;
                        metodos.pintarFilaCompleta(matriz,auxColor.getColor(),i);
                        ((ArrayListFila)filas.get(i)).setNumVacios(0);
                                                
                    }
                    
                    
                    
                }
            }
            
            
            
        
        }
        return matriz;
    }
}
