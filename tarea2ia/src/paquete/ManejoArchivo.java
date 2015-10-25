package paquete;

import paquete.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManejoArchivo {

    public ArrayList cargarColumnas() throws FileNotFoundException, IOException{
        ArrayList columnas = new ArrayList();//almacenar los objetos ArrayListColumnas
        
        
        String cadena;
        String archivo = "/home/kvergara/NetBeansProjects/tarea2IA/tarea2ia/archivos/vectoresIniciales.txt";
     


        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        b.readLine();//fi
        int numColumnas = Integer.parseInt(b.readLine());//col
        int numColores = Integer.parseInt(b.readLine());//colores
        b.readLine();//relleno
        
        
        for(int i=0;i<numColumnas;i++){
            cadena = b.readLine();
            ArrayListColumna auxColumna = new ArrayListColumna();
            for(int j=0;j<numColores;j++){
                Color auxColor = new Color();
                
                
                
            }
            columnas.add((ArrayListColumna)auxColumna);
        }
        
        return columnas;
    }
    
    
}
