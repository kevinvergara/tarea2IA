
package paquete;

import java.io.IOException;
import java.util.ArrayList;

public class clasePrincipal {

    public static void main(String[] args) throws IOException {
        
        //filas columnas
        ManejoArchivo archivo = new ManejoArchivo();
        
        //matriz
        String [][] matriz = new String[archivo.numFilas()][archivo.numColumnas()];
        
        for(int i=0;i<archivo.numFilas();i++){
            for(int j=0;j<archivo.numColumnas();j++){
                matriz[i][j]=" ";
            }
        }
        
        //crear nodo raiz
        Nodo raiz = new Nodo();
        
        raiz.setColumnas(archivo.cargarColumnas());
        raiz.setFilas(archivo.cargarFilas());
        raiz.setMatriz(matriz);
        raiz.setnColores(archivo.numColores());
        raiz.setnColumnas(archivo.numColumnas());
        raiz.setnFilas(archivo.numFilas());
        //_-----
        
        DFS dfs = new DFS();
        dfs.dfs(raiz);
        
    }
    
}
