package paquete;

import java.util.ArrayList;

public class Operadores {
    public String[][] pintarFilaCompleta(String [][] matriz,String color,int fila){
        
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[fila][i].equals(" ")){
                matriz[fila][i]=color;
            }
        }
        return (clonarMatriz(matriz));
    }
    
    public String[][] pintarColumnaCompleta(String [][] matriz,String color,int columna){
        for(int i=0;i<matriz[0].length;i++){
                if(matriz[i][columna].equals(" ")){
                    matriz[i][columna]=color;
                }
            }
        return (clonarMatriz(matriz));
    }
    
    //-------------acciones secundarias-------------------------------------
    public String [][] clonarMatriz(String [][] matriz){
        if(matriz==null) return null;
        
        String [][] matrizNueva = new String [matriz.length][matriz[0].length];
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                matrizNueva[i][j]=matriz[i][j];
            }
        }
        
        return matrizNueva;
    }
    
    public void imprimirMatriz(String [][] matriz){
        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    
    }
    //
    //retornar numeros vacios de fila
    public int numVaciosFila(String [][] matriz,int fila){
        int vacios=0; 
        
        for(int i=0;i<matriz.length;i++){
            if(matriz[fila][i].equals(" ")) vacios++;
        }
        
        return vacios;
    }
    
    public int numVaciosColumnas (String [][] matriz,int col){
        int vacios=0;
        
        for(int i=0;i<matriz[0].length;i++){
            if(matriz[i][col].equals(" ")) vacios++;
        }
        return vacios;
    }
    //espacios vacios en una matriz
    public int [] posicionVacia(Nodo nodo){
        int [] posicion = new int [2];
        
        for(int i=0;i<nodo.getMatriz().length;i++){
            for(int j=0;j<nodo.getMatriz()[0].length;j++){
                if(nodo.getMatriz()[i][j].equals(" ")){
                    posicion[0]=i;
                    posicion[1]=j;
                    if(coloresComunes(nodo,posicion)!=null){
                        return posicion;
                    }
                }
            }
        }
        return null;
    }
    //----------
    //colores comunes en una posicion
    public String [] coloresComunes(Nodo nodo,int [] posicion){
        ArrayList<String> auxColores = new ArrayList();
        
        ArrayListColumna columna = new ArrayListColumna();
        columna = (ArrayListColumna)nodo.getColumnas().get(posicion[1]);
        
        ArrayListFila fila = new ArrayListFila();
        fila = (ArrayListFila)nodo.getFilas().get(posicion[0]);
        //----------
        for(int i=0;i<nodo.getnColores();i++){
            if(fila.getColor(i).getNumero()!=0){
                if(columna.getColor(i).getNumero()!=0){
                    auxColores.add(columna.getColor(i).getColor());
                }
            }
        }
        
        
        
        
        if(auxColores.size() == 0) return null;
        
        String [] colores = new String [auxColores.size()];
        for(int i=0;i<auxColores.size();i++){
            colores[i] = (String)auxColores.get(i);
        }
        
        return colores;
    }
    //_-------------
    //return true si la matriz esta llena, si es false es que la matriz tiene espacios
    public boolean matrizLlena(String [][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(matriz[i][j].equals(" ")) return false;
            }
        }
        return true;
    }
    //--------------
    
    //modificar la matriz y los colores asociados, y crea el nuevo nodo
    public Nodo nuevoNodo (Nodo nodoActual, int [] posicion, String color){
        String nomColor;
        String [][] matriz = new String [nodoActual.getnFilas()][nodoActual.getnColumnas()];
        matriz = clonarMatriz(nodoActual.getMatriz());
        
        Nodo nodo = new Nodo();
        nodo = ((Nodo)nodoActual);
        
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.setNivel(nodo.getNivel()+1);
        nodoNuevo.setnColores(nodo.getnColores());
        nodoNuevo.setnColumnas(nodo.getnColumnas());
        nodoNuevo.setnFilas(nodo.getnFilas());
        
        //---nuevos arraylist
        ArrayList<ArrayListColumna> arrayColumnas = new ArrayList<ArrayListColumna>();
        //arrayColumnas = ((ArrayList<ArrayListColumna>)nodoActual.getColumnas());
        for(int i=0;i<nodo.getColumnas().size();i++){
            arrayColumnas.add(nodo.getColumnas().get(i));
        }
        ArrayList<ArrayListFila> arrayFilas = new ArrayList<ArrayListFila>();
        //arrayFilas = ((ArrayList<ArrayListFila>)nodoActual.getFilas());
        
        for(int i=0;i<nodo.getFilas().size();i++){
            arrayFilas.add(nodo.getFilas().get(i));
        }
        //---

        //...
        ArrayListColumna columna = new ArrayListColumna();
        columna = (ArrayListColumna)arrayColumnas.get(posicion[1]);
        
        ArrayListFila fila = new ArrayListFila();
        fila = (ArrayListFila)arrayFilas.get(posicion[0]);

        //...
        Color colorCol = new Color();
        colorCol = columna.getColor(color);
        
        colorCol.setNumero(colorCol.getNumero()-1);
        //...
        Color colorFil = new Color();
        colorFil = fila.getColor(color);
        
        colorFil.setNumero(colorFil.getNumero()-1);
        //...
        columna.replaceColor(colorCol);
                                        
        fila.replaceColor(colorFil);
        
        //...
        arrayColumnas.set(posicion[1], columna);
        arrayFilas.set(posicion[0], fila);
        //...
        nodoNuevo.setColumnas(arrayColumnas);
        nodoNuevo.setFilas(arrayFilas);
        //:..
        nomColor = colorFil.getColor();
        
        matriz[posicion[0]][posicion[1]] = nomColor;
        
        nodoNuevo.setMatriz(clonarMatriz(matriz));
        
        return nodoNuevo;
    }
    ///
    public boolean imprimirNodo(Nodo nodo){
        if(nodo==null) return false;
        System.out.println("----------Nodo-----------");
        this.imprimirMatriz(nodo.getMatriz());
        
        ArrayList<ArrayListColumna> arrayColumnas = new ArrayList<ArrayListColumna>();
        arrayColumnas = (ArrayList<ArrayListColumna>)nodo.getColumnas();
        
        ArrayList<ArrayListFila> arrayFilas = new ArrayList<ArrayListFila>();
        arrayFilas = (ArrayList<ArrayListFila>)nodo.getFilas();
        
                
        System.out.println("--filas--");
        
        for(int i=0;i<arrayFilas.size();i++){
            System.out.print("fil: "+i);
           for(int j=0;j<nodo.getnColores();j++){
               Color auxColor = new Color();
               auxColor = (Color)arrayFilas.get(i).getColor(j);
               System.out.print("|"+auxColor.getColor()+"-"+auxColor.getNumero()+"-"+auxColor.isSeguido()+"|");
           }
           System.out.println();
        }
        
        
        System.out.println("--columnas--");
        
        for(int i=0;i<arrayColumnas.size();i++){
            System.out.print("col: "+i);
           for(int j=0;j<nodo.getnColores();j++){
               Color auxColor = new Color();
               auxColor = (Color)arrayColumnas.get(i).getColor(j);
               System.out.print("|"+auxColor.getColor()+"-"+auxColor.getNumero()+"-"+auxColor.isSeguido()+"|");
           }
           System.out.println();
        }

        return true;
    }
}
