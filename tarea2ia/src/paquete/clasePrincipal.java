
package paquete;

import java.io.IOException;

public class clasePrincipal {

    public static void main(String[] args) throws IOException {
        
        //filas columnas
        ManejoArchivo archivo = new ManejoArchivo();
        FuncionObjetivo fo = new FuncionObjetivo();
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
        raiz.setNivel(0);
        //--------
        Operadores operadores = new Operadores();
        
        Recorrido recorrido = new Recorrido();
        raiz = recorrido.recorrido(raiz);
        
        if(fo.solucion(raiz.getMatriz())){
           System.out.println("--solucion--");
           operadores.imprimirMatriz(raiz.getMatriz());
           System.out.println("--solucion--");
        }else{
        
        
        BackTracking back = new BackTracking();
        
        
        operadores.imprimirMatriz(back.back(raiz));
        }
    }
    
}
