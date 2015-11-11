package paquete;

import java.util.ArrayList;

public class Heuristica {
    
    public Nodo colorIgualVacio(Nodo nodo){
        
        Operadores operadores = new Operadores();
        //variables de matriz
        int numFilas,numColumnas,numColores;
        
        numColumnas = nodo.getnColumnas();
        numFilas = nodo.getnFilas();
        numColores = nodo.getnColores();
        
        String [][] matriz = new String [numFilas][numColumnas];
        matriz = operadores.clonarMatriz(nodo.getMatriz());
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
                //System.out.println("procesando filas");
                ArrayListFila auxListFila = new ArrayListFila();
                auxListFila = (ArrayListFila)filas.get(i);
                
                for(int j=0;j<numColores;j++){
                    Color auxColor = new Color();
                    auxColor = auxListFila.getColor(j);
                    //System.out.println("ncolor :"+auxColor.getNumero()+" nvacios: "+operadores.numVaciosFila(matriz, i));
                    if(auxColor.getNumero()!=0 && operadores.numVaciosFila(matriz, i)!=0){
                        if(auxColor.getNumero() == operadores.numVaciosFila(matriz, i)){
                            cambio=1;
                            //System.out.println("fgasf: filas");
                            matriz = operadores.pintarFilaCompleta(matriz,auxColor.getColor(),i).clone();

                            ((ArrayListFila)filas.get(i)).getColor(j).setNumero(0);
                            for(int x=0;x<numColumnas;x++){
                                if(((ArrayListColumna)columnas.get(x)).getColor(j).getNumero()!=0){    
                                    ((ArrayListColumna)columnas.get(x)).getColor(j).setNumero((((ArrayListColumna)columnas.get(x)).getColor(j).getNumero())-1);
                                }
                            }
                            System.out.println("-----------------");
                            operadores.imprimirMatriz(matriz);
                            System.out.println("-----------------");
                        }
                    }
                }
            }
            
            for(int i = 0;i<numColumnas;i++){
                //columnas
                //System.out.println("procesando columnas");
                ArrayListColumna auxListColumna = new ArrayListColumna();
                auxListColumna = (ArrayListColumna)columnas.get(i);
                
                for(int j=0;j<numColores;j++){
                    Color auxColor = new Color();
                    auxColor = auxListColumna.getColor(j);
                    //System.out.println("ncolor :"+auxColor.getNumero()+" nvacios: "+operadores.numVaciosColumnas(matriz, i));
                    if(auxColor.getNumero()!=0 && operadores.numVaciosColumnas(matriz, i)!=0){    
                        if(auxColor.getNumero() == operadores.numVaciosColumnas(matriz, i)){
                            cambio = 1;
                            //System.out.println("skdf: columnas");
                            matriz = operadores.pintarColumnaCompleta(matriz, auxColor.getColor(), i).clone();
                            
                            ((ArrayListColumna)columnas.get(i)).getColor(j).setNumero(0);
                            
                            for(int x=0;x<numFilas;x++){
                                if(((ArrayListFila)filas.get(x)).getColor(j).getNumero()!=0){
                                    ((ArrayListFila)filas.get(x)).getColor(j).setNumero((((ArrayListFila)filas.get(x)).getColor(j).getNumero())-1);
                                }
                            }
                            System.out.println("-----------------");
                            operadores.imprimirMatriz(matriz);
                            System.out.println("-----------------");
                        }
                    }
                }
            
            }
        }//fin while principal
        
        
        nodo.setColumnas(columnas);
        nodo.setFilas(filas);
        nodo.setMatriz(operadores.clonarMatriz(matriz));
        
        return nodo;
    }
}
