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
            System.out.println(cadena);
            ArrayListColumna auxColumna = new ArrayListColumna();
            for(int j=0;j<cadena.length();j=j+7){
                Color auxColor = new Color();
                auxColor.setColor(""+cadena.charAt(j));
                if(!(cadena.charAt(j+2)+"").equals("0")){
                    String auxChar = cadena.charAt(j+2)+cadena.charAt(j+3)+"";
                    auxColor.setNumero(Integer.parseInt(auxChar));
                }else{
                    auxColor.setNumero(Integer.parseInt((cadena.charAt(j+3)+"")));
                }
                //seguido o no
                if((cadena.charAt(j+5)+"").equals("t")){
                    auxColor.setSeguido(true);
                }else if((cadena.charAt(j+5)+"").equals("f")){
                    auxColor.setSeguido(false);
                }
                System.out.print(auxColor.getColor()+"-"+auxColor.getNumero()+"\n");
                auxColumna.setColor(auxColor);
            }
            System.out.println();
            columnas.add((ArrayListColumna)auxColumna);
        }
        b.close();
        return columnas;
    }
    
    
}
