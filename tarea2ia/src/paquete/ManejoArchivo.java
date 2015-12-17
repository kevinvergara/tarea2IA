package paquete;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManejoArchivo {

    public ArrayList cargarColumnas() throws FileNotFoundException, IOException{
        ArrayList<ArrayListColumna> columnas = new ArrayList();//almacenar los objetos ArrayListColumnas
        
        
        String cadena;
        String archivo = "C:\\Users\\kevin\\Documents\\NetBeansProjects\\tarea2IA\\tarea2ia\\archivos\\vectoresIniciales.txt";
     

        //System.out.println("columnas");

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        int numFilas = Integer.parseInt(b.readLine());//fi
        int numColumnas = Integer.parseInt(b.readLine());//col
        int numColores = Integer.parseInt(b.readLine());//colores
        b.readLine();//relleno
        
        
        for(int i=0;i<numColumnas;i++){
            cadena = b.readLine();
            //System.out.println(cadena);
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
                //System.out.print(auxColor.getColor()+"-"+auxColor.getNumero()+"-"+auxColor.isSeguido()+"\n");
                
                auxColumna.setColor(auxColor);
            }
            //System.out.println();
            columnas.add((ArrayListColumna)auxColumna);
        }
        b.close();
        return columnas;
    }
    
    public ArrayList cargarFilas() throws FileNotFoundException, IOException{
        ArrayList<ArrayListFila> filas = new ArrayList();//almacenar los objetos ArrayListColumnas
        
        
        String cadena;
        String archivo = "C:\\Users\\kevin\\Documents\\NetBeansProjects\\tarea2IA\\tarea2ia\\archivos\\vectoresIniciales.txt";
     
        //System.out.println("filas");

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        int numFilas = Integer.parseInt(b.readLine());//fi
        int numColumnas = Integer.parseInt(b.readLine());//col
        int numColores = Integer.parseInt(b.readLine());//colores
        b.readLine();//relleno
        
        while(!(b.readLine().equals("---------fila----------"))){
            //para llegar a las filas
        }
        
        for(int i=0;i<numFilas;i++){
            cadena = b.readLine();
            //System.out.println(cadena);
            ArrayListFila auxFila = new ArrayListFila();
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
                //System.out.print(auxColor.getColor()+"-"+auxColor.getNumero()+"-"+auxColor.isSeguido()+"\n");
                
                auxFila.setColor(auxColor);
            }
            
            //System.out.println();
            filas.add((ArrayListFila)auxFila);
        }
        b.close();
        return filas; 
    }
    
    public int numFilas() throws FileNotFoundException, IOException{
        String archivo = "C:\\Users\\kevin\\Documents\\NetBeansProjects\\tarea2IA\\tarea2ia\\archivos\\vectoresIniciales.txt";


        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        int numFilas = Integer.parseInt(b.readLine());//fi
        int numColumnas = Integer.parseInt(b.readLine());//col
        
        
        return numFilas;
    }
    
    public int numColumnas() throws FileNotFoundException, IOException{
        String archivo = "C:\\Users\\kevin\\Documents\\NetBeansProjects\\tarea2IA\\tarea2ia\\archivos\\vectoresIniciales.txt";

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        int numFilas = Integer.parseInt(b.readLine());//fi
        int numColumnas = Integer.parseInt(b.readLine());//col
        
        
        return numColumnas;
    }
    
    public int numColores() throws FileNotFoundException, IOException{
        String archivo = "C:\\Users\\kevin\\Documents\\NetBeansProjects\\tarea2IA\\tarea2ia\\archivos\\vectoresIniciales.txt";

        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        b.readLine();//fi
        b.readLine();//col
        int colores = Integer.parseInt(b.readLine());//colores
        
        
        return colores;
    
    }
}
