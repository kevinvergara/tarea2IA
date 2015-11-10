
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
        
        
        
    }
    
}
