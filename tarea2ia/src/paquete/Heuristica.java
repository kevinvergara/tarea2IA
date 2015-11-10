package paquete;

import java.util.ArrayList;

public class Heuristica {
    
    public nodoPrincipal colorIgualVacio(nodoPrincipal nodo){
        
        
        //variables de matriz
        int numFilas,numColumnas,numColores;
        numColumnas = nodo.getnColumnas();
        numFilas = nodo.getnFilas();
        numColores = nodo.getnColores();
        
        String [][] matriz = new String [numFilas][numColumnas];
        matriz = clonarMatriz(nodo.getMatriz());
        //-------------------
        
        //variables de filas y columnas
        ArrayList<ArrayListColumna> columnas = new ArrayList<ArrayListColumna>();
        columnas = (ArrayList<ArrayListColumna>)nodo.getColumnas();
        
        ArrayList<ArrayListFila> filas = new ArrayList<ArrayListFila>();
        filas = (ArrayList<ArrayListFila>)nodo.getFilas();
        //---------------------------
        
        
        //pintar cuando nodo vacios (color=z) sea igual cantidad de espacios vacios en la matriz
        
        int cambio=1;
        
        while(cambio!=0){
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
                    System.out.println("ncolor :"+auxColor.getNumero()+" nvacios: "+numVaciosFila(matriz, i));
                    if(auxColor.getNumero()!=0 && numVaciosFila(matriz, i)!=0){
                        if(auxColor.getNumero() == numVaciosFila(matriz, i)){
                            cambio=1;
                            System.out.println("fgasf: filas");
                            matriz = pintarFilaCompleta(matriz,auxColor.getColor(),i).clone();

                            ((ArrayListFila)filas.get(i)).getColor(j).setNumero(0);
                            for(int x=0;x<numColumnas;x++){
                                if(((ArrayListColumna)columnas.get(x)).getColor(j).getNumero()!=0){    
                                    ((ArrayListColumna)columnas.get(x)).getColor(j).setNumero((((ArrayListColumna)columnas.get(x)).getColor(j).getNumero())-1);
                                }
                            }
                            imprimirMatriz(matriz);
                        }
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
                    System.out.println("ncolor :"+auxColor.getNumero()+" nvacios: "+numVaciosColumnas(matriz, i));
                    if(auxColor.getNumero()!=0 && numVaciosColumnas(matriz, i)!=0){    
                        if(auxColor.getNumero() == numVaciosColumnas(matriz, i)){
                            cambio = 1;
                            System.out.println("skdf: columnas");
                            matriz = pintarColumnaCompleta(matriz, auxColor.getColor(), i).clone();
                            
                            ((ArrayListColumna)columnas.get(i)).getColor(j).setNumero(0);
                            
                            for(int x=0;x<numFilas;x++){
                                if(((ArrayListFila)filas.get(x)).getColor(j).getNumero()!=0){
                                    ((ArrayListFila)filas.get(x)).getColor(j).setNumero((((ArrayListFila)filas.get(x)).getColor(j).getNumero())-1);
                                }
                            }
                            
                            imprimirMatriz(matriz);
                        }
                    }
                }
            
            }
        }//fin while principal
        
        
        nodo.setColumnas(columnas);
        nodo.setFilas(filas);
        nodo.setMatriz(clonarMatriz(matriz));
        
        return nodo;
    }
    
    
    
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
   
}
