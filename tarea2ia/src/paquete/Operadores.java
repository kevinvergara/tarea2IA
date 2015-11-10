package paquete;

import java.util.ArrayList;

public class Operadores {
    public String[][] pintarFilaCompleta(String [][] matriz,String color,int fila){
        
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[fila][i].equals(" ")){
                matriz[fila][i]=color;
            }
        }
        return (clonarMatriz(matriz));
    }
    
    public String[][] pintarColumnaCompleta(String [][] matriz,String color,int columna){
        for(int i=0;i<matriz[0].length;i++){
                if(matriz[i][columna].equals(" ")){
                    matriz[i][columna]=color;
                }
            }
        return (clonarMatriz(matriz));
    }
    
    //-------------acciones secundarias-------------------------------------
    public String [][] clonarMatriz(String [][] matriz){
        if(matriz==null) return null;
        
        String [][] matrizNueva = new String [matriz.length][matriz[0].length];
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                matrizNueva[i][j]=matriz[i][j];
            }
        }
        
        return matrizNueva;
    }
    
    public void imprimirMatriz(String [][] matriz){
        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    
    }
    //
    //retornar numeros vacios de fila
    public int numVaciosFila(String [][] matriz,int fila){
        int vacios=0; 
        
        for(int i=0;i<matriz.length;i++){
            if(matriz[fila][i].equals(" ")) vacios++;
        }
        
        return vacios;
    }
    
    public int numVaciosColumnas (String [][] matriz,int col){
        int vacios=0;
        
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[i][col].equals(" ")) vacios++;
        }
        return vacios;
    }
    //espacios vacios en una matriz
    public int [] posicionVacia(Nodo nodo){
        int [] posicion = new int [2];
        
        for(int i=0;i<nodo.getMatriz().length;i++){
            for(int j=0;j<nodo.getMatriz().length;j++){
                if(nodo.getMatriz()[i][j].equals(" ")){
                    posicion[0]=i;
                    posicion[1]=j;
                    if(coloresComunes(nodo,posicion)!=null){
                        return posicion;
                    }
                }
            }
        }
        return null;
    }
    //----------
    //colores comunes en una posicion
    public String [] coloresComunes(Nodo nodo,int [] posicion){
        ArrayList<String> auxColores = new ArrayList<String>();
        
        ArrayListColumna columna = new ArrayListColumna();
        columna = (ArrayListColumna)nodo.getColumnas().get(posicion[1]);
        
        ArrayListFila fila = new ArrayListFila();
        fila = (ArrayListFila)nodo.getFilas().get(posicion[0]);
        //----------
        for(int i=0;i<nodo.getnColores();i++){
            if(fila.getColor(i).getNumero()!=0){
                if(columna.getColor(i).getNumero()!=0){
                    auxColores.add(columna.getColor(i).getColor());
                }
            }
        }
        
        if(auxColores.size() == 0) return null;
        
        String [] colores = new String [auxColores.size()];
        
        for(int i=0;i<auxColores.size();i++){
            colores[i] = auxColores.get(i);
        }
        
        return colores;
    }
    //_-------------
}
