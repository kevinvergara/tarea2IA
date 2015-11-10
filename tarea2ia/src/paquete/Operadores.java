package paquete;

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
    public int numVaciosMatriz(String [][] matriz){
        int contador=0;
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(matriz[i][j].equals(" ")){
                    contador++;
                }
            }
        }
        return contador;
    }
}
