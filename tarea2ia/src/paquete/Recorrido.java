package paquete;

import java.util.ArrayList;
import java.util.Stack;

public class Recorrido {
    
    public String[][] buscarSolucion(int numFilas,int numColumnas,ArrayList columnas,ArrayList filas){
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
        
        //pintar cuando nodo vacios sea igual cantidad de espacios vacios en la matriz
        
        //primero filas
        
        
        
        
        
    
        return null;
    }
}
