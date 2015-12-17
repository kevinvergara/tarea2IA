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
            
            nodo.setCambio(0);
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
                            nodo.setCambio(1);
                            //System.out.println("fgasf: filas");
                            matriz = operadores.pintarFilaCompleta(matriz,auxColor.getColor(),i).clone();

                            ((ArrayListFila)filas.get(i)).getColor(j).setNumero(0);
                            for(int x=0;x<numColumnas;x++){
                                if(((ArrayListColumna)columnas.get(x)).getColor(j).getNumero()!=0){    
                                    ((ArrayListColumna)columnas.get(x)).getColor(j).setNumero((((ArrayListColumna)columnas.get(x)).getColor(j).getNumero())-1);
                                }
                            }
                            System.out.println("-----");
                            operadores.imprimirMatriz(matriz);
                            System.out.println("-----");
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
                            nodo.setCambio(1);
                            //System.out.println("skdf: columnas");
                            matriz = operadores.pintarColumnaCompleta(matriz, auxColor.getColor(), i).clone();
                            
                            ((ArrayListColumna)columnas.get(i)).getColor(j).setNumero(0);
                            
                            for(int x=0;x<numFilas;x++){
                                if(((ArrayListFila)filas.get(x)).getColor(j).getNumero()!=0){
                                    ((ArrayListFila)filas.get(x)).getColor(j).setNumero((((ArrayListFila)filas.get(x)).getColor(j).getNumero())-1);
                                }
                            }
                            System.out.println("-----");
                            operadores.imprimirMatriz(matriz);
                            System.out.println("-----");
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
        System.out.println("----------------inicio heuristica dosnoseguidos--------------");
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
        
        ArrayListFila auxListFila = new ArrayListFila();
        ArrayListColumna auxListColumna = new ArrayListColumna();
        
        int cambio=1;
        
        while(cambio!=0){
            cambio=0;
            
            nodo.setCambio(0);
            for(int i = 0;i<numFilas;i++){
                if(operadores.isFilaVacia(nodo.getMatriz(), i) == true){
                    //filas
                    auxListFila = (ArrayListFila)filas.get(i);

                    int contadorColores = 0;
                    for(int j=0;j<numColores;j++){
                        Color auxColor = new Color();
                        auxColor = auxListFila.getColor(j);
                        if(auxColor.getNumero() > 0){
                            contadorColores++;
                        }
                    }//fin color


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
                                        cambio=1;
                                        nodo.setCambio(1);
                                        //pinta los extremos de la fila
                                        matriz = operadores.pintarPosicion(matriz,i, (numColumnas-1), auxColor1.getColor());
                                        
                                        matriz = operadores.pintarPosicion(matriz, i, 0, auxColor1.getColor());
                                        
                                        //pinta el resto de la fila
                                        matriz = operadores.pintarFilaCompleta(matriz, auxColor2.getColor(), i);
                                        //descuenta los colores en las filas
                                        auxColor1.setNumero(0);
                                        auxColor2.setNumero(0);
                                        
                                        //descontar colores en las columnas
                                        for(int c=0;c<numColumnas;c++){
                                            auxListColumna = (ArrayListColumna)columnas.get(c);
                                            
                                            if(c == 0){
                                                for(int c1=0;c1<numColores;c1++){
                                                    Color auxColorc1 = new Color();
                                                    auxColorc1 = auxListColumna.getColor(c1);
                                                    
                                                    if(auxColorc1.getColor().equals(auxColor1.getColor())){
                                                        auxColorc1.setNumero(auxColorc1.getNumero()-1);
                                                    }
                                                    
                                                }
                                            }else if(c == (numColumnas-1)){
                                                for(int c1=0;c1<numColores;c1++){
                                                    Color auxColorc1 = new Color();
                                                    auxColorc1 = auxListColumna.getColor(c1);
                                                    
                                                    if(auxColorc1.getColor().equals(auxColor1.getColor())){
                                                        auxColorc1.setNumero(auxColorc1.getNumero()-1);
                                                    }
                                                }
                                            }else{
                                                for(int c1=0;c1<numColores;c1++){
                                                    Color auxColorc1 = new Color();
                                                    auxColorc1 = auxListColumna.getColor(c1);
                                                    
                                                    if(auxColorc1.getColor().equals(auxColor2.getColor())){
                                                        auxColorc1.setNumero(auxColorc1.getNumero()-1);
                                                    }
                                                }
                                            
                                            }
                                            
                                        }
                                        
                                        nodo.setMatriz(matriz.clone());
                                        System.out.println("-----");
                                        operadores.imprimirMatriz(nodo.getMatriz());
                                        System.out.println("-----");
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
                    auxListColumna = (ArrayListColumna)columnas.get(i);

                    int contadorColores = 0;
                    for(int j=0;j<numColores;j++){
                        Color auxColor = new Color();
                        auxColor = auxListColumna.getColor(j);
                        if(auxColor.getNumero() > 0){
                            contadorColores++;
                        }    
                    }//fin color
                    if(contadorColores == 2){//esto quiere decir que hay dos colores disponibles para usar en la matriz
                        //ahora hay que ver si uno de los dos es igual a 2 y false
                        for(int j1=0;j1<numColores;j1++){
                            Color auxColor1 = new Color();
                            auxColor1 = auxListColumna.getColor(j1);

                            if(auxColor1.getNumero() == 2 && auxColor1.isSeguido() == false){
                                for(int j2=0;j2<numColores;j2++){
                                    Color auxColor2 = new Color();
                                    auxColor2 = auxListColumna.getColor(j2);
                                    if(auxColor2.isSeguido() == true){
                                        cambio=1;
                                        nodo.setCambio(1);
                                        matriz = operadores.pintarPosicion(matriz,(numFilas-1), i, auxColor1.getColor());
                                        matriz = operadores.pintarPosicion(matriz, 0, i, auxColor1.getColor());
                                        
                                        matriz = operadores.pintarColumnaCompleta(matriz, auxColor2.getColor(), i);
                                        
                                        auxColor1.setNumero(0);
                                        auxColor2.setNumero(0);
                                        
                                        
                                        //descontar colores en las columnas
                                        for(int f=0;f<numFilas;f++){
                                            auxListFila = (ArrayListFila)filas.get(f);
                                            
                                            if(f == 0){
                                                for(int f1=0;f1<numColores;f1++){
                                                    Color auxColorf1 = new Color();
                                                    auxColorf1 = auxListFila.getColor(f1);
                                                    
                                                    if(auxColorf1.getColor().equals(auxColor1.getColor())){
                                                        auxColorf1.setNumero(auxColorf1.getNumero()-1);
                                                    }
                                                    
                                                }
                                            }else if(f == (numColumnas-1)){
                                                for(int f1=0;f1<numColores;f1++){
                                                    Color auxColorf1 = new Color();
                                                    auxColorf1 = auxListFila.getColor(f1);
                                                   
                                                    if(auxColorf1.getColor().equals(auxColor1.getColor())){
                                                        auxColorf1.setNumero(auxColorf1.getNumero()-1);
                                                    }
                                                    
                                                }
                                            }else{
                                                for(int f1=0;f1<numColores;f1++){
                                                    Color auxColorf1 = new Color();
                                                    auxColorf1 = auxListFila.getColor(f1);
                                                    
                                                    if(auxColorf1.getColor().equals(auxColor2.getColor())){
                                                        auxColorf1.setNumero(auxColorf1.getNumero()-1);
                                                    }
                                                }
                                            
                                            }
                                            
                                        }
                                        
                                        nodo.setMatriz(matriz.clone());
                                        System.out.println("-----");
                                        operadores.imprimirMatriz(nodo.getMatriz());
                                        System.out.println("-----");
                                    }
                                }
                            }
                        }//fin color
                    }
                }
            }//fin columnas
        }//fin while principal
        
        System.out.println("---------------final heuristica dosnoseguidos---------------");
        return nodo;
    }
    //fin heuristica
    
    
    //inicio de: qe un color con cierto numero, tenga los espacios justo pa pintar, idnependiente los demas colores
    public Nodo espaciosJustos(Nodo nodo){
        System.out.println("----------------inicio heuristica espaciosJustos--------------");
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
        
        ArrayListFila auxListFila = new ArrayListFila();
        ArrayListColumna auxListColumna = new ArrayListColumna();
        
        int cambio=1;
        int changue=0;
        while(cambio!=0){
            cambio=0;
            
            nodo.setCambio(0);
            for(int i=0;i<numFilas;i++){
                auxListFila = (ArrayListFila)filas.get(i);
                for(int j=0;j<numColores;j++){
                    Color auxColor = new Color();
                    auxColor = auxListFila.getColor(j);

                    if(auxColor.getNumero() > 0){
                        int contador=0;
                        for(int c=0;c<numColumnas;c++){
                            auxListColumna=(ArrayListColumna)columnas.get(c);

                            for(int j1=0;j1<numColores;j1++){
                                Color auxColor1 = new Color();
                                auxColor1 = auxListColumna.getColor(j1);
                                if(auxColor1.getNumero() > 0){
                                    if(auxColor.getColor().equals(auxColor1.getColor()) && operadores.isPosicionVaciaFila(nodo.getMatriz(), i, c)){
                                        contador++;
                                    }
                                }
                            }
                        }
                        
                        if(auxColor.getNumero() == contador){
                            changue=1;
                            cambio=1;
                            auxColor.setNumero(0);
                            for(int c=0;c<numColumnas;c++){
                            auxListColumna=(ArrayListColumna)columnas.get(c);

                                for(int j1=0;j1<numColores;j1++){
                                    Color auxColor1 = new Color();
                                    auxColor1 = auxListColumna.getColor(j1);
                                    if(auxColor1.getNumero() > 0){
                                        if(auxColor.getColor().equals(auxColor1.getColor()) && operadores.isPosicionVaciaFila(nodo.getMatriz(), i, c)){
                                         
                                            auxColor1.setNumero(auxColor1.getNumero()-1);

                                            matriz = operadores.pintarPosicion(matriz, i, c, auxColor.getColor());

                                            nodo.setMatriz(matriz);
                                        }
                                    }
                                }
                            }
                            System.out.println("-----");
                            operadores.imprimirMatriz(nodo.getMatriz());
                            System.out.println("-----");
                            
                            
                        }
                    }
                }
            }
            
        }
        if(changue==1) nodo.setCambio(1);
        System.out.println("----------------fin heuristica espaciosJustos-------------- ");
        return (Nodo)nodo;
    }
     
}
