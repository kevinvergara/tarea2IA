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
        for(int i=0;i<matriz.length;i++){
            if(matriz[i][columna].equals(" ")){
                matriz[i][columna]=color;
            }
        }
        return (clonarMatriz(matriz));
    }
    
    public String [][] pintarPosicion(String [][] matriz, int fila, int columna, String color){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(i==fila && j==columna){
                    matriz[i][j] = color;
                }
            }
        }
        
        return clonarMatriz(matriz.clone());
    }
    //-------------acciones secundarias-------------------------------------
    public String [][] clonarMatriz(String [][] matriz){
        if(matriz==null) return null;
        String aux;
        String [][] matrizNueva = new String [matriz.length][matriz[0].length];
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                aux = matriz[i][j];
                matrizNueva[i][j]=aux+"";
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
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[fila][i].equals(" ")) vacios++;
        }
        //System.out.println("sfila: "+vacios);
        return vacios;
    }
    
    public int numVaciosColumnas (String [][] matriz,int col){
        int vacios=0;
        
        for(int i=0;i<matriz.length;i++){
            if(matriz[i][col].equals(" ")) vacios++;
        }
        
        //System.out.println("scolu: "+vacios);
        return vacios;
    }
    

    //return true si la matriz esta llena, si es false es que la matriz tiene espacios
    public boolean matrizLlena(String [][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(matriz[i][j].equals(" ")) return false;
            }
        }
        return true;
    }

    ///
    public boolean imprimirNodo(Nodo nodo){
        if(nodo==null) return false;
        System.out.println("----------Nodo-----------");
        this.imprimirMatriz(nodo.getMatriz());
        
        ArrayList<ArrayListColumna> arrayColumnas = new ArrayList<ArrayListColumna>();
        arrayColumnas = (ArrayList<ArrayListColumna>)nodo.getColumnas();
        
        ArrayList<ArrayListFila> arrayFilas = new ArrayList<ArrayListFila>();
        arrayFilas = (ArrayList<ArrayListFila>)nodo.getFilas();
        
                
        System.out.println("--filas--");
        
        for(int i=0;i<arrayFilas.size();i++){
            System.out.print("fil: "+i);
           for(int j=0;j<nodo.getnColores();j++){
               Color auxColor = new Color();
               auxColor = (Color)arrayFilas.get(i).getColor(j);
               System.out.print("|"+auxColor.getColor()+"-"+auxColor.getNumero()+"-"+auxColor.isSeguido()+"|");
           }
           System.out.println();
        }
        
        
        System.out.println("--columnas--");
        
        for(int i=0;i<arrayColumnas.size();i++){
            System.out.print("col: "+i);
           for(int j=0;j<nodo.getnColores();j++){
               Color auxColor = new Color();
               auxColor = (Color)arrayColumnas.get(i).getColor(j);
               System.out.print("|"+auxColor.getColor()+"-"+auxColor.getNumero()+"-"+auxColor.isSeguido()+"|");
           }
           System.out.println();
        }

        return true;
    }
    
    public boolean isFilaVacia(String [][] matriz, int fila){
        for(int i=0;i<matriz.length;i++){
            if(i==fila){    
                for(int j=0;j<matriz[0].length;j++){
                    if(matriz[i][j].equals(" ")) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isColumnaVacia(String [][] matriz, int columna){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(j==columna){    
                    if(matriz[i][j].equals(" ")) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isPosicionVaciaFila(String [][] matriz, int fila, int columna){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(j==columna && i==fila){    
                    if(matriz[i][j].equals(" ")) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isPosicionVaciaColumna(String [][] matriz, int fila, int columna){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(j==columna && i==fila){    
                    if(matriz[i][j].equals(" ")) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int [] actualizarPosicion(String [][] matriz,int numC,int numF){// se usa
        int [] vector = new int [2];
        vector[0]=-1;
        vector[1]=-1;
        
        for(int i=0;i<numF;i++){
            for(int j=0;j<numC;j++){
                if(!matriz[i][j].equals(" ")){
                }else{
                    vector[0]=i;
                    vector[1]=j;
                }
            }
        }
        
        if(vector[0]==-1 & vector[1]==-1){
            return null;
        }
        return vector;
    }
    
    public String [][] matrizModificada(String [][] matri,int [] vector,String color){// se usa
        String [][] matriAux = new String [matri.length][matri[0].length];
        
        for(int i=0;i<matri.length;i++){
            for(int j=0;j<matri[0].length;j++){
                
                if(vector[0]==i && vector[1]==j){
                    matriAux[i][j]=color;
                }else{
                    matriAux[i][j]=matri[i][j];
                }
            }
        }
        
        return matriAux;
    }
    

}
