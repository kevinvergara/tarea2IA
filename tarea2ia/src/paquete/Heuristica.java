package paquete;

import java.io.IOException;
import java.util.ArrayList;

public class Heuristica {
    
    public Nodo colorIgualVacio(Nodo nodo){
        System.out.println("-------------inicio heursitica vacio=color-----------------");
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
                            System.out.println("---");
                            operadores.imprimirMatriz(matriz);
                            System.out.println("---");
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
                            System.out.println("---");
                            operadores.imprimirMatriz(matriz);
                            System.out.println("---");
                        }
                    }
                }
            
            }
        }//fin while principal
        
        
        nodo.setColumnas(columnas);
        nodo.setFilas(filas);
        nodo.setMatriz(operadores.clonarMatriz(matriz));
        System.out.println("-------------final heursitica vacios=color-----------------");
        return nodo;
    }
    
    //dos colores disponibles, dos no seguidos, y el resto seguidos
    
    public Nodo dosNoSeguidos(Nodo nodo) throws IOException{
        System.out.println("------------------------------");
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
        
        int cambio=1;
        
        while(cambio!=0){
            cambio=0;
            
            for(int i = 0;i<numFilas;i++){
                if(operadores.isFilaVacia(nodo.getMatriz(), i) == true){
                    //filas 
                    System.out.println("procesando filas");
                    ArrayListFila auxListFila = new ArrayListFila();
                    auxListFila = (ArrayListFila)filas.get(i);

                    int contadorColores = 0;
                    for(int j=0;j<numColores;j++){
                        Color auxColor = new Color();
                        auxColor = auxListFila.getColor(j);
                        System.out.println("color "+j+" : "+auxColor.getColor()+" num: "+auxColor.getNumero());
                        if(auxColor.getNumero() > 0){
                            contadorColores++;
                        }
                    }//fin color

                    System.out.println("asfasdfasdfasdfasdf: "+contadorColores);

                    if(contadorColores == 2){//esto quiere decir que hay dos colores disponibles para usar en la matriz
                        //ahora hay que ver si uno de los dos es igual a 2 y false
                        for(int j1=0;j1<numColores;j1++){
                            Color auxColor1 = new Color();
                            auxColor1 = auxListFila.getColor(j1);

                            if(auxColor1.getNumero() == 2 && auxColor1.isSeguido() == false){
                                for(int j2=0;j2<numColores;j2++){
                                    Color auxColor2 = new Color();
                                    auxColor2 = auxListFila.getColor(j2);

                                    if(auxColor2.isSeguido() == true){
                                        System.out.println("seee chuchetumare segundo color");
                                        //pinta los extremos de la fila
                                        matriz = operadores.pintarPosicion(matriz,(numFilas-1), i, auxColor1.getColor());
                                        matriz = operadores.pintarPosicion(matriz, 0, i, auxColor1.getColor());
                                        //pinta el resto de la fila
                                        matriz = operadores.pintarFilaCompleta(matriz, auxColor2.getColor(), i);
                                        //descuenta los colores en las filas
                                        auxColor1.setNumero(0);
                                        auxColor2.setNumero(0);
                                        
                                        //descontar colores en las columnas
                                        for(int c=0;c<numColumnas;c++){
                                            
                                        }
                                        
                                        nodo.setMatriz(matriz.clone());
                                        
                                        operadores.imprimirNodo(nodo);
                                        cambio=1;
                                    }
                                }
                            }
                        }//fin color
                    }
                }//fin isfilaVacia
            }//fin filas
            
            
            //---------columnas
            for(int i = 0;i<numColumnas;i++){
                if(operadores.isColumnaVacia(nodo.getMatriz(), i) == true){    
                    //columnas
                    System.out.println("procesando columnas");
                    ArrayListColumna auxListColumna = new ArrayListColumna();
                    auxListColumna = (ArrayListColumna)columnas.get(i);

                    int contadorColores = 0;
                    for(int j=0;j<numColores;j++){
                        Color auxColor = new Color();
                        auxColor = auxListColumna.getColor(j);
                        System.out.println("color "+j+" : "+auxColor.getColor()+" num: "+auxColor.getNumero());
                        if(auxColor.getNumero() > 0){
                            contadorColores++;
                        }    
                    }//fin color
                    System.out.println("asfasdfasdfasdfasdf: "+contadorColores);
                    if(contadorColores == 2){//esto quiere decir que hay dos colores disponibles para usar en la matriz
                        //ahora hay que ver si uno de los dos es igual a 2 y false
                        for(int j1=0;j1<numColores;j1++){
                            Color auxColor1 = new Color();
                            auxColor1 = auxListColumna.getColor(j1);

                            if(auxColor1.getNumero() == 2 && auxColor1.isSeguido() == false){
                                System.out.println("seee chuchetumare color 2 no seguid0");
                                for(int j2=0;j2<numColores;j2++){
                                    Color auxColor2 = new Color();
                                    auxColor2 = auxListColumna.getColor(j2);
                                    if(auxColor2.isSeguido() == true){
                                        System.out.println("seee chuchetumare segundo color");
                                        matriz = operadores.pintarPosicion(matriz,(numColumnas-1), i, auxColor1.getColor());
                                        matriz = operadores.pintarPosicion(matriz, 0, i, auxColor1.getColor());
                                        
                                        matriz = operadores.pintarColumnaCompleta(matriz, auxColor2.getColor(), i);
                                        
                                        auxColor1.setNumero(0);
                                        auxColor2.setNumero(0);
                                        
                                        nodo.setMatriz(matriz.clone());
                                        
                                        operadores.imprimirNodo(nodo);
                                        cambio=1;
                                    }
                                }
                            }
                        }//fin color
                    }
                }
            }//fin columnas
            
        System.out.println("dsge: "+cambio);
        System.in.read();
        }//fin while principal
        
        System.out.println("------------------------------");
        return nodo;
    }
}
