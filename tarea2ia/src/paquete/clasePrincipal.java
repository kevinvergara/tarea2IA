
package paquete;

import java.io.IOException;
import java.util.ArrayList;

public class clasePrincipal {

    public static void main(String[] args) throws IOException {
        //filas columnas
        ManejoArchivo archivo = new ManejoArchivo();
        
        Recorrido iterar = new Recorrido();
        iterar.buscarSolucion(archivo.numFilas(), archivo.numColumnas(), (ArrayList)archivo.cargarColumnas(),(ArrayList)archivo.cargarFilas());
        
        
    }
    
}
